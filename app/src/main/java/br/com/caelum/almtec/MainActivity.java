package br.com.caelum.almtec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    private Button adicionar;
    private ListView listaValores;
    private EditText entraValor;
    private TextView mostraValor;
    private List<Integer> valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adicionar = (Button) findViewById(R.id.adiciona_valor);
        listaValores = (ListView) findViewById(R.id.lista_valores);
        entraValor = (EditText) findViewById(R.id.entra_valor);
        mostraValor = (TextView) findViewById(R.id.mostra_valor);
        valores = new ArrayList<>();
        mostraValor.setText("0");

        final ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, valores);

        listaValores.setAdapter(adapter);


        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!entraValor.getText().toString().trim().isEmpty()) {
                    int valor = Integer.parseInt(entraValor.getText().toString());



                    valores.add(valor);
                    entraValor.getText().clear();
                    adapter.notifyDataSetChanged();
                    atualizaTextView();

                }
            }
        });


        listaValores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                valores.remove(position);
                adapter.notifyDataSetChanged();
                atualizaTextView();
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

    public void atualizaTextView(){
        int soma = 0;

        for(int valor : valores){
            soma += valor;
        }
        mostraValor.setText(String.valueOf(soma));
    }
}
