package org.techtown.ap14;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    ArrayList<Person> items = new ArrayList<Person>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.itemlayout, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        TextView textView2;
        TextView textView3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
        }

        public void setItem(Person item)
        {
            textView.setText(item.getIndex());
            textView2.setText(item.getName());
            textView3.setText(item.getMobile());
        }
    }

    public void setItems(ArrayList<Person> items)
    {
        this.items = items;
    }

    public void addItem(Person item)
    {
        items.add(item);
    }

    public Person getItem(int position)
    {
        return items.get(position);
    }

    public void setItem(int position, Person item)
    {
        items.set(position, item);
    }
}
