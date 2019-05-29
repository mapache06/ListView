package com.example.listview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AlumnosAdapter extends ArrayAdapter<Alumnos> {

    Context contexto;
    int layoutResourceId;
    Alumnos datos[] = null;

    public AlumnosAdapter(Context context, int resource, Alumnos[] datos) {
        super(context, resource, datos);
        this.contexto = context;
        this.layoutResourceId = resource;
        this.datos = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        AlumnosHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) contexto).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new AlumnosHolder();
            holder.imagen = (ImageView) row.findViewById(R.id.imagen);
            holder.texto = (TextView) row.findViewById(R.id.item);
            row.setTag(holder);
        } else {
            holder = (AlumnosHolder) row.getTag();
        }
        Alumnos alumnos = datos[position];
        holder.texto.setText(alumnos.nombre);
        holder.imagen.setImageResource(alumnos.foto);
        return row;
    }

    static class AlumnosHolder {
        ImageView imagen;
        TextView texto;
    }
}




