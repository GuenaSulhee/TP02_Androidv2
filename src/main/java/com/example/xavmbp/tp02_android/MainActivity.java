package com.example.xavmbp.tp02_android;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static fr.afpa.cdi.convertisseur.Convert.convertir;

public class MainActivity extends AppCompatActivity {

    public Spinner spinner1;
    public Spinner spinner2;
    public Context context;
    public double montant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        Button boutonConvertir = (Button) findViewById(R.id.boutonConvertir);
        Button boutonQuitter = (Button) findViewById(R.id.boutonQuitter);
        EditText montant = (EditText) findViewById(R.id.montant);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                //récupération de l'id du composant clické

                int identifiant = view.getId();
                System.out.print("test2");
                switch (identifiant) {

                    // Si l'identifiant de la vue est celui du premier bouton
                    case R.id.boutonConvertir:
    /* Agir pour bouton convertir */

                        validation(spinner1, spinner2);
                        break;

                    // Si l'identifiant de la vue est celui du deuxième bouton
                    case R.id.boutonQuitter:
    /* Agir pour bouton 2 */
                        break;

                }
            }

        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void validation(Spinner spinner1,Spinner spinner2)
    {
        context=getApplicationContext();
        //Controle des devises vides: si les spinners sont vides on a un message d'erreur sinon on affiche le résultat

        if(spinner1.getSelectedItem().toString().equals("")||spinner2.getSelectedItem().toString().equals(""))
        {
            System.out.print("test");
            Toast.makeText(context,"Veuillez choisir une devise!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            convertir(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), montant);
            String resultat=String.valueOf(montant);
            Toast.makeText(context,resultat,Toast.LENGTH_SHORT).show();
        }



    }
}
