package goudarzi.ha.catanassistant;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    Button start, timer, about;
    Boolean timeChange = false;
    String newTime;
    TextView time, tv1, tv2;
    String fontPath = "fonts/Sansation-Bold.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        fontFace();
    }

    public void fontFace() {
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        start.setTypeface(tf);
        timer.setTypeface(tf);
        about.setTypeface(tf);
        tv1.setTypeface(tf);
        tv2.setTypeface(tf);
    }

    public void initialize() {
        start = (Button) findViewById(R.id.bStart);
        timer = (Button) findViewById(R.id.bTimer);
        about = (Button) findViewById(R.id.bAbout);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bStart:
                Intent intent = new Intent(this, Start.class);
                this.newTime = this.time.getText().toString();
                if (!this.timeChange) {
                    newTime = "2";
                }
                intent.putExtra("time", this.newTime);
                startActivity(intent);
                break;
            case R.id.bTimer:

                break;
            case R.id.bAbout:

                break;
        }
    }
}
