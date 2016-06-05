package com.julia_sk.favorite;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Test on 08.12.2016.
 */

public class DB {
    public static ArrayList<Lesson> lessonsList; //мясо
    public static ArrayList<Lesson> lessonsList2; //рыбв и морепродукты
    public static ArrayList<Lesson> allResipes;
    public static ArrayList<Lesson> searchList;
    public static ArrayList<Lesson> milk;
    public static ArrayList<Lesson> Macarons;
    public static ArrayList<Lesson> Semimanufactures;
    public static ArrayList<Lesson> Fruits;
    public static ArrayList<Lesson> Other;
    public static ArrayList<Lesson> favoriteList;
    public static String[] favoriteString;
    public DB() {
    }

public static void setList(Cursor cursor, ArrayList<Lesson> list)
{
    if (cursor.moveToFirst()) {
        int idIndex = cursor.getColumnIndex(DB1.KEY_ID);
        int nameIndex = cursor.getColumnIndex(DB1.KEY_TITLE);
        int textIndex = cursor.getColumnIndex(DB1.KEY_RECIPETEXT);
        int complexityIndex = cursor.getColumnIndex(DB1.KEY_COMPLEXITY);
        int timeIndex = cursor.getColumnIndex(DB1.KEY_COOKINGTIMEMIN);
        int productsIndex = cursor.getColumnIndex(DB1.KEY_PRODUCTS);
        do {
            list.add(new Lesson("Рецепт " + cursor.getInt(idIndex) + " " + cursor.getString(nameIndex) ,
                    "\nПродукты: " + cursor.getString(productsIndex)
                    + "\n" + cursor.getString(complexityIndex)
                    + "\nВремя: " + cursor.getString(timeIndex) + "\n" + cursor.getString(textIndex)));
            list.get(cursor.getPosition()).setId(cursor.getInt(idIndex));
            Log.d("mLog", "ID = " + cursor.getPosition());
        } while (cursor.moveToNext());
    }
}
    public static void save(Lesson lesson) {
        Boolean contain = false;
        if (favoriteList == null) {
            favoriteList = new ArrayList<Lesson>();
        }
        for (int i=0;i<favoriteList.size();i++) {
            if (favoriteList.get(i).getId()==lesson.getId()) {
                contain = true;
                break;
            }
        }
        if (!contain)
            favoriteList.add(lesson);
    }

    public static void delete(Lesson lesson) { favoriteList.remove(lesson); }

    public static String getFavoritrList() {
        String s="";
        for (int i =0; i<favoriteList.size();i++)
            s+=(favoriteList.get(i).getId().toString() + " ");
        return s; }

    public static void setFavoritrList2() {
        if (favoriteList==null) {
            favoriteString = new String[1];
            favoriteString[0] = "Список пуст";
        }
        else {
            favoriteString = new String[favoriteList.size()];
            for (int i =0; i<favoriteList.size();i++)
                favoriteString[i] = favoriteList.get(i).getTitle();
            }
        }




}
