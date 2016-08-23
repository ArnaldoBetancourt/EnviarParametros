package com.example.n.enviarparametros;

import android.content.Intent;
import android.support.v4.view.KeyEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatosRecibidos extends AppCompatActivity {


    TextView tvnombre,tvtelefono,tvemail,tvdescripcion, tvfechanacimiento;
    Button confirmadatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_recibidos);
        tvfechanacimiento = (TextView) findViewById(R.id.tvfechanacimiento);
        tvnombre = (TextView) findViewById(R.id.tvnombre);
        tvtelefono = (TextView) findViewById(R.id.tvtelefono);
        tvemail = (TextView) findViewById(R.id.tvemail);
        tvdescripcion = (TextView) findViewById(R.id.tvdescripcion);

        confirmadatos = (Button) findViewById(R.id.btnmodificardatos);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");
        String descripcion = parametros.getString("descripcion");
        String fecha=parametros.getString("fecha");
        tvnombre.setText(nombre);
        tvtelefono.setText(telefono);
        tvemail.setText(email);
        tvdescripcion.setText(descripcion);
        tvfechanacimiento.setText(fecha);

        confirmadatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(DatosRecibidos.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    public boolean onKeyDown(int keyCode, KeyEvent event){

        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent =new Intent(DatosRecibidos.this,MainActivity.class);
            startActivity(intent);


        }
        return super.onKeyDown(keyCode, event);
    }
}
