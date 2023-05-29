package brandao.android.convidados_kotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import brandao.android.convidados_kotlin.model.GuestModel
import brandao.android.convidados_kotlin.repository.GuestRepository

class GuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository =
        GuestRepository.getInstance(application.applicationContext)

    private val listAllGuests = MutableLiveData<List<GuestModel>>()
    val guests: LiveData<List<GuestModel>> = listAllGuests

    fun getAll(){
        listAllGuests.value = repository.getAll()
    }

    fun getAbsent(){
        listAllGuests.value = repository.getAbsent()

    }

    fun getPresent(){
        listAllGuests.value = repository.getPresent()

    }


    fun delete(id: Int){
        repository.delete(id)
    }
}