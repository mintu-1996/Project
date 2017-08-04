package com.example.mintu_1996.project;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by mintu_1996 on 8/4/2017.
 */

class CustomPagerAdapter extends PagerAdapter {

    Context mContext;
    int [] mresources;
    int length;
    LayoutInflater mLayoutInflater;

    public CustomPagerAdapter(Context context,int [] mresources,int len) {
        mContext = context;
        this.mresources=mresources;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        length=len;
    }

    @Override
    public int getCount() {
        //Object mResources;
        return length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        int[] mResources=this.mresources;
        imageView.setImageResource(mResources[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
