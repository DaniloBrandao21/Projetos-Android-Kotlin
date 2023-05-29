package brandao.android.convidados_kotlin.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import brandao.android.convidados_kotlin.databinding.RowGuestBinding
import brandao.android.convidados_kotlin.model.GuestModel
import brandao.android.convidados_kotlin.view.listener.OnGuestListener
import brandao.android.convidados_kotlin.view.viewholder.GuestViewHolder

class GuestAdapter: RecyclerView.Adapter<GuestViewHolder>() {

    private var guestList: List<GuestModel> = listOf()
    private lateinit var listener: OnGuestListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {

        val item = RowGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return GuestViewHolder(item, listener)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {

        holder.bind(guestList[position])
    }

    override fun getItemCount(): Int {
        return guestList.count()
    }

    fun updatedGuests(list: List<GuestModel>){
        guestList = list

        //Avisa para a RecycleView que recebeu novas informações
        notifyDataSetChanged()

    }

    fun attachListener(guestListener: OnGuestListener){
        listener = guestListener
    }
}