package com.julia_sk.favorite;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class MainActivity extends Activity implements View.OnClickListener {

    DB db = new DB();

    Button button;
    Button category;
    Button favorite;
    Button random;
    Button search;
    TextView version;

    DB1 db1 = new DB1(this);
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        search = (Button) findViewById((R.id.search));
        button = (Button) findViewById(R.id.button);
        category = (Button) findViewById(R.id.category);
        favorite = (Button) findViewById(R.id.favorite);
        random = (Button) findViewById(R.id.random);
        version = (TextView) findViewById(R.id.version) ;
        version.setText(Version.version);
        button.setOnClickListener(this);
        category.setOnClickListener(this);
        favorite.setOnClickListener(this);
        random.setOnClickListener(this);
        search.setOnClickListener(this);
        DB.lessonsList = new ArrayList<Lesson>();
        DB.lessonsList2 = new ArrayList<Lesson>();
        DB.allResipes = new ArrayList<Lesson>();
        DB.Macarons = new ArrayList<Lesson>();
        DB.Fruits = new ArrayList<Lesson>();
        DB.milk = new ArrayList<Lesson>();
        DB.Other = new ArrayList<Lesson>();
        DB.Semimanufactures = new ArrayList<Lesson>();
        db1.open();
      //

        //cursor = db1.getFilter(filter);
        cursor = db1.getAllData();
        DB.setList(cursor,DB.allResipes);
        cursor = db1.getORFilter(new String[]{"мясо"});
        DB.setList(cursor,DB.lessonsList);
        cursor = db1.getORFilter(new String[] {"рыба"});
        DB.setList(cursor,DB.lessonsList2);
        cursor = db1.getORFilter(new String[] {"капуста","картошкка", "помидор", "огурец"});
        DB.setList(cursor,DB.Fruits);
        cursor = db1.getORFilter(new String[] {"макароны"});
        DB.setList(cursor,DB.Macarons);
        cursor = db1.getORFilter(new String[] {"молоко","cыр", "сметана"});
        DB.setList(cursor,DB.milk);
        cursor = db1.getORFilter(new String[] {"яйцо","томатная паста"});
        DB.setList(cursor,DB.Other);
        cursor = db1.getORFilter(new String[] {"бичпакет"});
        DB.setList(cursor,DB.Semimanufactures);
        cursor.close();

    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button:

                Main2Activity.setLessonsList(db.allResipes);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.category:
                intent = new Intent(this,Category.class);
                startActivity(intent);
                break;
            case R.id.favorite:
                //Main2Activity.setLessonsList(db.favoriteList);
                intent = new Intent(this,FavoriteActivity.class);
                startActivity(intent);
                break;
            case R.id.random:
                ArrayList<Lesson> rand= new ArrayList<Lesson>();
                rand.add(db.allResipes.get(new Random().nextInt(db.allResipes.size())));
                Main2Activity.setLessonsList(rand);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.search:
                intent = new Intent(this,Activity_Products.class);
                startActivity(intent);
                break;


        }
    }

}

