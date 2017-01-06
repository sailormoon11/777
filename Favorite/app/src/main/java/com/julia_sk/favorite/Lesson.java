package com.julia_sk.favorite;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Юлия on 25.11.2016.
 */

public class Lesson {

    private String title;
    private String text;
    private boolean favorite;
    private Integer id;


    public Lesson(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public void  setId(Integer id) { this.id = id;}

    public Integer  getId() { return id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) { this.favorite = favorite; }







}