package brandao.android.mvvm_koltin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import brandao.android.mvvm_koltin.databinding.ActivityMainBinding

    private lateinit var binding: ActivityMainBinding
    private lateinit var  viewModel: MainViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener(this)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setObserver()

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_login){
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            viewModel.doLogin(email, password)
        }
    }

    private fun setObserver(){
        viewModel.welcome().observe(this, Observer{
            binding.textWelcome.text = it
        })

        viewModel.login().observe(this, Observer{
            if (it) {
                Toast.makeText(applicationContext, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Falha ao realizar login!", Toast.LENGTH_SHORT).show()
            }
        })

    }


}