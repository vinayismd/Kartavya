package vinayism.kartavya;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Centre1 extends ActionBarActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre1);
        tv = (TextView)findViewById(R.id.tvcentre1);

        tv.setText("Centre 1 is located in the Labani Basti,behind Jasper Hostel,ISM Dhanbad. It Comprised of two building knowns ad" +
                "Muskan Centre and Talab Centre. And a Subsidiary Centre 'Baccho ka Kartavya' fully rummed and managed by senior kartavya " +
                "students itself. The Centre1 has a total of 150 students with classes from LKG to Part2. Besides regular classes students" +
                "are taught and prepared for competition exams like SSC,JEE MAINS, Polytechnic etc.The Skill Development in the form of Singing , " +
                "drama are provided on each sunday. ");
    }





}
