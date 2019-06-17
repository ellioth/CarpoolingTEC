package com.xtec;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

//esta clase se encarga de mostrar la informacion que el usuario ingreso cuando se registro, con el din que ssi el usuario desea
//editar la informacion lo pueda hacer.
public class peditaarInfo extends AppCompatActivity {

    private ImageButton btn_home;
    private ImageButton btn_notificaciones;
    private EditText ip_name;
    private EditText ip_PA;
    private EditText ip_SA;
    private EditText ip_correo;
    private EditText ip_telefono;
    private ImageButton btn_plus;
    private Button btn_guardar;

    //metodo pricniapl del activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peditaar_info);

        home();
        notificacion();
    }

    //metodo encargado del boton home, cuando se presiona se devuelve a la pantalla princial
    public void home(){
        btn_home = (ImageButton) findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent home = new Intent (v.getContext(), pantalla_principal.class);
                startActivityForResult(home, 0);
            }
        });
    }

    //metodo encargardo del boton notificaciones, cuando se pressiona muestra las notificaciones que el usuario tiene
    public void notificacion(){
        btn_notificaciones = (ImageButton) findViewById(R.id.btn_notifiacion);
        btn_notificaciones.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent notificacion = new Intent (v.getContext(), pantalla_principal.class);
                startActivityForResult(notificacion, 0);
            }
        });
    }

    //metodo encragado de la logica de guardar cuando la informacion en la base de datos de la aplicacion
    public void guardar(){
        btn_guardar = (Button) findViewById(R.id.btn_guardar);
        btn_guardar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent notificacion = new Intent (v.getContext(), pantalla_principal.class);
                startActivityForResult(notificacion, 0);
            }
        });
    }

    public void changeTextOnce(){
        ip_name = (EditText)findViewById(R.id.ip_Nombre);
        ip_PA = (EditText)findViewById(R.id.ip_PA);
        ip_SA = (EditText)findViewById(R.id.ip_SA);
        ip_correo = (EditText)findViewById(R.id.ip_correo);
        ip_telefono = (EditText)findViewById(R.id.ip_telefono);
        btn_guardar = (Button) findViewById(R.id.btn_guardar);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (ip_name.getText().toString().isEmpty() || ip_PA.getText().toString().isEmpty()
                        || ip_SA.getText().toString().isEmpty() || ip_correo.getText().toString().isEmpty()
                        || ip_telefono.getText().toString().isEmpty()) {
                    Intent atras = new Intent(v.getContext(), p_preguntaCarro.class);
                    startActivityForResult(atras, 0);

                    //datosIncompletos();

                }
                /*if (!ip_id.getText().toString().isEmpty()){
                    Toast toast1 = Toast.makeText(getApplicationContext(), "entre", Toast.LENGTH_SHORT);
                    toast1.show();
                }*/
            }
        });
    }

    //este muestra un mensaje un mensaje indicando al usuario que existe al menos un campo vacio
    public void datosIncompletos(){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Error");
        dialogo.setMessage("Existe campos incompletos, por favor completarlos");
        dialogo.setCancelable(false);
        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id) {
            }
        });
        dialogo.show();
    }
}
