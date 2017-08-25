package com.luoha.u3dpic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by pander on 2016/7/21.
 */
public class PicAdapter extends FancyCoverFlowAdapter {

    List<PicBean> list;
    DisplayImageOptions build;

    public PicAdapter(List<PicBean> list) {
        this.list = list;
        build = new DisplayImageOptions.Builder().cacheOnDisk(true).cacheInMemory(true).showImageOnFail(R.mipmap.def).showImageOnLoading(R.mipmap.def).build();
    }


    @Override
    public View getCoverFlowItem(int position, View reusableView, ViewGroup parent) {

        ViewHolder holder;
        if (reusableView != null) {
            holder = (ViewHolder) reusableView.getTag();
        } else {
            reusableView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, null);
            int w = dip2px(parent.getContext(), 300);
            int h = dip2px(parent.getContext(), 300);
            reusableView.setLayoutParams(new FancyCoverFlow.LayoutParams(w, h));
            holder = new ViewHolder();
            holder.iv = (ImageView) reusableView.findViewById(R.id.iv);
            reusableView.setTag(holder);
        }

        int p = position%list.size();
        PicBean picBean = list.get(p);
        String url = picBean.url;
        ImageView iv = holder.iv;

        ImageLoader.getInstance().displayImage(url, iv, build, null);


        return reusableView;
    }

    @Override
    public int getCount() {
        return list == null|| list.size() ==0 ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position%list.size());
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder {
        ImageView iv;
    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
