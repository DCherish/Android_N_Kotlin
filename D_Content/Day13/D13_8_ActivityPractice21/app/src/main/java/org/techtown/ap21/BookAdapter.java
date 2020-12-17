package org.techtown.ap21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    ArrayList<Book> items = new ArrayList<Book>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.book_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;

        TextView textView;
        TextView textView2;
        TextView textView3;

        public ViewHolder(View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
        }

        public void setItem(Book item)
        {
            imageView.setImageResource(R.drawable.book);

            textView.setText(item.getTitle());
            textView2.setText(item.getWriter());

            String str = item.getContext();

            if (str.length() > 20) {
                str = str.substring(0, 20);
            }

            str = "\" " + str + "... \"";

            textView3.setText(str);
        }
    }

    public void addItem(Book item)
    {
        items.add(item);
    }

    public void setItems(ArrayList<Book> items)
    {
        this.items = items;
    }

    public Book getItem(int position)
    {
        return items.get(position);
    }

    public void setItem(int position, Book item)
    {
        items.set(position, item);
    }
}
