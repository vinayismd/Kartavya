package vinayism.kartavya;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;


public class Splash extends Activity {

    Animation anim1 , anim2;
    ImageView iv1 , iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        iv1 = (ImageView)findViewById(R.id.splashimageView1);
       // iv2 = (ImageView)findViewById(R.id.splashimageView2);

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent main = new Intent(getApplicationContext() , MainActivity.class);
                    startActivity(main);
                }
            }
        };
        timer.start();

    }



}
