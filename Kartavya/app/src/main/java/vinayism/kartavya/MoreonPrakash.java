package vinayism.kartavya;

import android.app.DownloadManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.amigold.fundapter.interfaces.DynamicImageLoader;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;

import com.google.gson.annotations.SerializedName;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;


import org.json.JSONObject;

import java.util.ArrayList;


public class MoreonPrakash extends ActionBarActivity implements AsyncResponse {

    final String LOG ="MoreonPrakash";
    vinayism.kartavya.ImageLoader imgLoader;
    ListView lvprakash;
    String url = "http://10.0.2.2/kartavya/prakash.php";
    ArrayList<PrakashList> prakashlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moreon_prakash);
        lvprakash = (ListView) findViewById(R.id.lvprakashmore);
        imgLoader = new vinayism.kartavya.ImageLoader(this);

        PostResponseAsyncTask taskachive = new PostResponseAsyncTask(MoreonPrakash.this ,this);
        taskachive.execute("http://10.0.2.2/kartavya/prakash.php");



    }

    @Override
    public void processFinish(String s) {
        prakashlist = new JsonConverter<PrakashList>().toArrayList(s,PrakashList.class);

        BindDictionary<PrakashList> dict = new BindDictionary<PrakashList>();
        dict.addStringField(R.id.tvprakash , new StringExtractor<PrakashList>() {
            @Override
            public String getStringValue(PrakashList ach, int i) {
                return ach.prakashdesc;
            }
        });
        dict.addDynamicImageField(R.id.ivpraksh , new StringExtractor<PrakashList>() {
            @Override
            public String getStringValue(PrakashList prakashList, int i) {
                return prakashList.prakashimage;
            }
        }, new DynamicImageLoader() {
            @Override
            public void loadImage(String url, ImageView imageView) {

                    imgLoader.DisplayImage("http://10.0.2.2/kartavya/"+url , imageView);
                   Log.d(LOG ,url );
            }
        });



        FunDapter<PrakashList> adapter;
        adapter = new FunDapter<>(MoreonPrakash.this, prakashlist, R.layout.layout_prakashmore , dict);
        lvprakash.setAdapter(adapter);
    }

    private class PrakashList {

        @SerializedName("desc")
        public  String prakashdesc;

       @SerializedName("img_url")
        public String prakashimage;
    }
}