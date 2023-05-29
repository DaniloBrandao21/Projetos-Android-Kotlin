package brandao.android.convidados_kotlin.view.viewholder

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import brandao.android.convidados_kotlin.databinding.RowGuestBinding
import brandao.android.convidados_kotlin.model.GuestModel
import brandao.android.convidados_kotlin.view.listener.OnGuestListener


class GuestViewHolder(private val bind: RowGuestBinding, private val listener: OnGuestListener) :
    RecyclerView.ViewHolder(bind.root) {


    fun bind(guest: GuestModel) {
        bind.textName.text = guest.name

        bind.textName.setOnClickListener {

            listener.onClick(guest.id)

        }

        bind.textName.setOnLongClickListener(View.OnLongClickListener {

            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção de convidado")
                .setMessage("Tem certeza que deseja excluir esse convidado?")
                .setPositiveButton("Sim"
                ) { dialog, which -> listener.onDelete(guest.id) }
                .setNegativeButton("Não", null )
                .create()
                .show()


            true
        })




    }
}