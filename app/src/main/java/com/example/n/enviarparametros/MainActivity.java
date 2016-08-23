package com.example.n.enviarparametros;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText nombre, telefono, email, descripcion,fecha;
    Button siguiente ,aceptar;


    private static final int tipoDialogo= 0;
    private int año;
    private int mes;
    private int dia;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nombre = (EditText) findViewById(R.id.edtnombre);
        telefono = (EditText) findViewById(R.id.edttelefono);
        email = (EditText) findViewById(R.id.edtemail);
        descripcion = (EditText) findViewById(R.id.edtdescripcion);
        siguiente = (Button) findViewById(R.id.btnsiguiente);
        fecha=(EditText)findViewById(R.id.dtpfecha);
        aceptar=(Button)findViewById(R.id.btnaceptarfecha);
        Calendar calendario=Calendar.getInstance();
        año=calendario.get(Calendar.YEAR);
        mes=calendario.get(Calendar.MONTH);
        dia=calendario.get(Calendar.DAY_OF_MONTH);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String auxnombre = nombre.getText().toString();
                String auxtel = telefono.getText().toString();
                String auxemail = email.getText().toString();
                String auxdescripcion = descripcion.getText().toString();
                String auxfecha= fecha.getText().toString();


                Intent intent = new Intent(MainActivity.this, DatosRecibidos.class);
                intent.putExtra("nombre", auxnombre);
                intent.putExtra("telefono", auxtel);
                intent.putExtra("email", auxemail);
                intent.putExtra("descripcion", auxdescripcion);
                intent.putExtra("fecha",auxfecha);
                startActivity(intent);
                finish();
            }
        });

        mostrafecha();
        oyenteSelectorFecha=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfyear, int dayOfMonth) {
                año=year;
                mes=monthOfyear +1;
                dia=dayOfMonth;
                mostrafecha();

            }
        };
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case 0:
                return new DatePickerDialog(this,oyenteSelectorFecha,año,mes,dia);
        }
        return null;

    }

    public void mostrafecha(){
        fecha.setText(dia+"/"+  mes+"/"+  año);
    }
    public void mostrarcalendario(View control){
        showDialog(tipoDialogo);

    }
}
