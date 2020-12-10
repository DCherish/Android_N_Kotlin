package org.techtown.ap15;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        ItemAdapter adapter = new ItemAdapter();

        adapter.addItem(new Item("롱코트", "160,000원", "명절 기획상품 폭.탄. 세일"));
        adapter.addItem(new Item("빈탄 와이셔츠", "80,000원", "특가상품 반.짝. 세일"));
        adapter.addItem(new Item("조깅화", "220,000원", "Limited Edition 단.독. 입수"));
        adapter.addItem(new Item("Gucci 썬글라스", "1,200,000원", "100% 정.품. 보장"));
        adapter.addItem(new Item("NewEra NY 모자", "38,000원", "유니크 한.정. 수량"));
        adapter.addItem(new Item("Louis Vuitton 팔찌", "1,800,000원", "100% 정.품. 보장"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemItemClickListener() {
            @Override
            public void onItemClick(ItemAdapter.ViewHolder holder, View view, int position) {
                Item item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "이름 : " + item.getName() + "\n가격 : " + item.getPrice(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}