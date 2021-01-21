package cdio4.cots.foodoffer.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<String>> listFood = new MutableLiveData<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }
}
