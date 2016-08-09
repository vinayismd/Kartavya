package vinayism.kartavya;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.google.gson.annotations.SerializedName;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.ArrayList;


public class Achievements extends ActionBarActivity implements AsyncResponse {

    final String LOG ="Achievements";
    private ListView lv;
    private ArrayList<Achievement> achievements;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        lv = (ListView)findViewById(R.id.lvachievement);
        PostResponseAsyncTask taskachive = new PostResponseAsyncTask(Achievements.this ,this);
        taskachive.execute("http://10.0.2.2/kartavya/achievements.php");
    }


    @Override
    public void processFinish(String s) {

        achievements = new JsonConverter<Achievement>().toArrayList(s,Achievement.class);

        BindDictionary<Achievement> dict = new BindDictionary<Achievement>();
        dict.addStringField(R.id.tvlistachtop , new StringExtractor<Achievement>() {
            @Override
            public String getStringValue(Achievement ach, int i) {
                return ach.achievetopic;
            }
        });
        dict.addStringField(R.id.tvlistachdesc , new StringExtractor<Achievement>() {
            @Override
            public String getStringValue(Achievement ach, int i) {
                return ""+ ach.achievedesc;
            }
        });


        FunDapter<Achievement> adapter;
        adapter = new FunDapter<>(Achievements.this, achievements, R.layout.layout_achievement , dict);
        lv.setAdapter(adapter);
    }

    private class Achievement {

        @SerializedName("title")
        public  String achievetopic;

        @SerializedName("achievement")
        public String achievedesc;
    }
}
