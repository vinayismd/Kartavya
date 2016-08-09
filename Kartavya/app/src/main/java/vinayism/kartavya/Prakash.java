package vinayism.kartavya;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Prakash extends ActionBarActivity implements View.OnClickListener {

    //sliding image
    ViewPager viewPager;
    TextView tvprakash;
    Button btnmoreprakash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prakash);

        btnmoreprakash = (Button)findViewById(R.id.btnprakashmore);
        btnmoreprakash.setOnClickListener(this);

        //sliding image
        viewPager = (ViewPager) findViewById(R.id.prakashpager);
        PagerAdapter adapter = new CustomAdapter(Prakash.this);
        viewPager.setAdapter(adapter);
    }


    @Override
    public void onClick(View view) {
        Intent i = new Intent(this , MoreonPrakash.class);
        startActivity(i);
    }
}
