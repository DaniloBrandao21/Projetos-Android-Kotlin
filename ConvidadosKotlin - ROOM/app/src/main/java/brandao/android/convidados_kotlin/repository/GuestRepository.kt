package brandao.android.convidados_kotlin.repository

import android.content.Context
import brandao.android.convidados_kotlin.model.GuestModel

class GuestRepository (context: Context) {
    //Singleton -> Controlar o número de instância de uma classe

    private val guestDataBase = GuestDataBase.getDataBase(context).guestDAO()

    fun save(guest: GuestModel): Boolean {
        return guestDataBase.save(guest) > 0
    }

    fun update(guest: GuestModel): Boolean {

       return guestDataBase.update(guest) > 0

    }

    fun delete(id: Int) {
        val guest = get(id)
        guestDataBase.delete(guest)
    }

    fun get(id : Int): GuestModel {
        return guestDataBase.get(id)
    }

    fun getAll(): List<GuestModel> {

        return guestDataBase.getAll()

    }

    fun getPresent(): List<GuestModel> {

      return guestDataBase.getPresent()

    }

    fun getAbsent(): List<GuestModel> {
        return guestDataBase.getAbsent()
    }
}