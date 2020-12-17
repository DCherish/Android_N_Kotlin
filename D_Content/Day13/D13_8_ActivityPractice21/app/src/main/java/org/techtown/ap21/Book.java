package org.techtown.ap21;

public class Book {
    String title;
    String writer;
    String context;

    public Book(String title, String writer, String context) {
        this.title = title;
        this.writer = writer;
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
