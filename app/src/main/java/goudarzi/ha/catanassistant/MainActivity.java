package goudarzi.ha.catanassistant;

import android.app.Activity;
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

                break;
        }
    }
}
