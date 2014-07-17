package goudarzi.ha.catanassistant;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class Start extends Activity implements View.OnClickListener {

    ImageView dice1, dice2;
    boolean running = false;
    TextView round, timer;
    CheckBox robber;
    Button start, pause;
    int gameCount = 1;
    long total = 120000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        initilize();
    }

    public void initilize() {
        round = (TextView) findViewById(R.id.tv1);
        timer = (TextView) findViewById(R.id.tvTimer);
        dice1 = (ImageView) findViewById(R.id.ivOne);
        dice2 = (ImageView) findViewById(R.id.ivTwo);
        start = (Button) findViewById(R.id.bRoll);
        start.setOnClickListener(this);
        pause = (Button) findViewById(R.id.bPause);
        pause.setVisibility(View.INVISIBLE);
        pause.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bRoll:
                dice();
                gameCount++;
                pause.setVisibility(View.VISIBLE);
                break;
            case R.id.bPause:

                break;
        }
    }

    public void dice() {
        int[] dice = {R.drawable.one, R.drawable.two, R.drawable.three,
                R.drawable.four, R.drawable.five, R.drawable.six};
        Random r = new Random();
        int i = r.nextInt(dice.length);
        int j = r.nextInt(dice.length);
        dice1.setImageResource(dice[i]);
        dice2.setImageResource(dice[j]);
        round.setText("Round " + gameCount);
    }

    public void countdown() {

    }
}
