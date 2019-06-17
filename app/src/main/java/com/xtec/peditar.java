package com.xtec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

//clase encargado de mostrar las opciones editar perfil, eliminar cuenta, editar carros
public class peditar extends AppCompatActivity {

    private Button btn_ep;
    private Button btn_ec;
    private Button btn_eca;
    private ImageButton btn_notificacion;
    private ImageButton btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peditar);

        editar_perfil();
        eliminar_cuenta();
        editar_carros();
        home();
        notificacion();
    }

    //metodo que maneja el boton de editar perfil, se despliega la pantalla de editar la informacion ingresada por el usuario
    public void editar_perfil(){
        btn_ep = (Button) findViewById(R.id.btn_ep);
        btn_ep.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent perfil = new Intent (v.getContext(), peditaarInfo.class);
                startActivityForResult(perfil, 0);
            }
        });
    }

    //metodo que maneja el boton de elimina la cuenta del usuario,
    //se despliega la pantalla donde se le pregunta al usuario si realmente desea eliminar la cuenta
    public void eliminar_cuenta(){
        btn_ec = (Button) findViewById(R.id.btn_ec);
        btn_ec.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent eliminar = new Intent (v.getContext(), peliminarCuenta.class);
                startActivityForResult(eliminar, 0);
            }
        });
    }

    //metodo que maneja el boton de los carros que el tiene registrados,
    //se despliega la pantalla de donde se despliegan todos los carros que tiene el usuario
    public void editar_carros(){
        btn_eca = (Button) findViewById(R.id.btn_eca);
        btn_eca.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent carros = new Intent (v.getContext(), pcarros.class);
                startActivityForResult(carros, 0);
            }
        });
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
        btn_notificacion = (ImageButton) findViewById(R.id.btn_notifiacion);
        btn_notificacion.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent notificacion = new Intent (v.getContext(), pantalla_principal.class);
                startActivityForResult(notificacion, 0);
            }
        });
    }
}
