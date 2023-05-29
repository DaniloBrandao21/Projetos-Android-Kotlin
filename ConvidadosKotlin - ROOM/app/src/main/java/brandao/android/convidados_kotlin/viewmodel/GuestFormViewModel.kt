package brandao.android.convidados_kotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import brandao.android.convidados_kotlin.model.GuestModel
import brandao.android.convidados_kotlin.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val guestRepository: GuestRepository = GuestRepository(application.applicationContext)
    private val guestModel = MutableLiveData<GuestModel>()
    val guests: LiveData<GuestModel> = guestModel

    private val _saveGuest = MutableLiveData<String>()
    val saveGuest: LiveData<String> = _saveGuest

    fun save(id: Int, name: String, presence: Boolean) {
        val guest = GuestModel().apply {
            this.id = id
            this.name = name
            this.presence = presence
        }

        if (id == 0) {
            _saveGuest.value = guestRepository.save(guest).toString()
        } else {
            _saveGuest.value = guestRepository.update(guest).toString()
        }
    }


    fun get(id: Int) {
        guestModel.value = guestRepository.get(id)
    }


}