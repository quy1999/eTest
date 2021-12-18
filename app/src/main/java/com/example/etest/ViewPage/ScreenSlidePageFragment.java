package com.example.etest.ViewPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int PageNumber;
    TextView tvNum,tvQuestion;
    RadioButton radA,radB,radC,radD;
    RadioGroup radGroup;
    ArrayList<Question> arr_Que;
    View view;



    public static String Key="english";

    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScreenSlidePageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScreenSlidePageFragment newInstance(String param1, String param2) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        arr_Que=new ArrayList<Question>();
        ScreenSlideActivity screenSlideActivity= (ScreenSlideActivity) getActivity();
        arr_Que=screenSlideActivity.getData();
        PageNumber=getArguments().getInt(Key);    //lấy về

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false); //
        tvNum=(TextView)view.findViewById(R.id.tvNum);
        tvQuestion=(TextView)view.findViewById(R.id.tvQuestion);
        radA=(RadioButton)view.findViewById(R.id.radA);
        radB=(RadioButton)view.findViewById(R.id.radB);
        radC=(RadioButton)view.findViewById(R.id.radC);
        radD=(RadioButton)view.findViewById(R.id.radD);
        radGroup=(RadioGroup)view.findViewById(R.id.radGroup);




        tvNum.setText("Câu" +(PageNumber+1));
        tvQuestion.setText(arr_Que.get(PageNumber).getQuestion());
        radA.setText(arr_Que.get(PageNumber).getAns_a());
        radB.setText(arr_Que.get(PageNumber).getAns_b());
        radC.setText(arr_Que.get(PageNumber).getAns_c());
        radD.setText(arr_Que.get(PageNumber).getAns_d());


       return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }
    public static ScreenSlidePageFragment create(int pageNumber){
        ScreenSlidePageFragment screenSlidePageFragment=new ScreenSlidePageFragment();
        Bundle bundle=new Bundle(); //gói dữ liệu gửi đi
        bundle.putInt(Key,pageNumber);
        screenSlidePageFragment.setArguments(bundle);
        return screenSlidePageFragment;

    }
}
