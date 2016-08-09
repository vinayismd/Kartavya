package vinayism.kartavya;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Centre4 extends ActionBarActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre4);
        tv = (TextView)findViewById(R.id.tvcentre4);
        tv.setText("Centre4 is located near Barmasiya Basti which is about 4km from ISM,Dhanbad.This Centre compromises of 60 students" +
                "from class 2 to class 11. This centre is managed by volunteer of kartavya who regullarly go there to run and teach smoothly." +
                "Unlike other centres of kartavya this centre have regular paid recruited teachers appointed for teaching.This Centre has an " +
                "extension called Centre 4 extension which is runned by students of Centre 4 itself.Students here are taught the art of karate" +
                "and dance.");
    }



}
