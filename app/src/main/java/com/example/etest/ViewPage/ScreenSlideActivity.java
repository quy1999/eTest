package com.example.etest.ViewPage;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.etest.R;
import com.example.etest.activity.ResultActivity;
import com.example.etest.adapter.CheckAnserAdapter;
import com.example.etest.question.Question;
import com.example.etest.question.QuestionControl;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 */


public class ScreenSlideActivity extends AppCompatActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 30;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;
    Button btnnext;
    Button btnprevious, btnsubmit;
    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter pagerAdapter;
    TextView time;
    ImageView imgkiemtra;
    QuestionControl questionControl;
    ArrayList<Question> arr_ques;
    Counter counter;
    public int check = 0;
    int num_exam;
    Button btnclose;
    String subject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_screen_slide_activity);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        btnnext = findViewById(R.id.btnnext);
        btnprevious = findViewById(R.id.btnprevious);
        time = findViewById(R.id.time);
        btnclose = findViewById(R.id.btnclose);
        btnsubmit = findViewById(R.id.btnsubmit);
        imgkiemtra = findViewById(R.id.imgkiemtra);
        counter = new Counter(10 * 240 * 1000, 1000);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

        Intent intent = getIntent();
        subject=intent.getStringExtra("subject");
        num_exam = intent.getIntExtra("num_exam",0);


        questionControl = new QuestionControl(this); //màn hình hiện tại
        arr_ques = new ArrayList<Question>();
        arr_ques = questionControl.getQuestion(num_exam,subject);






        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(ScreenSlideActivity.this, ResultActivity.class);
                intent.putExtra("arr_ques",arr_ques);
                startActivity(intent);

            }
        });

        imgkiemtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();


            }
        });
        counter.start();

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPager.setCurrentItem(getItem(+1), true);


            }
        });
        btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPager.setCurrentItem(getItem(-1), true);


            }
        });
    }



    public ArrayList<Question> getData() {
        return arr_ques;
    }


    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.create(position, check);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }

    public void checkAnswer() {
        final Dialog dialog = new Dialog(getApplicationContext());
        dialog.setContentView(R.layout.checkanswer);
        CheckAnserAdapter checkAnserAdapter = new CheckAnserAdapter(arr_ques, this);
        GridView gridView = (GridView) (dialog.findViewById(R.id.gridview));
        gridView.setAdapter(checkAnserAdapter);

        dialog.show();
    }

    public class Counter extends CountDownTimer {

        public Counter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            time.setText(countTime);
        }

        @Override
        public void onFinish() {
            time.setText("00:00");
        }
    }

    private int getItem(int i) {
        return mPager.getCurrentItem() + i;
    }


}


