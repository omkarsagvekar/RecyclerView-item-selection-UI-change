package com.os.recyclerviewclickselectedui;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.os.recyclerviewclickselectedui.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemAdapter.OnItemClickListener{

    ActivityMainBinding binding;
    ArrayList<String> fruitList;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);

        binding.rvFruitList.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));
        fruitList = new ArrayList<>();
        fruitList.add("Apple");
        fruitList.add("Banana");
        fruitList.add("Orange");
        fruitList.add("Mango");
        fruitList.add("Grapes");
        fruitList.add("Strawberry");
        fruitList.add("Pineapple");
        fruitList.add("Watermelon");
        fruitList.add("Papaya");
        fruitList.add("Pear");
        fruitList.add("Apple");
        fruitList.add("Banana");
        fruitList.add("Orange");
        fruitList.add("Mango");
        fruitList.add("Grapes");
        fruitList.add("Strawberry");
        fruitList.add("Pineapple");
        fruitList.add("Watermelon");
        fruitList.add("Papaya");
        fruitList.add("Pear");

        ItemAdapter itemAdapter = new ItemAdapter( fruitList, this);
        itemAdapter.addOnItemClickListener(this::onItemClick);
        binding.rvFruitList.setAdapter(itemAdapter);

    }

    @Override
    public void onItemClick(String fruit) {
        binding.tvFruit.setText(fruit);
    }
}