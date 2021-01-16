package cdio4.cots.foodoffer.ui.home.Fragment.SaleCode;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cdio4.cots.foodoffer.R;

public class SaleCodeFragment extends Fragment {

    private SaleCodeViewModel mViewModel;

    public static SaleCodeFragment newInstance() {
        return new SaleCodeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sale_code_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SaleCodeViewModel.class);
        // TODO: Use the ViewModel
    }

}