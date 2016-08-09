package vinayism.kartavya;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Profile extends ActionBarActivity implements View.OnClickListener {

    Button myinfo , updateinfo , notify , achieve , meet , problm;
    String pickadmno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);

        myinfo= (Button)findViewById(R.id.btnpromyinfo);
        updateinfo= (Button)findViewById(R.id.btnproupdate);
        notify= (Button)findViewById(R.id.btnpronoti);
        achieve= (Button)findViewById(R.id.btnproachv);
        meet= (Button)findViewById(R.id.btnpromeet);
        problm= (Button)findViewById(R.id.btnprocntrprob);


        myinfo.setOnClickListener(this);
        updateinfo.setOnClickListener(this);
        notify.setOnClickListener(this);
        achieve.setOnClickListener(this);
        meet.setOnClickListener(this);
        problm.setOnClickListener(this);


        Intent in = getIntent();
        pickadmno = in.getStringExtra("admno");

        Toast.makeText(getApplicationContext() ,pickadmno ,Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnpromyinfo:{
                Toast.makeText(getApplicationContext() ,"My Info" ,Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, Myinfo.class);
                i.putExtra("admno" ,pickadmno );
                startActivity(i);

                break;
            }


            case R.id.btnproupdate:{
                Toast.makeText(getApplicationContext() ,"Update INfo",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext() , UpdateProfile.class);
                i.putExtra("admno" , pickadmno);
                startActivity(i);
                break;

            }


            case R.id.btnpronoti:{
                Toast.makeText(getApplicationContext() ,"Notifications",Toast.LENGTH_SHORT).show();
                break;

            }

            case R.id.btnproachv:{
                Toast.makeText(getApplicationContext() ,"Post Achievements",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext() , Post_achievement.class);
                i.putExtra("admno" , pickadmno);
                startActivity(i);
                break;

            }
            case R.id.btnpromeet:{
                Toast.makeText(getApplicationContext() ,"Post Meetings",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext() , Temp1.class);
                i.putExtra("admno" , pickadmno);
                startActivity(i);
                break;

            }
            case R.id.btnprocntrprob:{
                Toast.makeText(getApplicationContext() ,"Post Centre Problems",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext() , Post_centreproblem.class);
                i.putExtra("admno" , pickadmno);
                startActivity(i);
                break;

            }


        }

    }
}
