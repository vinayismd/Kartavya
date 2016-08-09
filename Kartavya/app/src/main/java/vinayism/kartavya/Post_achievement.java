package vinayism.kartavya;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;


public class Post_achievement extends ActionBarActivity implements View.OnClickListener {

    final String LOG = "Post_achievement";
    EditText achtitle , achdesc;
    String  pickadmno;
    Button postach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_achievement);

        postach =(Button)findViewById(R.id.btnpostcp);
        achtitle =(EditText)findViewById(R.id.etpachtitle);
        achdesc =(EditText)findViewById(R.id.etpachdesc);

        Intent in = getIntent();
        pickadmno = in.getStringExtra("admno");

        postach.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (achdesc.getText().toString().trim().equals("") || achtitle.getText().toString().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "Some Fields are Empty", Toast.LENGTH_SHORT).show();
        } else {
            HashMap postach = new HashMap();

            postach.put("title", achtitle.getText().toString());
            postach.put("desc", achdesc.getText().toString());
            postach.put("admno", pickadmno);

            PostResponseAsyncTask taskpcp = new PostResponseAsyncTask(Post_achievement.this, postach, new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    Log.d(LOG, s);
                    if (s.contains("success")) {
                        Toast.makeText(Post_achievement.this, "Achievement Posted", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Post_achievement.this, Profile.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(Post_achievement.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }
                }

            });
            taskpcp.execute("http://10.0.2.2/kartavya/postachievement.php");
        }
    }
}
