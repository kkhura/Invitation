package com.codeliver128.shaadiinvitation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.codeliver128.shaadiinvitation.R;
import com.codeliver128.shaadiinvitation.fragment.UploadInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HorizontalPagerAdapter extends PagerAdapter {


    private Context mContext;
    private LayoutInflater mLayoutInflater;
private List<UploadInfo> list;

    public HorizontalPagerAdapter(final Context context, ArrayList<UploadInfo> list) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public int getItemPosition(final Object object) {
        return POSITION_NONE;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final View view;
            view = mLayoutInflater.inflate(R.layout.item_image, container, false);
            UploadInfo uploadInfo=list.get(position);

        ImageView imageView=view.findViewById(R.id.img_view);
        Picasso.with(mContext)
                .load(uploadInfo.getFileUrl())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(final View view, final Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView((View) object);
    }
}
