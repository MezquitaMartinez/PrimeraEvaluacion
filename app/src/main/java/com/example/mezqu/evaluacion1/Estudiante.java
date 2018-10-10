package com.example.mezqu.evaluacion1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Estudiante extends AppCompatActivity {
    private EditText edt_Nombre, edt_Codigo, edt_Materia, edt_Primer, edt_Segundo, edt_Tercer;

    private double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante);

        edt_Nombre = findViewById(R.id.edtNombre);
        edt_Codigo = findViewById(R.id.edtCodigo);
        edt_Materia = findViewById(R.id.edtMateria);
        edt_Primer = findViewById(R.id.edtPrimer);
        edt_Segundo = findViewById(R.id.edtSegundo);
        edt_Tercer = findViewById(R.id.edtTercer);

    }

    public void onClickButton (View view){
        String p1 = edt_Primer.getText().toString();
        String p2 = edt_Segundo.getText().toString();
        String p3 = edt_Tercer.getText().toString();

        //convertimos de String a int
        double num1 = Double.parseDouble(p1);
        double num2 = Double.parseDouble(p2);
        double num3 = Double.parseDouble(p3);

        if(this.edt_Nombre.getText().length()!=0 && this.edt_Codigo.getText().length()!=0 && this.edt_Materia.getText().length()!=0){
            Intent RetornarDatos = new Intent(this,MainActivity.class);
            RetornarDatos.putExtra("Nombre", this.edt_Nombre.getText().toString());
            RetornarDatos.putExtra("Codigo",this.edt_Codigo.getText().toString());
            RetornarDatos.putExtra("Materia",this.edt_Materia.getText().toString());
            RetornarDatos.putExtra("Promedio",(num1*0.30)+(num2*0.30)+(num3*0.40));

            setResult(RESULT_OK,RetornarDatos);
            finish();
        }else {
            Toast.makeText(this,"Hay campos vacios",Toast.LENGTH_LONG).show();
        }
    }
}
