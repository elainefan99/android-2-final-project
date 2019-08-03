package com.ucsdextandroid2.android2final;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoritesFragment extends Fragment {
    private MealAdapter mealAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mealAdapter = new MealAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        
        return inflater.inflate(R.layout.meal_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.am_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(mealAdapter);

        mealAdapter.setOnItemClickListener(new OnItemClickListener<Meal>() {
            @Override
            public void onItemClicked(Meal item) {
                Toast.makeText(requireContext(), item.getMealName(), Toast.LENGTH_SHORT).show();
            }
        });

        AppDatabase.get(requireContext()).mealDao()
                .getAllMealsLiveData()
                .observe(this, new Observer<List<Meal>>() {
                    @Override
                    public void onChanged(List<Meal> meals) {
                          mealAdapter.submitList(meals);
                    }
                });
    }

}
