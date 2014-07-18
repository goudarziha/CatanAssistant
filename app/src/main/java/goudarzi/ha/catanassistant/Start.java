package goudarzi.ha.catanassistant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Start extends Activity implements View.OnClickListener {

    private CountDownTimer cdTimer;
    ImageView dice1, dice2;
    boolean running = false;
    TextView round, timer;
    CheckBox robber;
    Button start, pause, resume;
    int gameCount = 1;
    long total = 120000;
    long interval = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        initialize();
    }

    public void initialize() {
        round = (TextView) findViewById(R.id.tv1);
        timer = (TextView) findViewById(R.id.tvTimer);
        dice1 = (ImageView) findViewById(R.id.ivOne);
        dice2 = (ImageView) findViewById(R.id.ivTwo);
        start = (Button) findViewById(R.id.bRoll);
        start.setOnClickListener(this);
        pause = (Button) findViewById(R.id.bPause);
        pause.setVisibility(View.INVISIBLE);
        pause.setOnClickListener(this);
        resume = (Button) findViewById(R.id.bResume);
        resume.setVisibility(View.INVISIBLE);
        resume.setOnClickListener(this);
        robber = (CheckBox) findViewById(R.id.cbRobber);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bRoll:
                dice();
                if (running == true) {
                    total = 120000;
                    cdTimer.cancel();
                    countTimer();
                } else {
                    countTimer();
                }
                gameCount++;
                pause.setVisibility(View.VISIBLE);
                break;
            case R.id.bPause:
                cdTimer.cancel();
                running = true;
                pause.setVisibility(View.INVISIBLE);
                resume.setVisibility(View.VISIBLE);
                break;
            case R.id.bResume:
                countTimer();
                running = true;
                resume.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.VISIBLE);
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
        if ((i + 1 + (j + 1) == 7) && (robber.isChecked())) {
            robber();
        }
    }

    private void robber() {
        AlertDialog.Builder lb = new AlertDialog.Builder(this);
        lb.setTitle("The Robber!");
        lb.setMessage("You have encountered the Robber, if your hand contains more than 7 cards, return half to the bank.")
                .setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        lb.create().show();
    }

    public void countTimer() {
        cdTimer = new CountDownTimer(total, 1000) {
            @Override
            public void onTick(long l) {
                total = l;
                timer.setText("Time Left: " + new SimpleDateFormat("mm:ss").format(new Date(l)));
                running = true;
            }

            @Override
            public void onFinish() {
                timer.setText("Time's up!");
                running = false;
            }
        }.start();
    }
}
