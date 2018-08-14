package com.example.usuario.finalwebservice;

import android.app.Activity;
import android.content.Context;
import android.icu.util.ULocale;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usuario.finalwebservice.Empleado;
import com.example.usuario.finalwebservice.R;

import java.util.ArrayList;
import java.util.Locale;


public class AdapterItemEmpleado extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Empleado> items;

    public AdapterItemEmpleado(Activity activity, ArrayList<Empleado> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<Empleado> empleados) {
        for (int i = 0; i < empleados.size(); i++) {
            items.add(empleados.get(i));
        }
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_empleado, null);
        }

        Empleado dir = items.get(position);


        TextView title = (TextView) v.findViewById(R.id.nombre);
        title.setText(dir.getNombre());

        TextView description = (TextView) v.findViewById(R.id.apellidos);
        description.setText(dir.getApellidos());

        TextView estado = (TextView) v.findViewById(R.id.estado);
        estado.setText(dir.getEstado());

        ImageView imagen = (ImageView) v.findViewById(R.id.imageView);
        imagen.setImageDrawable(dir.getImagen());

        return v;
    }
}