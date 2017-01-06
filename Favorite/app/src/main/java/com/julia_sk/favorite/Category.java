package com.julia_sk.favorite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Category extends Activity implements View.OnClickListener{
//    public static ArrayList<Lesson> lessonsList;
//    public static ArrayList<Lesson> lessonsList2;
    DB db = new DB();
    Button category1;
    Button category2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        category1 = (Button) findViewById(R.id.category1);
        category2 = (Button) findViewById(R.id.category2);
        category1.setOnClickListener(this);
        category2.setOnClickListener(this);
//        db.lessonsList = new ArrayList<Lesson>();
//        db.lessonsList2 = new ArrayList<Lesson>();

//        for (int i = 1; i < 11; i++) {
//            lessonsList.add(new Lesson("Урок " + i, "Текст урока номер " + i+ ". В этом уроке мы научимся ..."));
//        }
//        for (int i = 1; i < 11; i++) {
//            lessonsList2.add(new Lesson("Рецепт " + i, "Текст урока номер " + i+ ". В этом уроке мы научимся ..."));
//        }

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.category1:
                Main2Activity.setLessonsList(db.lessonsList);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.category2:
                Main2Activity.setLessonsList(db.lessonsList2);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;

        }
    }
}
