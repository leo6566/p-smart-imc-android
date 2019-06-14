package br.com.gilber.SmartIMC;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.gilber.appimc.R;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText campoAltura, campoPeso, campoNome;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Calcular IMC");

        campoAltura = (TextInputEditText)findViewById(R.id.idCampoAltura2);
        campoPeso = (TextInputEditText)findViewById(R.id.idCampoPeso);
        textoResultado = (TextView)findViewById(R.id.idTextResultado);
        campoNome= (TextInputEditText)findViewById(R.id.idCampoNome);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.idSair:
                finish();
                return true;
            case R.id.idTabela:

                startActivity(new Intent(getApplicationContext(), TabelaIMCActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void calcularImc(View view){
        String textoAltura, textoPeso, textoNome;
        textoAltura = campoAltura.getText().toString();
        textoPeso = campoPeso.getText().toString();
        textoNome= campoNome.getText().toString();
        if (!textoAltura.isEmpty()){
            if (!textoPeso.isEmpty()){

                Double altura, peso, resultado;

                altura = Double.parseDouble(textoAltura);
                peso = Double.parseDouble(textoPeso);

                altura = altura* altura;

                resultado = peso/altura;

                tabelaImc(resultado);
            }else{
                Toast.makeText(MainActivity.this, "Preencha o campo peso:!!", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(MainActivity.this, "Preencha o campo Altua!!", Toast.LENGTH_LONG).show();
        }

    }

    public void tabelaImc(Double imc){
        long num = Math.round(imc);
        if (num < 18.5){
            textoResultado.setText("O seu IMC é: " +Math.round(num)+"\n"+"Baixo Peso");
        }else if (num >= 18.5 && num <=24.9){
            textoResultado.setText("O seu IMC é: " +Math.round(num)+"\n"+"Peso Normal");
            }
            else if (num ==25 ){
                textoResultado.setText("O seu IMC é: " +Math.round(num)+"\n"+"Sobre Peso");
            }
            else if (num > 25 && num <= 29.9){
                textoResultado.setText("O seu IMC é: " +Math.round(num)+"\n"+"Pré-Obeso");
            }
            else if (num >= 30 && num <= 34.9){
                textoResultado.setText("O seu IMC é: " +Math.round(num)+"\n"+"Obeso grau I");
            }
            else if (num >= 35 && num <= 39.9){
                textoResultado.setText("O seu IMC é: " +Math.round(num)+"\n"+"Obeso grau II");
            }
            else if (num >=40){
                textoResultado.setText("O seu IMC é: " +Math.round(num)+"\n"+"Obeso grau III");
            }

    }
}
