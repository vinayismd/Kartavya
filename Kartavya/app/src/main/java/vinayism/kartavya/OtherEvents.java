package vinayism.kartavya;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.amigold.fundapter.interfaces.DynamicImageLoader;
import com.google.gson.annotations.SerializedName;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.ArrayList;


public class OtherEvents extends ActionBarActivity implements AsyncResponse {

    final String LOG ="OtherEvents";
    vinayism.kartavya.ImageLoader imgLoader;
    ListView lvotherevent;
    //String url = "http://10.0.2.2/kartavya/otherevents.php";
    ArrayList<OtherEvent> othereventslist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_events);

        lvotherevent = (ListView) findViewById(R.id.lvotherevents);
        imgLoader = new vinayism.kartavya.ImageLoader(this);

        PostResponseAsyncTask taskachive = new PostResponseAsyncTask(OtherEvents.this ,this);
        taskachive.execute("http://10.0.2.2/kartavya/otherevents.php");
    }


    @Override
    public void processFinish(String s) {

        othereventslist = new JsonConverter<OtherEvent>().toArrayList(s,OtherEvent.class);

        BindDictionary<OtherEvent> dict = new BindDictionary<OtherEvent>();
        dict.addStringField(R.id.tvprakash , new StringExtractor<OtherEvent>() {
            @Override
            public String getStringValue(OtherEvent ach, int i) {
                return ach.othereeventdesc;
            }
        });
        dict.addDynamicImageField(R.id.ivpraksh , new StringExtractor<OtherEvent>() {
            @Override
            public String getStringValue(OtherEvent prakashList, int i) {
                return prakashList.othereventimg;
            }
        }, new DynamicImageLoader() {
            @Override
            public void loadImage(String url, ImageView imageView) {

                imgLoader.DisplayImage("http://10.0.2.2/kartavya/img/"+url , imageView);
                Log.d(LOG, url);
            }
        });



        FunDapter<OtherEvent> adapter;
        adapter = new FunDapter<>(OtherEvents.this, othereventslist, R.layout.layout_prakashmore , dict);
        lvotherevent.setAdapter(adapter);

    }


    private class OtherEvent {

        @SerializedName("desc")
        public  String othereeventdesc;

        @SerializedName("img_url")
        public String othereventimg;
    }
}
