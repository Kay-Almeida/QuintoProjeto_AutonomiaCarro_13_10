package kailaine.mobile.quintoprojeto_autonomiacarro_13_10;

/*
 *@author:<Kailaine Almeida de Souza RA: 1110482313026>
 */

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etConsumoMedio;
    private EditText etLitrosTanque;
    private TextView tvRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etConsumoMedio = findViewById(R.id.etConsumoMedio);
        etLitrosTanque = findViewById(R.id.etLitrosTanque);
        tvRes = findViewById(R.id.tvRes);

        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());
    }
    private void calc() {
        double consumoMedio = Double.parseDouble(etConsumoMedio.getText().toString());
        double litrosTanque = Double.parseDouble(etLitrosTanque.getText().toString());

        double autonomiaKm = consumoMedio * litrosTanque;

        double autonomiaMetros = autonomiaKm * 1000;

        tvRes.setText("Autonomia = " + autonomiaMetros + " metros");

        etConsumoMedio.setText("");
        etLitrosTanque.setText("");
    }

}