package com.xtec;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.xtec.auth.RequestManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class pvalidarDATIC2 extends AppCompatActivity {
    private EditText ip_id;
    private EditText ip_contraseña;
    private Button btn_ingresar;
    private ImageButton btn_atras;

    public static String getClaveDatic;

    private String jsonDatic;
    private String jsonDB;

    private String parameter;
    private int consulta;
    private String id;
    private String clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvalidar_datic);

        btn_atras = (ImageButton) findViewById(R.id.btn_atras);
        btn_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atras = new Intent (v.getContext(), pingresar.class);
                startActivityForResult(atras, 0);
            }
        });
        changeTextOnce();
    }

    public void changeTextOnce(){
        ip_id = (EditText)findViewById(R.id.ip_id);
        ip_contraseña = (EditText)findViewById(R.id.ip_contraseña);
        btn_ingresar = (Button) findViewById(R.id.btn_ingresar);

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ip_id.getText().toString().isEmpty() || ip_contraseña.getText().toString().isEmpty()) {
                    datosIncompletos();
                }
                else {
                    id = ip_id.getText().toString();
                    parameter = id;
                    clave = ip_contraseña.getText().toString();
                    try {
                        consulta = 1;
                        jsonDatic = new HttpConsult().execute().get();
                        consulta = 2;
                        jsonDB = new HttpConsult().execute().get();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (!verificar_DB()) {
                        RequestManager.GET(1, jsonDatic);
                        if (verificar_DATIC(clave)) {
                            Intent atras = new Intent(v.getContext(), pregistarse.class);
                            startActivityForResult(atras, 0);
                        } else {
                            usuarioInvalidoDatic();
                        }
                    } else {
                        usuarioExisteDB();
                    }
                }
            }
        });
    }

    public void datosIncompletos(){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Error");
        dialogo.setMessage("Existe campos incompletos, por favor completarlos.");
        dialogo.setCancelable(false);
        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id) {
            }
        });
        dialogo.show();
    }
    private void usuarioInvalidoDatic(){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Error");
        dialogo.setMessage("Usuario o clave inválida de DATIC.");
        dialogo.setCancelable(false);
        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id) {
            }
        });
        dialogo.show();
    }

    private void usuarioExisteDB(){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Error");
        dialogo.setMessage("Ya existe el usuario en la aplicación.");
        dialogo.setCancelable(false);
        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id) {
            }
        });
        dialogo.show();
    }

    public boolean verificar_DATIC(String pClave) {
        if (pClave.compareTo(getClaveDatic) == 0 && jsonDatic.compareTo("[]") != 0) {
            getClaveDatic = "";
            RequestManager.ID = id;
            return true;
        }
        else {
            return false;
        }
    }
    public boolean verificar_DB() {
        return (jsonDB.compareTo("[]") != 0) ? true : false;
    }

    private class HttpConsult extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            URL url;
            BufferedReader reader=null;
            StringBuilder builder=null;
            try {
                if (consulta == 1) {
                    url = new URL("https://daticwebapi22019.azurewebsites.net/api/Usuarios/" + parameter);
                }
                else  {
                    url = new URL("https://carpoolingtecwebapi22019.azurewebsites.net/api/Usuario/Get/" + parameter);
                }
                builder = new StringBuilder();
                reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                for (String line; (line = reader.readLine()) != null;) {
                    builder.append(line.trim());
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) try { reader.close(); } catch (IOException logOrIgnore) {}
            }
            return builder.toString();
        }
    }
}


