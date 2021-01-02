package org.techtown.ap18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTitleStrip;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation translateIn;
    Animation translateOut;

    CardItemView view;
    CardItemView view2;

    FrameLayout itemLayout;
    TextView textView;

    AnimThread thread;
    textAnimThread text_thread;

    boolean running = false;
    boolean text_running = true;

    boolean idx = false;
    int value;

    int selected = -1;
    int text_selected = -1;

    String dot;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemLayout = findViewById(R.id.itemLayout);

        view = new CardItemView(this);
        view.setImageView(R.drawable.customer);
        view.setName("홍길동");
        view.setMobile("010-7788-1234");
        view.setLocate("서울시");
        itemLayout.addView(view);

        view2 = new CardItemView(this);
        view2.setImageView(R.drawable.customer);
        view2.setName("김영희");
        view2.setMobile("010-9988-4321");
        view2.setLocate("인천시");
        itemLayout.addView(view2);

        //itemLayout.setVisibility(View.GONE); // 잠깐체크

        view2.setVisibility(View.GONE);

        textView = findViewById(R.id.textView2);

        text_thread = new textAnimThread();
        text_thread.start();

        translateIn = AnimationUtils.loadAnimation(this, R.anim.translate_in);
        translateOut = AnimationUtils.loadAnimation(this, R.anim.translate_out);

        SlidingItemAnimationListener animListener = new SlidingItemAnimationListener();
        translateIn.setAnimationListener(animListener);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (text_thread.isAlive())
                {
                    text_running = false;
                }

                if (!idx)
                {
                    textView.setText("1 / 2");
                }
                else
                {
                    selected++;
                }

                itemLayout.setVisibility(View.VISIBLE);

                thread = new AnimThread();
                thread.start();

                text_running = false;
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (thread.isAlive())
                {
                    running = false;
                }

                itemLayout.setVisibility(View.GONE);
                text_selected = -1;

                text_thread = new textAnimThread();
                text_thread.start();

                running = false;
            }
        });
    }

    class AnimThread extends Thread
    {
        public void run()
        {
            running = true;

            while (running)
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (selected == 0 && idx)
                        {
                            view2.setVisibility(View.VISIBLE);

                            view.startAnimation(translateOut);
                            view2.startAnimation(translateIn);
                        }
                        else if (selected == 1 && idx)
                        {
                            view.setVisibility(View.VISIBLE);

                            view.startAnimation(translateIn);
                            view2.startAnimation(translateOut);
                        }
                    }
                });

                if (!idx)
                {
                    idx = true;
                }
                else
                {
                    selected += 1;
                    selected %= 2;
                }

                try {
                    Thread.sleep(2000);
                } catch (Exception e) {}
            }
        }
    }

    class textAnimThread extends Thread
    {
        public void run()
        {
            text_running = true;

            while (text_running)
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        dot = "";

                        for (int i = 0; i < text_selected; i++)
                        {
                            dot += ".";
                        }

                        textView.setText("대기 중" + dot);
                    }
                });

                text_selected += 1;
                text_selected %= 4;

                try {
                    Thread.sleep(500);
                } catch (Exception e) {}
            }
        }
    }

    private class SlidingItemAnimationListener implements Animation.AnimationListener
    {
        public void onAnimationEnd(Animation animation) {
            if (running)
            {
                if (selected == 0) // 두 번째 item 출력 직후
                {
                    value = 2;
                    view.setVisibility(View.GONE);
                }
                else // 첫 번째 item 출력 직후
                {
                    value = 1;
                    view2.setVisibility(View.GONE);
                }

                textView.setText(String.valueOf(value) + " / 2");
            }
        }

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}