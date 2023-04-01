package Fulvio.bot_java;
import android.os.CountDownTimer;

import android.os.CountDownTimer;

public class Relogio {
    private CountDownTimer timer;
    private int tempoTotal;
    private int tempoRestante;

    public Relogio(int tempoTotal) {
        this.tempoTotal = tempoTotal;
        this.tempoRestante = tempoTotal;

        timer = new CountDownTimer(tempoTotal * 10000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                tempoRestante = (int) millisUntilFinished / 1000;
            }

            @Override
            public void onFinish() {
                tempoRestante = 0;
            }
        };
    }

    public void iniciar() {
        timer.start();
    }

    public void parar() {
        timer.cancel();
    }

    public int getTempoRestante() {
        return tempoRestante;
    }

    public void zerar() {
        timer.cancel();
        tempoRestante = tempoTotal;
    }
}
