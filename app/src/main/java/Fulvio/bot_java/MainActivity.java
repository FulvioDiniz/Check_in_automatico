package Fulvio.bot_java;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton botaoToggle;
    private TextView texto;
    private TextView textorelogio;
    private int temporestante;
    //private CountDownTimer relogio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoToggle = findViewById(R.id.botao_toggle);
        texto = findViewById(R.id.Status_botao);
        textorelogio = findViewById(R.id.Timer1);

        botaoToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (botaoToggle.isChecked()) {
                    texto.setText("Desativado");

                } else {
                    texto.setText("Ativado");
                    Relogio relogio = new Relogio(100000);
                    relogio.iniciar();
                    temporestante = relogio.getTempoRestante();
                    while(temporestante > 0){
                        textorelogio.setText(String.valueOf(temporestante));
                        temporestante--;
                    }



                }
            }
        });
    }
}
