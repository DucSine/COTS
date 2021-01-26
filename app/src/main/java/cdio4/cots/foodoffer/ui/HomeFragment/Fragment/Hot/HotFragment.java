package cdio4.cots.foodoffer.ui.HomeFragment.Fragment.Hot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cdio4.cots.foodoffer.MainActivity;
import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.adapter.HotFoodAdapter;
import cdio4.cots.foodoffer.model.Food;

public class HotFragment extends Fragment {

    //private HotViewModel mViewModel;
    private RecyclerView rcvFood;
    MainActivity mainActivity; //khai báo MainActivity
    private View mView;

    public static HotFragment newInstance() {
        return new HotFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.hot_fragment, container, false);
        init();
        return mView;
    }

    private void init() {
        mainActivity=(MainActivity) getActivity(); //getActivity trả về Activity chứa Fragment đang gọi, không cần thông qua home, ép kiểu về MainActivity. Cái này có thể dùng để gởi dữ liệu từ Fragment về Activity mà không cần xài interface
        rcvFood= mView.findViewById(R.id.rcv_fragment_hot_food);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(mainActivity,2);//định dạng layout cho RecycleView là Grid, 2 cột
        rcvFood.setLayoutManager(gridLayoutManager);
        HotFoodAdapter adapter = new HotFoodAdapter(getListFood());
        rcvFood.setAdapter(adapter);
    }
    private List<Food> getListFood() {
        List<Food> list = new ArrayList<>();
        for (int i=0;i<=9;i++){
            list.add(new Food(R.drawable.ic_cafe,"Cafe",10000));
        }
        for (int i=0;i<=9;i++){
            list.add(new Food(R.drawable.ic_trasua,"Trà sữa",20000));
        }
        for (int i=0;i<=9;i++){
            list.add(new Food(R.drawable.ic_suachua,"Sữa chua",30000));
        }
        return list;
    }

   /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HotViewModel.class);
        // TODO: Use the ViewModel
    }*/

}