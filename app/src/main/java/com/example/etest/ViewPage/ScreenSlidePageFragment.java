package com.example.etest.ViewPage;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.etest.R;
import com.example.etest.question.Question;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScreenSlidePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScreenSlidePageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_CHECK = "check";
    public int check; //kiểm tra đáp án

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int PageNumber;
    TextView tvNum, tvQuestion;
    RadioButton radA, radB, radC, radD;
    RadioGroup radGroup;
    ArrayList<Question> arr_ques;
    View view;
    TextView edtTime;
    ImageView imgclock;
    CountDownTimer Timer;


    public static String Key = "english";


    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }

    /**
     * @return A new instance of fragment ScreenSlidePageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScreenSlidePageFragment newInstance(String param1, String param2, int check, ArrayList<Question> arr_Que) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_CHECK, check);
        fragment.setArguments(args);
        return fragment;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }

        arr_ques = new ArrayList<Question>();
        ScreenSlideActivity screenSlideActivity = (ScreenSlideActivity) getActivity();
        arr_ques = screenSlideActivity.getData();
        PageNumber = getArguments().getInt(Key);
        check = getArguments().getInt(ARG_CHECK);
        //lấy dữ liệu trong Fragment


    }

    @Override
    public void onStart() {
        super.onStart();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, //creat and return view
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false); //
        tvNum = (TextView) view.findViewById(R.id.tvNum);
        tvQuestion = (TextView) view.findViewById(R.id.tvQuestion);
        radA = (RadioButton) view.findViewById(R.id.radA);
        radB = (RadioButton) view.findViewById(R.id.radB);
        radC = (RadioButton) view.findViewById(R.id.radC);
        radD = (RadioButton) view.findViewById(R.id.radD);
        radGroup = (RadioGroup) view.findViewById(R.id.radGroup);
        imgclock = (ImageView) view.findViewById(R.id.imgclock);

        radGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                arr_ques.get(PageNumber).position = checkedId;


            }
        });


        tvNum.setText("Câu" + " " + (PageNumber + 1));

        if (PageNumber < 30 && arr_ques.size() > 0) {


            tvQuestion.setText(arr_ques.get(PageNumber).getQuestion());
            radA.setText(arr_ques.get(PageNumber).getAns_a());
            radB.setText(arr_ques.get(PageNumber).getAns_b());
            radC.setText(arr_ques.get(PageNumber).getAns_c());
            radD.setText(arr_ques.get(PageNumber).getAns_d());
        }


        return view;


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    public static ScreenSlidePageFragment create(int pageNumber, int check) {
        ScreenSlidePageFragment screenSlidePageFragment = new ScreenSlidePageFragment();
        Bundle bundlesend = new Bundle(); //gửi dữ liệu đi
        bundlesend.putInt(Key, pageNumber);
        ;
        screenSlidePageFragment.setArguments(bundlesend);
        return screenSlidePageFragment;


    }

    private String getRadian(int id) {
        if (id == R.id.radA) {
            return "A";
        } else if (id == R.id.radB) {
            return "B";
        } else if (id == R.id.radC) {
            return "C";
        } else if (id == R.id.radD) {
            return "D";
        } else return "";


    }

    private String getcheck(int id) {
        if (arr_ques.equals("A") == true) {
            radA.setBackgroundColor(Color.GREEN);
        } else if (arr_ques.equals("B") == true) {
            radB.setBackgroundColor(Color.GREEN);
        } else if (arr_ques.equals("C") == true) {
            radC.setBackgroundColor(Color.GREEN);
            ;
        } else if (arr_ques.equals("D") == true) {
            radD.setBackgroundColor(Color.GREEN);
        }
        return " ";


    }


}

