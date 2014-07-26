package goudarzi.ha.catanassistant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    Button start, timer, about;
    Boolean timeChange = false;
    TextView tv1, tv2;
    String newTime;

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
                if (!timeChange) {
                    newTime = "2";
                }
                intent.putExtra("time", newTime);
                startActivity(intent);
                break;
            case R.id.bTimer:
                setTimer();
                break;
            case R.id.bAbout:
                about();
                break;
        }
    }

    public void setTimer() {
        AlertDialog.Builder lb = new AlertDialog.Builder(this);
        lb.setTitle("Set Timer");
        lb.setMessage("Input minutes");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        lb.setView(input);
        lb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                newTime = input.getText().toString();
                Toast.makeText(getApplicationContext(), "Timer changed.", Toast.LENGTH_SHORT).show();
                timeChange = true;
            }
        });
        lb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;
            }
        });
        lb.create().show();
    }

    public void about() {
        AlertDialog.Builder lb = new AlertDialog.Builder(this);
        lb.setTitle("About");
        lb.setMessage(R.string.aboutMsg)
                .setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                timeChange = false;
            }
        });
        lb.create().show();
    }
}
