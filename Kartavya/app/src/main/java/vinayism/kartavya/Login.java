package vinayism.kartavya;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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


public class Login extends ActionBarActivity implements View.OnClickListener {

    final String LOG = "Login";
    EditText admno , pass;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        admno =(EditText)findViewById(R.id.etloginadmno);
        pass = (EditText)findViewById(R.id.etloginpwd);
        login=(Button)findViewById(R.id.btnlogin);
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        HashMap logindata = new HashMap();
        logindata.put("admno",admno.getText().toString());
        logindata.put("pwd",pass.getText().toString());

        PostResponseAsyncTask tasklogin = new PostResponseAsyncTask(Login.this , logindata , new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                Log.d(LOG , s);
                if(s.contains("success"))
                {
                    Toast.makeText(getApplicationContext() , "Login Successful" , Toast.LENGTH_SHORT).show();
                    //for passing the admission to another activity



                    Intent in = new Intent(getApplicationContext() , Profile.class);
                     in.putExtra("admno" , admno.getText().toString());
                    startActivity(in);


                }
                else
                {
                    Toast.makeText(getApplicationContext() , "ERROR/Password Incorrect" , Toast.LENGTH_SHORT).show();
                }
            }
        });
      tasklogin.execute("http://10.0.2.2/kartavya/login.php");
    }
}
