package teddywilson.animationspractice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Theodore Wilson on 4/3/17.
 * © Toeboat LLC
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Activity mActivity;

    public Adapter(Activity activity) {
        mActivity = activity;
    }

    @Override
    public int getItemCount(){
        return 2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.row_anim_type, viewGroup, false);
        return new ViewHolder((CardView) v);
    }

    @Override
    public void onBindViewHolder(ViewHolder vh, int pos){
        switch (pos){
            case 0:
                vh.tv.setText("Fade in/out");
                vh.parent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mActivity.startActivity(new Intent(mActivity, FadeActivity.class));
                    }
                });
                break;

            case 1:
                vh.tv.setText("Dots animations");
                vh.parent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mActivity.startActivity(new Intent(mActivity, DotsActivity.class));
                    }
                });
                break;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        CardView parent;
        TextView tv;

        ViewHolder(CardView root){
            super(root);
            parent = root;
            tv = (TextView) root.findViewById(R.id.text_view);
        }

    }
}
