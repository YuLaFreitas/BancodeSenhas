package key.utilitario.com.bancodesenhas;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;

public class Cadastrar extends Activity implements View.OnClickListener {

    private EditText ky1;
    private EditText ky2;
    private EditText dica;
    private Button slv;
    private Button vlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        ky1 = (EditText)findViewById(R.id.ky1);
        ky2 = (EditText)findViewById(R.id.ky2);
        dica = (EditText)findViewById(R.id.dca0);
        slv = (Button) findViewById(R.id.slv);
        vlt = (Button)findViewById(R.id.vlt);

        slv.setOnClickListener(this);
        vlt.setOnClickListener(this);

            }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

                case R.id.vlt:
                Intent it = new Intent(this, Key.class);

                startActivity(it);

                break;

            case R.id.slv:

                /*if(ky1.length() == 0 || ky2.length() == 0 || dica.length() == 0){
                    Toast.makeText(this, "Vamos tentar de novo...", Toast.LENGTH_LONG).show();
                }else {

                    if (ky1.length() == 0) {
                        Toast.makeText(this, "Opa!! Falta a senha...", Toast.LENGTH_LONG).show();
                    }
                    if (ky2.length() == 0) {
                        Toast.makeText(this, "Opa!! Agora você deve confirmar", Toast.LENGTH_LONG).show();
                    }
                    if (dica.length() == 0) {
                        Toast.makeText(this, "Opa!! Precisamos de uma dica,\n você pode esquecer esta senha...", Toast.LENGTH_LONG);
                    }

                    else if (ky1.getText() == ky2.getText()) {
                        //pegar a data do sistema
                        // long data  = System.currentTimeMillis();
                        //SimpleDateFormat sdf = new SimpleDateFormat("d/m/yyyy");
                        //String agora = sdf.format(data);
                        */
                        ContentValues cv = new ContentValues();

                        cv.put("Id", "1");

                        cv.put("Key", ky1.getText().toString());

                        ConstrutorKEY CKey = new ConstrutorKEY(this);

                        String msg = "";
                        if(CKey.inserir(cv)>0){
                            msg = "Dados salvos";

                            ky1.setText("");
                            ky2.setText("");
                            dica.setText("");
                        }else{
                            msg = "Ocorreu um erro durante a operação.";
                        }

                        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

                        //cv.put("data", agora.toString());
                        Intent aq = new Intent(this, Key.class);

                        Toast.makeText(this, "Esta tudo ok, vamos salvar!", Toast.LENGTH_LONG).show();


                        startActivity(aq);

                    //}
                break;
                }


        }

};
