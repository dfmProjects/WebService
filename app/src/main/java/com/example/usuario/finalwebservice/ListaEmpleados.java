package com.example.usuario.finalwebservice;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaEmpleados extends AppCompatActivity{

    ListView lv;
    private String server_url_list = "http://web3.disfrimur.com:8060/wsdl/REST/service.php";
    Drawable respi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_empleados);

        lv=(ListView) findViewById(R.id.lista); //Inicializamos el ListView

        Drawable respi = getResources().getDrawable(R.drawable.icon); //Instanciamos una imagen ubicada en drawable

        ArrayList<Empleado> emp = new ArrayList(); //instanciamos el arrayList que va a ir el el Adapter

        Empleado cat = new Empleado ("Antonio Rubira", "Administración", "Activo", respi);
        Empleado cat2 = new Empleado ("Antonio Rubira", "Administración", "Activo", respi);
        Empleado cat3 = new Empleado ("Antonio Rubira", "Administración", "Activo", respi);
        Empleado cat4 = new Empleado ("Antonio Rubira", "Administración", "Activo", respi);
        Empleado cat5 = new Empleado ("Antonio Rubira", "Administración", "Activo", respi);
        Empleado cat6 = new Empleado ("Antonio Rubira", "Administración", "Activo", respi);
        Empleado cat7 = new Empleado ("Antonio Rubira", "Administración", "Activo", respi);


        emp.add(cat); //Agregamos la variable cat instanciada mas arriba al arrayList
        emp.add(cat2);
        emp.add(cat3);
        emp.add(cat4);
        emp.add(cat5);
        emp.add(cat6);
        emp.add(cat7);

        AdapterItemEmpleado adapter = new AdapterItemEmpleado(this, emp);

        lv.setAdapter(adapter);

    }




}


