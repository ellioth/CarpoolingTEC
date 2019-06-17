package com.xtec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


//esta la clase es la encargada del activity pantalla_principal
public class pantalla_principal extends AppCompatActivity {

    private ImageButton btn_notificacion;
    private ImageButton btn_viaje;
    private ImageButton btn_amigos;
    private ImageButton btn_CP;
    private ImageButton btn_configuracion;
    private ImageButton btn_historial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        notificaciones();
        viajes();
        amigos();
        canjear_puntos();
        configuraciones();
        historial();

    }

    //metodo encargado de manejar la logica del boton notificaiones con el fin que cuando se presione
    //el boton se despliegue el activity correspondiente
    public void notificaciones(){
        btn_notificacion = (ImageButton) findViewById(R.id.btn_notificaciones);
        btn_notificacion.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent notificacion = new Intent (v.getContext(), pantalla_principal.class);
                startActivityForResult(notificacion, 0);
            }
        });
    }

    //metodo encargado de manejar la logica del boton viajes con el fin que cuando se presione
    //el boton se despliegue el activity correspondiente
    public void viajes (){
        btn_viaje = (ImageButton) findViewById(R.id.btn_viaje);
        btn_viaje.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent viaje = new Intent (v.getContext(), pantalla_principal.class);
                startActivityForResult(viaje, 0);
            }
        });
    }

    //metodo encargado de manejar la logica del boton amigos con el fin que cuando se presione
    //el boton se despliegue el activity correspondiente
    public void amigos(){
        btn_amigos = (ImageButton) findViewById(R.id.btn_amigos);
        btn_amigos.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent amigos = new Intent (v.getContext(), pantalla_principal.class);
                startActivityForResult(amigos, 0);
            }
        });
    }

    //metodo encargado de manejar la logica del boton canjear puntos con el fin que cuando se presione
    //el boton se despliegue el activity correspondiente
    public void canjear_puntos(){
        btn_CP = (ImageButton) findViewById(R.id.btn_CP);
        btn_CP.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent cp = new Intent (v.getContext(), pcanjear.class);
                startActivityForResult(cp, 0);
            }
        });
    }

    //metodo encargado de manejar la logica del boton configuraciones con el fin que cuando se presione
    //el boton se despliegue el activity correspondiente
    public void configuraciones(){
        btn_configuracion = (ImageButton) findViewById(R.id.btn_configuraciones);
        btn_configuracion.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent configuraciones = new Intent (v.getContext(), peditar.class);
                startActivityForResult(configuraciones, 0);
            }
        });
    }

    //metodo encargado de manejar la logica del boton historial con el fin que cuando se presione
    //el boton se despliegue el activity correspondiente
    public void historial(){
        btn_historial = (ImageButton) findViewById(R.id.btn_historial);
        btn_historial.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent historial = new Intent (v.getContext(), pantalla_principal.class);
                startActivityForResult(historial, 0);
            }
        });
    }
}
