package org.techtown.ap21;

import java.util.ArrayList;

public interface OnDatabaseCallback {
    public void insert(String title, String writer, String context);
    public ArrayList<Book> accessAll();
}
