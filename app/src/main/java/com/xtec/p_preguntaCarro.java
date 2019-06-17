package com.xtec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//Este activity es una página donde se le pregunta al usuario si desea agregar un carro a la aplicacion
//depues de registrase a la misma
public class p_preguntaCarro extends AppCompatActivity {
    private Button btn_si;
    private Button btn_no;

    //metodo principal este metodo maneja los unicos dos botones que tiene la pagina,
    //si se preciona el boton si, se despliega el activity que posee toda la información necesaria del carro
    //si se presiona el boton no, se despliega el acitivity de la pantalla principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_pregunta_carro);

        btn_si = (Button) findViewById(R.id.btn_si);
        btn_si.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent si = new Intent(v.getContext(), pagregarCarro.class);
                startActivityForResult(si, 0);
            }
        });

        btn_no = (Button) findViewById(R.id.btn_no);
        btn_no.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent no = new Intent(v.getContext(), pantalla_principal.class);
                startActivityForResult(no, 0);
            }
        });
    }
}
