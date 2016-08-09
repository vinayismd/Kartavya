package vinayism.kartavya;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Centre2 extends ActionBarActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre2);

        tv = (TextView)findViewById(R.id.tvcentre2);
        tv.setText("Centre2 is located in the Dhaiya School beside Amber Hostel. Children in this Centre mainly come from koranga " +
                ",labani basti and mallic basti.It has a total strength of 120 students studying in class 5th to B.com/Bsc." +
                "Along with regular class study,this centre prepare children for various competitive exams like Navodaya competitive " +
                "exams like Navodaya entrance examination for the students of class 5 to class 9 , SSC and Banking  for commerce" +
                "12th students. This Centre also helps studnets in enriching them with the art of Karate whose classes held regularly" +
                "from Monday to Thrusday. ");
    }


}
