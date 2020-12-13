package org.techtown.ap18;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CardItemView extends LinearLayout {

    ImageView imageView;
    TextView textView;
    TextView textView2;
    TextView textView3;

    public CardItemView(Context context) {
        super(context);

        init(context);
    }

    public CardItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.info_item, this, true);

        imageView = findViewById(R.id.imageView);

        textView = findViewById(R.id.textView_cv);
        textView2 = findViewById(R.id.textView2_cv);
        textView3 = findViewById(R.id.textView3_cv);
    }

    public void setImageView(int resId)
    {
        imageView.setImageResource(resId);
    }

    public void setName(String name)
    {
        textView.setText(name);
    }

    public void setMobile(String mobile)
    {
        textView2.setText(mobile);
    }

    public void setLocate(String locate)
    {
        textView3.setText(locate);
    }
}
