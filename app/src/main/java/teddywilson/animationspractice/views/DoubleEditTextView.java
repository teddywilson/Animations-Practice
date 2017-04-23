package teddywilson.animationspractice.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import teddywilson.animationspractice.R;

/**
 * Created by Theodore Wilson on 4/23/17.
 * © Toeboat LLC
 */

public class DoubleEditTextView extends LinearLayout {

    Context mContext;
    View mRoot;
    EditText editText1, editText2;
    String mHint1, mHint2;

    public DoubleEditTextView(Context context){
        super(context);
        mContext = context;
        init();
    }

    public DoubleEditTextView(Context context, AttributeSet attrs){
        super(context, attrs);
        mContext = context;

        TypedArray arr = mContext.obtainStyledAttributes(attrs, R.styleable.DoubleEditTextView);
        try {
            mHint1 = arr.getString(R.styleable.DoubleEditTextView_hint1);
            mHint2 = arr.getString(R.styleable.DoubleEditTextView_hint2);
        } finally {
            arr.recycle();
        }

        init();
    }

    private void init(){
        LayoutInflater inflater = LayoutInflater.from(mContext);
        mRoot = inflater.inflate(R.layout.custom_double_edit_text, this, true);
        editText1 = (EditText) mRoot.findViewById(R.id.edit_text_1);
        editText2 = (EditText) mRoot.findViewById(R.id.edit_text_2);

        editText1.setHint(mHint1);
        editText2.setHint(mHint2);
    }

}
