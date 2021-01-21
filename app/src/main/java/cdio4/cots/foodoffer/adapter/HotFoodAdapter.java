package cdio4.cots.foodoffer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.model.Food;

public class HotFoodAdapter extends RecyclerView.Adapter<HotFoodAdapter.HotFoodViewHolder> {
    //Lớp HotFoodViewHolder ta làm bên trong lớp này dùng để tham chiếu giao diện cho từng item trong list
    private List<Food> mListFood;
    public HotFoodAdapter(List<Food> mListFood){
        this.mListFood=mListFood;
    }
    @NonNull
    @Override
    public HotFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hot_food_item,parent,false);
        return new HotFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotFoodViewHolder holder, int position) {
        Food food = mListFood.get(position);
        if(food==null){
            return;
        }
        holder.imgFood.setImageResource(food.getImage());
        holder.tvNameFood.setText(food.getName());
        holder.tvPrice.setText(food.getPrice()+"");
    }

    @Override
    public int getItemCount() {
        if(mListFood!=null){
            return mListFood.size();
        }
        return 0;
    }

    public class HotFoodViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFood;
        private TextView tvNameFood;
        private TextView tvPrice;
        public HotFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood=itemView.findViewById(R.id.img_food);
            tvNameFood=itemView.findViewById(R.id.tv_name_food);
            tvPrice=itemView.findViewById(R.id.tv_price);

        }
    }

}
