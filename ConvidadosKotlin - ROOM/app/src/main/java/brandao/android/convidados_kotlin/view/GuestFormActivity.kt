package brandao.android.convidados_kotlin.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import brandao.android.convidados_kotlin.R
import brandao.android.convidados_kotlin.constants.DataBaseConstants
import brandao.android.convidados_kotlin.databinding.ActivityGuestFormBinding
import brandao.android.convidados_kotlin.model.GuestModel
import brandao.android.convidados_kotlin.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel

    private var guestId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        binding.buttonSave.setOnClickListener(this)
        binding.radioPresent.isChecked = true

        setListeners()
        observe()
        loadData()

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {

            val     name = binding.editName.text.toString()
            val presence = binding.radioPresent.isChecked


            val model = GuestModel().apply {
                this.id = guestId
                this.name = name
                this.presence = presence
            }

            viewModel.save(guestId,name,presence)


        }
    }

    private fun loadData() {
        val bundle = intent.extras

        if (bundle != null) {
            val guestId = bundle.getInt(DataBaseConstants.GUEST.ID)
            viewModel.get(guestId)
        }
    }

    private fun observe() {

        viewModel.guests.observe(this, Observer {
            binding.editName.setText(it.name)

            if (it.presence) {
                binding.radioPresent.isChecked = true
            } else {
                binding.radioAbsent.isChecked = true
            }
        })

        viewModel.saveGuest.observe(this, Observer {

            if (it != "") {
                Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT)
                    .show()
                finish()
            }
        })


    }


    private fun setListeners() {
        binding.buttonSave.setOnClickListener(this)
    }
}