package vinayism.kartavya;

import android.content.Intent;
import android.net.ConnectivityManager;
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


public class Internship extends ActionBarActivity implements View.OnClickListener {

    final String LOG = "Internship";
    EditText name , email , phone , know , why;
    Button apply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internship);

        name = (EditText)findViewById(R.id.etintrnname);
        email = (EditText)findViewById(R.id.etinternemail);
        phone =(EditText)findViewById(R.id.etinternphnno);
        know = (EditText)findViewById(R.id.etinternknow);
        why = (EditText)findViewById(R.id.etinternjoin);
        apply = (Button)findViewById(R.id.btninternapply);
        apply.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {

        ConnectivityManager connec =
                (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
        if ( connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED )
        {

            if(name.getText().toString().trim().equals("") ||email.getText().toString().trim().equals("")
                    ||phone.getText().toString().trim().equals("")||know.getText().toString().trim().equals("")
                    ||why.getText().toString().trim().equals(""))
            {
                Toast.makeText(getApplicationContext() , "Some Fields are Empty" ,Toast.LENGTH_SHORT).show();
            }else{
                HashMap interns = new HashMap();

                interns.put("name" , name.getText().toString());
                interns.put("email", email.getText().toString());
                interns.put("phone" , phone.getText().toString());
                interns.put("know", know.getText().toString());
                interns.put("why" , why.getText().toString());

                PostResponseAsyncTask taskreg = new PostResponseAsyncTask(Internship.this, interns, new AsyncResponse() {
                    @Override
                    public void processFinish(String s) {
                        Log.d(LOG, s);
                        if(s.contains("success"))
                        {
                            Toast.makeText(Internship.this, "Successfully Applied", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Internship.this , MainActivity.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(Internship.this , "ERROR" , Toast.LENGTH_SHORT).show();
                        }
                    }

                });
                taskreg.execute("http://10.0.2.2/kartavya/internship.php");
            }



        }else
        {
            Toast.makeText(getApplicationContext() , "NO INTERNET" , Toast.LENGTH_SHORT).show();
        }




    }
}
