package com.julia_sk.favorite;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Test on 08.12.2016.
 */

public class DB {
    public ArrayList<Lesson> lessonsList;
    public ArrayList<Lesson> lessonsList2;
    public ArrayList<Lesson> allResipes;
    //public static Vector<Integer> favoriteList;
    public static ArrayList<Lesson> favoriteList;
    public static String[] favoriteString;


    public DB() {
        lessonsList = new ArrayList<Lesson>();
        lessonsList2 = new ArrayList<Lesson>();
        allResipes = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            lessonsList.add(new Lesson("Рецепт " + i, "Текст рецепта про мясо ..." ));
            lessonsList.get(i-1).setId(i);
        }
        for (int i = 1; i < 11; i++) {
            lessonsList2.add(new Lesson("Рецепт " + (i+11), "Текст рецепта пор морепродукты ... " ));
            lessonsList2.get(i-1).setId(i+11);
        }
        allResipes.addAll(lessonsList);
        allResipes.addAll(lessonsList2);
    }

//    public static void save(int position) {
//        if (favoriteList == null) {
//            favoriteList = new Vector<Integer>();
//        }
//
//        if (!favoriteList.contains(position))
//            favoriteList.add(position); }
//
//    public static void delete(int position) { favoriteList.remove((Object)position); }
//
//    public static String getFavoritrList() { return favoriteList.toString(); }
//
//    public ArrayList<Lesson> createFavoriteList() {
//        favorite = new ArrayList<Lesson>();
//        for (int i = 0; i < favoriteList.size(); i++) {
//            for (int j =0; j<lessonsList.size(); j++) {
//                if (lessonsList.get(j).getId()==favorite.get(i))
//            }
//            if (favoriteList.get(i)<11)
//                favorite.add(lessonsList.get(favoriteList.get(i)));
//            else
//                favorite.add(lessonsList2.get(favoriteList.get(i)));
//        }
//        return favorite;
//    }

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
        favoriteString = new String[favoriteList.size()];
        for (int i =0; i<favoriteList.size();i++)
            favoriteString[i] = favoriteList.get(i).getTitle();
         }


}
