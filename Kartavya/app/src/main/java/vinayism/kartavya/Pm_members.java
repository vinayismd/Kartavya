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
import java.util.HashMap;


public class Pm_members extends ActionBarActivity {

    ListView pmmember;

    private ArrayList<Pmmember> memlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm_members);

        pmmember =(ListView)findViewById(R.id.lvpmmembers);
        HashMap  mem = new HashMap();
        mem.put("centre" , "Centre1");
        mem.put("team" ,"School");

        PostResponseAsyncTask pmmem = new PostResponseAsyncTask(Pm_members.this , mem , new AsyncResponse() {
            @Override
            public void processFinish(String s) {

                memlist = new JsonConverter<Pmmember>().toArrayList(s , Pmmember.class);
                BindDictionary<Pmmember> dict = new BindDictionary<>();
                dict.addStringField(R.id.tvpmname , new StringExtractor<Pmmember>() {
                    @Override
                    public String getStringValue(Pmmember pmmember, int i) {
                        return pmmember.pmname;
                    }
                });
                dict.addStringField(R.id.tvpmphnno , new StringExtractor<Pmmember>() {
                    @Override
                    public String getStringValue(Pmmember pmmember, int i) {
                        return pmmember.pmphnno;
                    }
                });

                FunDapter<Pmmember> adapt;
                adapt = new FunDapter<>(Pm_members.this , memlist , R.layout.layout_pmmembers , dict);
                pmmember.setAdapter(adapt);
            }
        });
        pmmem.execute("http://10.0.2.2/kartavya/pmmemberlist.php");
    }


    private class Pmmember {

        @SerializedName("pmname")
        public  String pmname;
        @SerializedName("pmphnno")
        public  String pmphnno;
    }
}
