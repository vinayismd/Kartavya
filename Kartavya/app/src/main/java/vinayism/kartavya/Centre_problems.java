package vinayism.kartavya;

import android.net.ConnectivityManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.google.gson.annotations.SerializedName;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.ArrayList;


public class Centre_problems extends ActionBarActivity implements AsyncResponse {

    final String LOG ="Centre_problems";
    private ListView lv;
    private ArrayList<Centreproblem> cp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre_problems);
        lv = (ListView)findViewById(R.id.lvcentreproblems);


            PostResponseAsyncTask cp = new PostResponseAsyncTask(Centre_problems.this ,this);
            cp.execute("http://10.0.2.2/kartavya/centreproblems.php");


    }

    @Override
    public void processFinish(String s) {
        cp = new JsonConverter<Centreproblem>().toArrayList(s,Centreproblem.class);

        BindDictionary<Centreproblem> dict = new BindDictionary<Centreproblem>();
        dict.addStringField(R.id.tvcpcentre , new StringExtractor<Centreproblem>() {
            @Override
            public String getStringValue(Centreproblem cp, int i) {
                return cp.centre;
            }
        });
        dict.addStringField(R.id.tvcptitle , new StringExtractor<Centreproblem>() {
            @Override
            public String getStringValue(Centreproblem cp, int i) {
                return ""+ cp.title;
            }
        });
        dict.addStringField(R.id.tvcpdesc , new StringExtractor<Centreproblem>() {
            @Override
            public String getStringValue(Centreproblem cp, int i) {
                return cp.desc;
            }
        });
        dict.addStringField(R.id.tvcpname , new StringExtractor<Centreproblem>() {
            @Override
            public String getStringValue(Centreproblem cp, int i) {
                return ""+ cp.name;
            }
        });
        dict.addStringField(R.id.tvcpphnno , new StringExtractor<Centreproblem>() {
            @Override
            public String getStringValue(Centreproblem cp, int i) {
                return ""+ cp.phnno;
            }
        });

        FunDapter<Centreproblem> adapter;
        adapter = new FunDapter<>(Centre_problems.this, cp, R.layout.layout_centreproblem , dict);
        lv.setAdapter(adapter);
    }


    private class Centreproblem {
        @SerializedName("centre")
        public String centre;

        @SerializedName("title")
        public String title;

        @SerializedName("desc")
        public String desc;

        @SerializedName("name")
        public String name;

        @SerializedName("phnno")
        public String phnno;





    }
}
