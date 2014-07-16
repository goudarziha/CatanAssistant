package goudarzi.ha.catanassistant;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Start extends Activity implements View.OnClickListener {

    ImageView dice1, dice2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

    }

    @Override
    public void onClick(View view) {

    }
}
