package vinayism.kartavya;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Centre3 extends ActionBarActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre3);
        tv = (TextView)findViewById(R.id.tvcentre3);
        tv.setText("Centre3 is located in heart of Mandal Basti. Children studying in this centre mainly comes from Koranga basti," +
                "Mandal basti and Nagasthan Basti. It has a strength of 60 children studying in class 3rd to class 7th. This centre" +
                "is well equipped with emergency ligths, toilet and playground. Children here are fond of playing badminton and football" +
                "and drawing and dancing. Regular assembly and exercise are done. ");
    }



}
