package vinayism.kartavya;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;


public class Temp1 extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    final String LOG = "Temp1";
    Spinner spncntr , spnteam;
    String team , centre;
    Button getmem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp1);

        spncntr = (Spinner)findViewById(R.id.spnmemcentre);
        spnteam = (Spinner)findViewById(R.id.spnmemteam);
        getmem = (Button)findViewById(R.id.btngetmem);
        getmem.setOnClickListener(this);

        spncntr.setOnItemSelectedListener(this);
        spnteam.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> centre  = ArrayAdapter.createFromResource(this,
                R.array.spnmemcentre, android.R.layout.simple_spinner_dropdown_item);
        centre.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spncntr.setAdapter(centre);

        ArrayAdapter<CharSequence> team  = ArrayAdapter.createFromResource(this,
                R.array.spnmemteam, android.R.layout.simple_spinner_dropdown_item);
        team.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnteam.setAdapter(team);
    }


    @Override
    public void onClick(View view) {

        HashMap mem = new HashMap();
        mem.put("centre", centre);
        mem.put("team" , team );


        PostResponseAsyncTask getmem = new PostResponseAsyncTask(Temp1.this, mem, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                Log.d(LOG, s);
                if(s.contains("success"))
                {
                    Toast.makeText(Temp1.this, "Loding.. Members", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Temp1.this , Temp2.class);
                    i.putExtra("centre" , centre);
                    i.putExtra("team", team);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Temp1.this , "No Members" , Toast.LENGTH_SHORT).show();
                }
            }

        });
        getmem.execute("http://10.0.2.2/kartavya/members.php");

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner spinner = (Spinner) adapterView;
        String item = adapterView.getItemAtPosition(i).toString();
        if(spinner.getId() == R.id.spnmemcentre)
        {
            centre = item;
//            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
            //do this
        }
        else if(spinner.getId() == R.id.spnmemteam)
        {
            team = item;
            // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
            //do this
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
