package Dethi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.etest.NavigationActivity;
import com.example.etest.R;

import ViewPage.ScreenSlideActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExamOne extends Fragment {

    Button btnClick;


    public ExamOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((NavigationActivity) getActivity()).getSupportActionBar().setTitle("Đề 1");

        return inflater.inflate(R.layout.fragment_exam_one, container, false);





    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnClick=(Button)getActivity().findViewById(R.id.btnClick);


        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ScreenSlideActivity.class);
                startActivity(intent);
            }
        });
    }
}
