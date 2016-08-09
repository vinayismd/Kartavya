package vinayism.kartavya;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Computer_Centre extends ActionBarActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer__centre);
        tv = (TextView)findViewById(R.id.tvcomputerc);
        tv.setText("To fullfill the need of Computer education, Kartavya Dhanabd Chapter has a Computer Centre located in labani Basti " +
                ".It currently has 10 computers. It helps students to improve their soft skills using MS Office, Tally , Typing etc. So" +
                "as to make them oriented.The Computers also comtains various video tutorials on various topics.");
    }



}
