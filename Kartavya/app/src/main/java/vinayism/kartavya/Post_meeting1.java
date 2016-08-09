package vinayism.kartavya;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class Post_meeting1 extends ActionBarActivity implements View.OnClickListener {

    CheckBox c1 , c2 , c3,c4 ,none;
    String sc1,sc2,sc3,sc4,scn;
    Button nxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_meeting1);

        c1=(CheckBox)findViewById(R.id.cbcentre1);
        c2=(CheckBox)findViewById(R.id.cbcentre2);
        c3=(CheckBox)findViewById(R.id.cbcentre3);
        c4=(CheckBox)findViewById(R.id.cbcentre4);
        none=(CheckBox)findViewById(R.id.cbnone);
        nxt = (Button)findViewById(R.id.btnpmnext);
        nxt.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        if(c1.isChecked()){
            sc1 = c1.getText().toString();
            Toast.makeText(getApplicationContext(), sc1, Toast.LENGTH_SHORT).show();
        }else{
            sc1 = "1";
        }
        if(c2.isChecked()){
            sc2 = c2.getText().toString();
        }else{
            sc2="2";
        }
        if(c3.isChecked()){
            sc3 = c3.getText().toString();
        }else {
            sc3 ="3";
        }
        if(c4.isChecked()){
            sc4 = c4.getText().toString();
        }else{
            sc4 ="4";
        }
        if(none.isChecked()){
            scn = none.getText().toString();
        }else{
            scn = "none";
        }



        Intent i = new Intent(getApplicationContext() , Post_meeting2.class);
        i.putExtra("sc1" , sc1);
        i.putExtra("sc2" , sc2);
        i.putExtra("sc3" , sc3);
        i.putExtra("sc4" , sc4);
        i.putExtra("scn" , scn);
        startActivity(i);

    }
}
