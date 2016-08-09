package vinayism.kartavya;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.kosalgeek.genasync12.PostResponseAsyncTask;


public class Centre extends ActionBarActivity {

    String[] names = {"Centre 1","Centre 2","Centre 3","Centre 4","Computer Centre","Centre Problems","MAP"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.layout_centrelist , R.id.tvcentrename, names);

        listView = (ListView) findViewById(R.id.lvcentre);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);
                switch (itemPosition)
                {
                    case 0:{
                        Toast.makeText(getApplicationContext(),
                                "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                                .show();
                        Intent i = new Intent(getApplicationContext() , Centre1.class);
                        startActivity(i);
                        break;

                    }
                    case 1:{
                        Toast.makeText(getApplicationContext(),
                                "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                                .show();
                        Intent i = new Intent(getApplicationContext() , Centre2.class);
                        startActivity(i);
                        break;

                    }
                    case 2:{
                        Toast.makeText(getApplicationContext(),
                                "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                                .show();
                        Intent i = new Intent(getApplicationContext() , Centre3.class);
                        startActivity(i);
                        break;
                    }
                    case 3:{
                        Toast.makeText(getApplicationContext(),
                                "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                                .show();
                        Intent i = new Intent(getApplicationContext() , Centre4.class);
                        startActivity(i);
                        break;
                    }
                    case 4:{
                        Toast.makeText(getApplicationContext(),
                                "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                                .show();
                        Intent i = new Intent(getApplicationContext() , Computer_Centre.class);
                        startActivity(i);
                        break;
                    }
                    case 5:{

                        ConnectivityManager connec =
                                (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
                        if ( connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED )
                        {

                            // if connected with internet
                            Toast.makeText(getApplicationContext(),
                                    "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                                    .show();
                            Intent i = new Intent(getApplicationContext() , Centre_problems.class);
                            startActivity(i);


                        }else
                        {
                            Toast.makeText(getApplicationContext() , "NO INTERNET" , Toast.LENGTH_SHORT).show();
                        }

                        break;
                    }
                    case 6:{
                        Toast.makeText(getApplicationContext(),
                                "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                                .show();
                        Intent i = new Intent(getApplicationContext() , MapsActivity.class);
                        startActivity(i);
                        break;
                    }

                }
                // Show Alert


            }

        });
    }



}
