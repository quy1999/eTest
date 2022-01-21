package com.example.etest.ViewPage;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.etest.R;
import com.example.etest.activity.ResultActivity;
import com.example.etest.adapter.CheckAnserAdapter;
import com.example.etest.main.MainActivity;
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
    private static final int REQUEST_CODE_EXAMPLE = 0x9345;

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
    String countTimess;
    Counter counter;
    public int check;
    public int checks = 0;

    int num_exam;
    Button btnexit;
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
        btnexit = findViewById(R.id.btnexit);
        btnsubmit = findViewById(R.id.btnsubmit);
        imgkiemtra = findViewById(R.id.imgkiemtra);
        counter = new Counter(10 * 240 * 1000, 1000); //1000 mili giây phương thức OnTik chjay 1 lần
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

        Intent intent = getIntent();

        num_exam = intent.getIntExtra("num_exam", 0);


        questionControl = new QuestionControl(this); //màn hình hiện tại
        arr_ques = new ArrayList<Question>();
        arr_ques = questionControl.getQuestion(num_exam);


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScreenSlideActivity.this, ResultActivity.class);
                intent.putExtra("arr_ques", arr_ques);
                intent.putExtra("key_time", countTimess);
                startActivity(intent);


                startActivityForResult(intent, REQUEST_CODE_EXAMPLE);


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

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ScreenSlideActivity.this);
                builder.setTitle("Thoát").
                        setMessage("Bạn có chắc chắn muốn Thoát không?" + "Nếu ấn Thoát dữ liệu sẽ không được lưu");
                builder.setPositiveButton("Có",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                SharedPreferences settings = getSharedPreferences("PREFS_NAME", 0);
                                SharedPreferences.Editor editor = settings.edit();
                                editor.putBoolean("isChecked", false);
                                editor.commit();
                                Intent i = new Intent(getApplicationContext(),
                                        MainActivity.class);
                                startActivity(i);
                            }
                        });
                builder.setNegativeButton("Không",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
        });


        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ScreenSlideActivity.this);
                builder.setTitle("Thoát").
                        setMessage("Bạn có chắc chắn muốn Thoát không?" + "Nếu ấn Thoát dữ liệu sẽ không được lưu");
                builder.setPositiveButton("Có",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent i = new Intent(getApplicationContext(),
                                        MainActivity.class);
                                startActivity(i);
                            }
                        });
                builder.setNegativeButton("Không",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
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

    public void checks() {




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
        CheckAnserAdapter checkAnserAdapter = new CheckAnserAdapter(arr_ques, this);


    }

    public class Counter extends CountDownTimer {

        public Counter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) { // bộ đếm chưa kết thúc
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            time.setText(countTime);
            countTimess = countTime;

        }

        @Override
        public void onFinish() { //khi bộ đếm kết thúc
            time.setText("Kết thúc");
            btnsubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    Intent intent = new Intent(ScreenSlideActivity.this, ResultActivity.class);
                    intent.putExtra("arr_ques", arr_ques);
                    startActivity(intent);

                }
            });


        }


    }

    private int getItem(int i) {
        return mPager.getCurrentItem() + i;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_EXAMPLE) {  // Kiểm tra requestCode có trùng với REQUEST_CODE vừa dùng
            if(resultCode == Activity.RESULT_OK) {
                //Nhận dữ liệu intent trả về
                final String result = data.getStringExtra(ResultActivity.EXTRA_DATA);
                checks();


            }
        }


    }
}



