package goudarzi.ha.catanassistant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    Button start, timer, about;
    Boolean timeChange = false;
    String newTime;
    TextView time, tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize() {
        start = (Button) findViewById(R.id.bStart);
        timer = (Button) findViewById(R.id.bTimer);
        about = (Button) findViewById(R.id.bAbout);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        start.setOnClickListener(this);
        timer.setOnClickListener(this);
        about.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bStart:
                Intent intent = new Intent(this, Start.class);
                startActivity(intent);
                break;
            case R.id.bTimer:

                break;
            case R.id.bAbout:
                about();
                break;
        }
    }

    public void about() {
        AlertDialog.Builder lb = new AlertDialog.Builder(this);
        lb.setTitle("About");
        lb.setMessage("Catan Assistant was created to assist players who require dice and a timer to make sure " +
                "the game stays fluid and fun. You have the option to set the countdown time, as well as " +
                "checking the robber box, if the robber is in play. - Amir")
                .setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        lb.create().show();
    }
}
