package vinayism.kartavya;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Myinfo extends ActionBarActivity {

    TextView name , admno , pass, year, branch , centre , team , wrkun , phnno , email;
    String url = "http://10.0.2.2/kartavya/myinfo.php";
    String pickadmno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);
        name = (TextView)findViewById(R.id.tvmyinfoname);
        admno = (TextView)findViewById(R.id.tvmyinfoadmno);
        pass = (TextView)findViewById(R.id.tvmyinfopass);
        year = (TextView)findViewById(R.id.tvmyinfoyear);
        branch = (TextView)findViewById(R.id.tvmyinfobranch);
        centre = (TextView)findViewById(R.id.tvmyinfocentre);
        team = (TextView)findViewById(R.id.tvmyinfoteam);
        wrkun = (TextView)findViewById(R.id.tvmyinfowrkun);
        phnno = (TextView)findViewById(R.id.tvmyinfophnno);
        email = (TextView)findViewById(R.id.tvmyinfoemail);

        Intent i = getIntent();
         pickadmno= i.getStringExtra("admno");
          admno.setText(pickadmno);

        final JsonObjectRequest requestmyinfo = new JsonObjectRequest(Request.Method.POST , url ,null , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {


                try{
                    name.setText(jsonObject.getString("name"));
                   // admno.setText(jsonObject.getString("admno"));
                    pass.setText(jsonObject.getString("pass"));
                    year.setText(jsonObject.getString("year"));
                    branch.setText(jsonObject.getString("branch"));
                    centre.setText(jsonObject.getString("centre"));
                    team.setText(jsonObject.getString("team"));
                    wrkun.setText(jsonObject.getString("wrkun"));
                    phnno.setText(jsonObject.getString("phnno"));
                    email.setText(jsonObject.getString("email"));

                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Toast.makeText(getApplicationContext() , "Some Error" , Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Toast.makeText(getApplicationContext() , "Run1" , Toast.LENGTH_SHORT).show();
                Map<String,String> params = new HashMap<>();
                params.put("admno",pickadmno);
                return params;
            }

        };

         MySingleton.getInstance(Myinfo.this).addToRequestQueue(requestmyinfo);
    }



}
