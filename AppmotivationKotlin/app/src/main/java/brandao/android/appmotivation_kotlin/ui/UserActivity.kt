package brandao.android.appmotivation_kotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import brandao.android.appmotivation_kotlin.R
import brandao.android.appmotivation_kotlin.infra.SecurityPreferences
import brandao.android.appmotivation_kotlin.constants.MotivationConstants
import brandao.android.appmotivation_kotlin.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


        binding.buttonSave.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        if (v.id == R.id.button_save){
            handleSave()
        }

    }

    private fun handleSave(){

        val name = binding.editName.text.toString()

        if(name != "" && name != null){
            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)
            finish()
        }else{
            Toast.makeText(
                this,
                R.string.validation_mandatory_name,
                Toast.LENGTH_SHORT).show()
        }
    }

   /* private fun verifyUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        if (name != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }*/
}