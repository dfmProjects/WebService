package com.example.usuario.finalwebservice;


import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class MainActivity extends AppCompatActivity {

    //private String server_url = "http://web3.disfrimur.com:8061/wsdl/lib/cliente.php";

    //URL web Service de la red (dfmapl4)- solo funciona en el emulador no smartphone
    //private String server_url = "http://192.168.100.87:8061/wsdl/cliente.php";
    //private String server_url = "http://web3.disfrimur.com:8060/wsdl/REST/service.php";
    private String server_url = "http://web3.disfrimur.com:8062/wsdl/REST/service.php";

    Button btnRequest;
    Button btnRequest2;
    TextView texto;
    RequestQueue requestQueue;

    private Toolbar appbar;
    private DrawerLayout drawerLayout;
    private NavigationView navView;

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRequest = (Button) findViewById(R.id.btnRequest);
        btnRequest2 = (Button) findViewById(R.id.btnRequest2);
        texto = (TextView) findViewById(R.id.txtTexto);
        Cache cache = new DiskBasedCache(getCacheDir(),1024*1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache,network);
        requestQueue.start();


        btnRequest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                //Add params
                server_url = server_url + "?NumModelo=209";

                JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET, server_url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                    Log.i("Service", server_url);

                    for (int i = 0;i < response.length(); i++) {
                        JSONObject jsonObject = null;

                        try {
                            jsonObject = response.getJSONObject(i);
                            texto.setText("Denominacion: " + jsonObject.getString("Denominacion").toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.i("Error al parsear JSON: ", e.getMessage());
                        }

                    }
                    Toast.makeText(getApplicationContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen
                        //requestQueue.stop();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG,"Error :" + error.toString());
                    }
                });

                requestQueue.add(stringRequest);
            }
        });

        btnRequest2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {

                Intent lista = new Intent(getApplicationContext(), ListaEmpleados.class);
                startActivity(lista);

            }

        });

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navView = (NavigationView)findViewById(R.id.navview);

        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        boolean fragmentTransaction = false;
                        Fragment fragment = null;

                        switch (menuItem.getItemId()) {
                            case R.id.menu_seccion_1:
                                fragment = new Fragment1();
                                fragmentTransaction = true;
                                break;

                            case R.id.menu_opcion_1:
                                Intent seccion2 = new Intent(getApplicationContext(), SeccionDos.class);
                                startActivity(seccion2);
                                Log.i("NavigationView", "Pulsada opción 1");
                                break;
                            case R.id.menu_opcion_2:
                                Log.i("NavigationView", "Pulsada opción 2");
                                break;
                        }

                        if(fragmentTransaction) {
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.drawer_layout, fragment)
                                    .commit();

                            Log.i("Fragment", "Lanzado");



                            menuItem.setChecked(true);
                            //getSupportActionBar().setTitle(menuItem.getTitle());
                        }

                        drawerLayout.closeDrawers();

                        return true;
                    }
                });


    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }

}