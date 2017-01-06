package com.julia_sk.favorite;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FavoriteActivityItem extends Activity {

    private Lesson lesson;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_item);
        if (getIntent() != null) {
            position = getIntent().getIntExtra("position", -1);
        }
        TextView textView = (TextView) findViewById(R.id.favoriteView);
        if (!DB.favoriteList.isEmpty()) {
            lesson = DB.favoriteList.get(position);
            textView.setText(lesson.getText());
        }
        else {
            textView.setText("Список пуст");
        }
    }
}



