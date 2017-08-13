package org.passinhos.passinhos.Models;

import java.text.SimpleDateFormat;

public class Timeline {
    String title;
    SimpleDateFormat date;

    public Timeline(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }
}
