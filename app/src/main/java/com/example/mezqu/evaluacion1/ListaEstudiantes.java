package com.example.mezqu.evaluacion1;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ListaEstudiantes extends ListActivity {
    private String[] estudiantes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lista_estudiantes);
        this.estudiantes = (new ArrayList<String>(getIntent().getStringArrayListExtra("arrayEstudiantes"))).toArray(new String[0]);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,estudiantes));
    }
}
