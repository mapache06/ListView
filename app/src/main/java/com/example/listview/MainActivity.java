package com.example.listview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends Activity {
ListView lista;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Alumnos alumnos_datos[] = new Alumnos[]{
                new Alumnos(R.mipmap.ic_launcher, "Lizeth"),
                new Alumnos(R.mipmap.ic_launcher, "Esdras"),
                new Alumnos(R.mipmap.ic_launcher, "Guille"),
        };

    AlumnosAdapter adapter = new
            AlumnosAdapter(this,R.layout.activity_elementos_lista,alumnos_datos);
    lista = (ListView) findViewById(R.id.Lista);
    View encabezado = (View)
            getLayoutInflater().inflate(R.layout.activity_encabezado_lista, null);
    lista.addHeaderView(encabezado);
    lista.setAdapter(adapter);
    lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int
                position, long id) {
            TextView v = (TextView)view.findViewById(R.id.item);
            Toast.makeText(getApplicationContext(),v.getText(),Toast.LENGTH_LONG).show();
        }
    });
}
}






