package teddywilson.animationspractice.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import teddywilson.animationspractice.R;

/**
 * Created by Theodore Wilson on 4/19/17.
 * © Toeboat LLC
 */

public class PhotoGalleryAdapter  extends RecyclerView.Adapter<PhotoGalleryAdapter.ViewHolder> {

    Activity mActivity;
    List<String> mData;

    public PhotoGalleryAdapter(Activity activity, List<String> data) {
        mActivity = activity;
        mData = data;
    }

    @Override
    public int getItemCount(){
        return mData.size();
    }

    @Override
    public PhotoGalleryAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.row_photo_gallery, viewGroup, false);
        return new PhotoGalleryAdapter.ViewHolder((ImageView) v);
    }

    @Override
    public void onBindViewHolder(PhotoGalleryAdapter.ViewHolder vh, int pos){
        Glide.with(mActivity).load(mData.get(pos)).centerCrop().into(vh.mParent);
    }

    public void updateData(List<String> newData){
        mData = newData;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView mParent;

        ViewHolder(ImageView root){
            super(root);
            mParent = root;
        }

    }
}
