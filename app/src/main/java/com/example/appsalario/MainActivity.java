package com.example.appsalario;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editSalario;
    private RadioGroup radioGroup;
    private Button btnCalcular;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSalario = findViewById(R.id.editSalario);
        radioGroup = findViewById(R.id.radioGroup);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(v -> calcularReajuste());
    }

    private void calcularReajuste() {
        String salarioStr = editSalario.getText().toString();

        if (salarioStr.isEmpty()) {
            Toast.makeText(this, "Digite o salário", Toast.LENGTH_SHORT).show();
            return;
        }

        double salario = Double.parseDouble(salarioStr);
        double percentual = 0;

        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == R.id.radio40) {
            percentual = 0.40;
        } else if (selectedId == R.id.radio45) {
            percentual = 0.45;
        } else if (selectedId == R.id.radio50) {
            percentual = 0.50;
        } else {
            Toast.makeText(this, "Selecione um percentual", Toast.LENGTH_SHORT).show();
            return;
        }

        double novoSalario = salario + (salario * percentual);
        txtResultado.setText(String.format("Novo salário: R$ %.2f", novoSalario));
    }
}
