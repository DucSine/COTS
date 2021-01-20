package cdio4.cots.foodoffer.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class AccountViewModel extends AndroidViewModel {

    private MutableLiveData<String> signIn_userName = new MutableLiveData<>();
    private MutableLiveData<String> signIn_password = new MutableLiveData<>();

    public MutableLiveData<String> getSignIn_userName() {
        return signIn_userName;
    }

    public void setSignIn_userName(String userName) {
        this.signIn_userName.setValue(userName);
    }

    public MutableLiveData<String> getSignIn_password() {
        return signIn_password;
    }

    public void setSignIn_password(String password) {
        this.signIn_password.setValue(password);
    }

    /* private MutableLiveData<Integer> statusFragmentAccount = new MutableLiveData<>();

        public void setStatus(Integer status){
            statusFragmentAccount.setValue(status);
        }

        public LiveData<Integer> getStatus() {
            return statusFragmentAccount;
        }
    */
    public AccountViewModel(@NonNull Application application) {
        super(application);
    }
}
