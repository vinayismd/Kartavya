package vinayism.kartavya;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
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


public class Temp2 extends Activity {

    ListView memberlist;

    private ArrayList<Membername> memlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp2);
        memberlist = (ListView)findViewById(R.id.lvmemberlist);




        Intent in = getIntent();
        String cent= in.getStringExtra("centre");
        String te= in.getStringExtra("team");

        HashMap mem = new HashMap();
        mem.put("centre", cent);
        mem.put("team" , te );


        PostResponseAsyncTask listmem = new PostResponseAsyncTask(Temp2.this, mem, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                memlist = new JsonConverter<Membername>().toArrayList(s,Membername.class);

                BindDictionary<Membername> dict = new BindDictionary<Membername>();
                dict.addStringField(R.id.tvmemname , new StringExtractor<Membername>() {
                    @Override
                    public String getStringValue(Membername mn, int i) {
                        return "Name :"+mn.memname;
                    }
                });
                dict.addStringField(R.id.tvmemphnno , new StringExtractor<Membername>() {
                    @Override
                    public String getStringValue(Membername mn, int i) {
                        return  "Phone no :"+mn.memphnno;
                    }
                });



                FunDapter<Membername> adapter;
                adapter = new FunDapter<>(Temp2.this, memlist, R.layout.layout_member , dict);
                memberlist.setAdapter(adapter);
            }

        });
        listmem.execute("http://10.0.2.2/kartavya/memberlist.php");


    }


    private class Membername {

        @SerializedName("name")
        public  String memname;

        @SerializedName("phnno")
        public String memphnno;


    }

}
