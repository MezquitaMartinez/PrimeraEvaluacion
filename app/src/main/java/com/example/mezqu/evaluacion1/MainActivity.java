package com.example.mezqu.evaluacion1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> arrayEstudiantes;
    double p1,p2,p3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.arrayEstudiantes = new ArrayList<>();

    }
    public void onClickButton(View view){
        if(view.getId() == R.id.btn_Nuevo){
            Intent nuevo = new Intent(MainActivity.this,Estudiante.class);
            startActivityForResult(nuevo,1);
        }else if(view.getId() == R.id.btn_Lista){
            Intent lista = new Intent(MainActivity.this,ListaEstudiantes.class);
            lista.putStringArrayListExtra("arrayEstudiantes",this.arrayEstudiantes);
            startActivity(lista);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                this.arrayEstudiantes.add(data.getStringExtra("Nombre") + "\n" + data.getStringExtra("Codigo") + "\n" + data.getStringExtra("Materia")+ "  " + data.getDoubleExtra("Promedio",0.0));

                Toast.makeText(MainActivity.this,"Alumno ingresado",Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(MainActivity.this,"Para guardar la informacion los campos deben tener datos",Toast.LENGTH_LONG).show();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}
