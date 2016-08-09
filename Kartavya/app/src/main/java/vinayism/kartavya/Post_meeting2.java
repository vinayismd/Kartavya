package vinayism.kartavya;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class Post_meeting2 extends ActionBarActivity implements View.OnClickListener {

    CheckBox t1 , t2 , t3,t4,t5,t6 ,tnone;
    String sc1,sc2,sc3,sc4,scn ,st1="t1" , st2="t2",st3="t3",st4="t4",st5="t5",st6="t6",stn="tn";
    Button getmem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_meeting2);

        t1=(CheckBox)findViewById(R.id.cbacademic);
        t2=(CheckBox)findViewById(R.id.cbschool);
        t3=(CheckBox)findViewById(R.id.cbhealth);
        t4=(CheckBox)findViewById(R.id.cbteacher);
        t5=(CheckBox)findViewById(R.id.cbfunding);
        t6=(CheckBox)findViewById(R.id.cbcmt);
        tnone=(CheckBox)findViewById(R.id.cbnone);

        getmem= (Button)findViewById(R.id.btnpmgetmem);
        getmem.setOnClickListener(this);

        Intent in = getIntent();
        sc1=in.getStringExtra("sc1");
        sc2=in.getStringExtra("sc2");
        sc3=in.getStringExtra("sc3");
        sc4=in.getStringExtra("sc4");
        scn=in.getStringExtra("scn");

    }


    @Override
    public void onClick(View view) {

        if(t1.isChecked()){
            st1 = t1.getText().toString();


        }
        if(t2.isChecked()){
            st2 = t2.getText().toString();

        }
        if(t3.isChecked()){
            st3 = t3.getText().toString();

        }
        if(t4.isChecked()){
            st4 = t4.getText().toString();

        }
        if(t5.isChecked()){
            st5 = t5.getText().toString();

        }
        if(t6.isChecked()){
            st6 = t6.getText().toString();
        }
        if(tnone.isChecked()){
            stn = tnone.getText().toString();
        }

        Intent i = new Intent(getApplicationContext() , Pm_members.class);
       i.putExtra("c1" , sc1);  i.putExtra("c2" , sc2); i.putExtra("c3" , sc3);
        i.putExtra("c4" , sc4);  i.putExtra("cn" , scn); i.putExtra("tn" , stn);
        i.putExtra("t1" , st1);  i.putExtra("t2" , st2); i.putExtra("t3" , st3);
        i.putExtra("t4" , st4);  i.putExtra("t5" , st5); i.putExtra("t6" , st6);
        startActivity(i);
    }
}
