package com.julia_sk.favorite;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Юлия on 25.11.2016.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class LessonListAdapter extends BaseAdapter
{
    //public static Vector<Integer> favoriteList;
    private Context context;
    private ArrayList<Lesson> lessonsList;
    private LayoutInflater inflater;

    public LessonListAdapter(Context context, ArrayList<Lesson> lessonsList)
    {
        this.context = context;
        this.lessonsList = lessonsList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return lessonsList.size();
    }

    @Override
    public Lesson getItem(int position)
    {
        return lessonsList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent)
    {
        View view = null;
        ViewHolder viewHolder;

        if (v == null){
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.lesson_item, parent, false);
            viewHolder.tvLessonName = (TextView) view.findViewById(R.id.tvLessonItem);
            viewHolder.chbFaforiteLesson = (CheckBox) view.findViewById(R.id.chbFavoriteLesson);
            viewHolder.tvLessonName.setOnClickListener(onClick);
            viewHolder.chbFaforiteLesson.setOnClickListener(onClick);

            view.setTag(viewHolder);
        } else {
            view = v;
            viewHolder = (ViewHolder) view.getTag();
        }
        Lesson lesson = lessonsList.get(position);

        viewHolder.tvLessonName.setTag(position);
        viewHolder.chbFaforiteLesson.setTag(position);

        viewHolder.tvLessonName.setText(lesson.getTitle());
        viewHolder.chbFaforiteLesson.setChecked(lesson.isFavorite());

        return view;
    }

    static class ViewHolder {
        private TextView tvLessonName;
        private CheckBox chbFaforiteLesson;
    }

//    public void save(int position) {
//        if (favoriteList == null) {
//            favoriteList = new Vector<Integer>();
//        }
//
//        if (!favoriteList.contains(position))
//            this.favoriteList.add(position); }
//
//    public void delete(int position) { this.favoriteList.remove((Object)position); }
//
//    public String getFavoritrList() { return this.favoriteList.toString(); }

    OnClickListener onClick = new OnClickListener(){

        @Override
        public void onClick(View view){
            switch(view.getId()){
                case R.id.tvLessonItem:
                    Intent intent = new Intent(context, LessonActivity.class);
                    intent.putExtra("position", (Integer) view.getTag());
                    context.startActivity(intent);
                    break;

                case R.id.chbFavoriteLesson:
                    lessonsList.get((Integer) view.getTag()).setFavorite(((CheckBox) view).isChecked());
                    if (((CheckBox) view).isChecked()) {
                        DB.save(lessonsList.get((Integer) view.getTag()));
                    }
                    else {
                        DB.delete(lessonsList.get((Integer) view.getTag()));
                    }

                    Log.d("sd",DB.getFavoritrList());
                    break;
            }

        }

    };


}