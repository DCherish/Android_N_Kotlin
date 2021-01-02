package org.techtown.ap21;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class QueryFragment extends Fragment {

    ArrayList<Book> bookArrayList;
    OnDatabaseCallback callback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        callback = (OnDatabaseCallback) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_query, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        BookAdapter adapter = new BookAdapter();
        recyclerView.setAdapter(adapter);

        bookArrayList = callback.accessAll();
        adapter.setItems(bookArrayList);

        adapter.notifyDataSetChanged();

        return rootView;
    }
}