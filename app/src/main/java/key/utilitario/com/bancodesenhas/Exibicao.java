package key.utilitario.com.bancodesenhas;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Exibicao extends Activity implements  View.OnClickListener {

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibicao);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener((View.OnClickListener) this);

        Intent it = getIntent();
        if(it != null){
            int key = it.getIntExtra("senha",0);
            String chave = it.getStringExtra("chave");
            List<ContentValues> lista = new ArrayList<>();
            if(key == R.id.tabela){
                lista = new ConstrutorBD(this).achar(chave);
            }

            if(lista != null){
                if(lista.size()>0){
                    TableLayout tb = (TableLayout) findViewById(R.id.tabela);
                    for(ContentValues cv: lista){
                        TableRow tr = new TableRow(this);
                        TextView col1 = new TextView(this);
                        col1.setText(String.valueOf(cv.getAsInteger("id")));
                        tr.addView(col1);

                        TextView col2 = new TextView(this);
                        col1.setText(String.valueOf(cv.getAsInteger("key")));
                        tr.addView(col2);

                        TextView col3 = new TextView(this);
                        col1.setText(String.valueOf(cv.getAsInteger("nome")));
                        tr.addView(col3);

                        TextView col4 = new TextView(this);
                        col1.setText(String.valueOf(cv.getAsInteger("data")));
                        tr.addView(col4);

                        tb.addView(tr);
                    }
                }
            }
        }
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnVoltar){
            onBackPressed();
        }
    }
}

