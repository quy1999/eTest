package com.example.etest.question;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class QuestionControl extends Question {

    private DPHelper dpHelper;


    public QuestionControl(Context context) {
        dpHelper = new DPHelper(context);
    }

    public ArrayList<Question> getQuestion(int num_exam, String subject) {

        ArrayList<Question> data = new ArrayList<Question>();
        SQLiteDatabase dp = dpHelper.getReadableDatabase();
        Cursor cursor = dp.rawQuery("SELECT * FROM tracnghiem ", null); //đọc dữ liệu
        cursor.moveToFirst();
        do {
            Question item;
            item = new Question(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9) );
            data.add(item);

        } while (cursor.moveToNext());
        return data; //trả về mảng danh sách câu hỏi
    }


}
