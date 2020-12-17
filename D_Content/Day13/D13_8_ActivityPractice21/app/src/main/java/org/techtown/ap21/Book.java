package org.techtown.ap21;

public class Book {
    int image;

    String title;
    String writer;
    String context;

    public Book(int image, String title, String writer, String context) {
        this.image = image;

        this.title = title;
        this.writer = writer;
        this.context = context;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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
