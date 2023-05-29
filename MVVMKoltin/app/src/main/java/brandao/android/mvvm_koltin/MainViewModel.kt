package brandao.android.mvvm_koltin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var mTextWelcome = MutableLiveData<String>()
    private var mlogin = MutableLiveData<Boolean>()
    private val personRepository = PersonRepository()

    init {
        mTextWelcome.value = "Olá!"
    }

    fun welcome(): LiveData<String>{

        return mTextWelcome
    }

    fun login() :LiveData<Boolean>{

        return mlogin
    }

    fun doLogin(email: String, password: String){
       mlogin.value = personRepository.login(email, password)
    }


}