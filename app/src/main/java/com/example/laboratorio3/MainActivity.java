package com.example.laboratorio3;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.laboratorio3.paquetes.CustomDialog;


public class MainActivity extends AppCompatActivity {
    EditText txtNum1;
    EditText txtNum2;
    TextView resultado;

    RadioButton radioSuma;
    RadioButton radioResta;
    RadioButton radioMultiplicacion;
    RadioButton radioDivision;
    CheckBox checkboxResultadoEnDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InicializarControles();
    }

    private void InicializarControles(){
        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);
        resultado = (TextView) findViewById(R.id.resultado);
        radioSuma = (RadioButton) findViewById(R.id.radioSuma);
        radioResta = (RadioButton) findViewById(R.id.radioResta);
        radioMultiplicacion = (RadioButton) findViewById(R.id.radioMultiplicacion);
        radioDivision = (RadioButton) findViewById(R.id.radioDivision);
        checkboxResultadoEnDialog = findViewById(R.id.checkbox);

    }


    @SuppressLint("SetTextI18n")
    public void CalcularOperacion(View view) {
        try{
            int n1 = Integer.parseInt(txtNum1.getText().toString());
            int n2 = Integer.parseInt(txtNum2.getText().toString());
            int resultadoFinal;

            if (radioSuma.isChecked()){
                resultadoFinal = n1 + n2;
                resultado.setText("El resultado da:" + resultadoFinal);

            }  else if (radioResta.isChecked()){
                resultadoFinal = n1 - n2;
                resultado.setText("El resultado da:" + resultadoFinal);

            }  else if (radioMultiplicacion.isChecked()){
                resultadoFinal = n1 * n2;
                resultado.setText("El resultado da:" + resultadoFinal);

            } else if (radioDivision.isChecked()) {
                if (n1 !=0 && n2 !=0){
                    resultadoFinal = n1 / n2;
                    resultado.setText("El resultado da:" + resultadoFinal);
                }else {
                    resultado.setText("ERROR, NAO MANITO POR 0 NAO");
                }

            }else{
                resultado.setText("Escoje una operacion");
            }
            if(checkboxResultadoEnDialog.isChecked()){

                CustomDialog dialog = new CustomDialog(resultado.getText().toString());
                dialog.show(getSupportFragmentManager(), "TAB");
                resultado.setText(null);
                checkboxResultadoEnDialog.setChecked(false);

            } else {
                resultado.setText(resultado.getText().toString());
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this,"Error, Escoge una opcion",  Toast.LENGTH_SHORT).show();
        }
    }
}
