package com.ucsdextandroid2.android2final;


import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import okhttp3.internal.Util;

public class ListViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView titleView;
    private Meal currentMealItem;
    private OnItemClickListener<Meal> clickListener;

    public static ListViewHolder inflate(@NonNull ViewGroup parent){
        return new ListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder, parent, false));
    }

    private ListViewHolder(@NonNull View itemView ){
        super (itemView);

        imageView = itemView.findViewById(R.id.vsi_image);
        titleView = itemView.findViewById((R.id.vsi_title));

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickListener != null && currentMealItem != null)
                    clickListener.onItemClicked(currentMealItem);
            }
        });
    }
    public void bind (Meal meal){
        this.currentMealItem = meal;

        Picasso.get().load(currentMealItem.getPhoto()).into(imageView);
        titleView.setText(currentMealItem.getMealName());

    }
    public void setClickListener(OnItemClickListener<Meal>clickListener){
        this.clickListener = clickListener;
    }
}
