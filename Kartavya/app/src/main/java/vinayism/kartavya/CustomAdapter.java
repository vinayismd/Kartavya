package vinayism.kartavya;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CustomAdapter extends PagerAdapter{

    Context context;
    int[] imageId = {R.drawable.p1, R.drawable.p2,R.drawable.p5, R.drawable.p6,R.drawable.p7, R.drawable.p11,R.drawable.p12};
int j=0;
    public CustomAdapter(Context context){
        this.context = context;

    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();

        View viewItem = inflater.inflate(R.layout.image_item, container, false);
        final ImageView imageView = (ImageView) viewItem.findViewById(R.id.imageView);
//        new CountDownTimer(1200,300) {
//
//            @Override
//            public void onTick(long millisUntilFinished) {}
//
//            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public void onFinish() {
//                imageView.setImageDrawable(CustomAdapter.this.context.getDrawable(imageId[j]));
//                j++;
//                if(j== imageId.length-1) j=0;
//                start();
//            }
//        }.start();
        imageView.setImageResource(imageId[position]);
        imageView.setMinimumHeight(235);
        imageView.setMinimumWidth(1600);
        ((ViewPager)container).addView(viewItem);

        return viewItem;
    }



    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imageId.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // TODO Auto-generated method stub

        return view == ((View)object);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        ((ViewPager) container).removeView((View) object);
    }

}