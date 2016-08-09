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


public class Post_centreproblem extends ActionBarActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    final String LOG = "Post_centreproblem";
    EditText cptitle , cpdesc;
    Spinner spncentre;
    String scentre , pickadmno;
    Button postcp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_centreproblem);

        spncentre = (Spinner) findViewById(R.id.spnpcpcntr);
        postcp =(Button)findViewById(R.id.btnpostcp);
        cptitle =(EditText)findViewById(R.id.etpcptitle);
        cpdesc =(EditText)findViewById(R.id.etpcpdesc);

        ArrayAdapter<CharSequence> centre  = ArrayAdapter.createFromResource(this,
                R.array.spnmemcentre, android.R.layout.simple_spinner_dropdown_item);
        centre.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spncentre.setAdapter(centre);

        Intent in = getIntent();
        pickadmno = in.getStringExtra("admno");

        spncentre.setOnItemSelectedListener(this);

        postcp.setOnClickListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

        Spinner spinner = (Spinner) adapterView;
        String item = adapterView.getItemAtPosition(position).toString();
        scentre = item;
        Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

        if (cpdesc.getText().toString().trim().equals("") || cptitle.getText().toString().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "Some Fields are Empty", Toast.LENGTH_SHORT).show();
        } else {
            HashMap postcp = new HashMap();

            postcp.put("title", cptitle.getText().toString());
            postcp.put("desc", cpdesc.getText().toString());
            postcp.put("centre", scentre);
            postcp.put("admno", pickadmno);

            PostResponseAsyncTask taskpcp = new PostResponseAsyncTask(Post_centreproblem.this, postcp, new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    Log.d(LOG, s);
                    if (s.contains("success")) {
                        Toast.makeText(Post_centreproblem.this, "Problem Posted", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Post_centreproblem.this, Profile.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(Post_centreproblem.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }
                }

            });
            taskpcp.execute("http://10.0.2.2/kartavya/postcentreproblem.php");
        }
    }
}
