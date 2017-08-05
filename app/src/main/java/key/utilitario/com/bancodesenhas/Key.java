package key.utilitario.com.bancodesenhas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static key.utilitario.com.bancodesenhas.R.id.btAce;

public class Key extends Activity implements View.OnClickListener {

    private EditText key; //Senha
    private Button in; //acessar
    private Button dica;
    private Button limp; //limpar
    private Button cdst; //cadastro

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key);

        //key = (EditText)findViewById(R.id.ky);
        in = (Button)findViewById(btAce); //acessar
        //dica = (Button)findViewById(R.id.dica);
        limp = (Button)findViewById(R.id.apg); //apg = limpar
        cdst = (Button)findViewById(R.id.cad); // cadastrar

        in.setOnClickListener(this);
        dica.setOnClickListener(this);
        limp.setOnClickListener(this);
        cdst.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String senha = null;


        Intent it = null;
        switch (v.getId()){
            case R.id.btAce:

                ConstrutorBD bd = new ConstrutorBD(this);

                //bd.validar();

                /*if(senha == key.toString()){

                Toast.makeText(this, "Senha aceita", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Opa!! Tem algo errado...", Toast.LENGTH_LONG).show();
            }
                break;

            /*case R.id.dica:
            String bdDica = "Não sei";
            Toast.makeText(this,bdDica, Toast.LENGTH_LONG).show();
                break;*/

            case R.id.apg:
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);

            //dlg.setTitle(R.string.app_name);
            dlg.setMessage(String.format("Cuidado!\n" +
                    " Isso vai apagar todos os dados, incluindo as senhas gravadas.\n" +
                    "É isso que você quer?"));

            dlg.setPositiveButton("SIM", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface di, int arg){
                    String bdApagar = "Apagar dados do Banco de Dados";

                }
            });

            dlg.setNegativeButton("NÂO", null);
            dlg.show();
                break;

            case R.id.cad:

                it = new Intent(this, Cadastrar.class);

                startActivity(it);
                break;

        }

    }
    }
