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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;


public class Register extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    final String LOG = "Register";
    EditText name, admno, pwd, year, wrkun, brnch  ,phnno , email;
    Spinner spncentre , spnteam;
    String steam , scentre;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) findViewById(R.id.etname);
        pwd = (EditText) findViewById(R.id.etpass);
        admno = (EditText) findViewById(R.id.etadmno);
        spncentre = (Spinner) findViewById(R.id.spnregcntr);
        year = (EditText) findViewById(R.id.etyear);
        wrkun = (EditText) findViewById(R.id.etwrkun);
        brnch = (EditText) findViewById(R.id.etbranch);
        spnteam = (Spinner) findViewById(R.id.spnregteam);
        phnno = (EditText) findViewById(R.id.etphnno);
        email = (EditText) findViewById(R.id.etemail);
        register = (Button) findViewById(R.id.btnregister);
        register.setOnClickListener(this);


        spncentre.setOnItemSelectedListener(this);
        spnteam.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> centre  = ArrayAdapter.createFromResource(this,
                R.array.spnmemcentre, android.R.layout.simple_spinner_dropdown_item);
        centre.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spncentre.setAdapter(centre);

        ArrayAdapter<CharSequence> team  = ArrayAdapter.createFromResource(this,
                R.array.spnmemteam, android.R.layout.simple_spinner_dropdown_item);
        team.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnteam.setAdapter(team);

    }


    @Override
    public void onClick(View view) {

        if (name.getText().toString().trim().equals("") || email.getText().toString().trim().equals("")
                || pwd.getText().toString().trim().equals("") || admno.getText().toString().trim().equals("")
                || year.getText().toString().trim().equals("") || wrkun.getText().toString().trim().equals("")
                || brnch.getText().toString().trim().equals("") || phnno.getText().toString().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "Some Fields are Empty", Toast.LENGTH_SHORT).show();
        } else {
            HashMap postdata = new HashMap();

            postdata.put("name", name.getText().toString());
            postdata.put("pwd", pwd.getText().toString());
            postdata.put("admno", admno.getText().toString());
            postdata.put("centr", scentre);
            postdata.put("year", year.getText().toString());
            postdata.put("wrkun", wrkun.getText().toString());
            postdata.put("brnch", brnch.getText().toString());
            postdata.put("team", steam);
            postdata.put("phnno", phnno.getText().toString());
            postdata.put("email", email.getText().toString());
            postdata.put("mobile", "android");


            PostResponseAsyncTask taskreg = new PostResponseAsyncTask(Register.this, postdata, new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    Log.d(LOG, s);
                    if (s.contains("success")) {
                        Toast.makeText(Register.this, "INsert Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Register.this, MainActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(Register.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }
                }

            });
            taskreg.execute("http://10.0.2.2/kartavya/register.php");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Spinner spinner = (Spinner) adapterView;
        String item = adapterView.getItemAtPosition(position).toString();
        if(spinner.getId() == R.id.spnregcntr)
        {
            scentre = item;
           Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
            //do this
        }
        else if(spinner.getId() == R.id.spnregteam)
        {
            steam = item;
            Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
            //do this
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
