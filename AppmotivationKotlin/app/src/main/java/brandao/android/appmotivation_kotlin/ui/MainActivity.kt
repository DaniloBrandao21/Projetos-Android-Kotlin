package brandao.android.appmotivation_kotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import brandao.android.appmotivation_kotlin.R
import brandao.android.appmotivation_kotlin.infra.SecurityPreferences
import brandao.android.appmotivation_kotlin.constants.MotivationConstants
import brandao.android.appmotivation_kotlin.data.Mock
import brandao.android.appmotivation_kotlin.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        handleUserName()
        handleFilter(R.id.imageView_all_inclusive)
        handleNextPhrase()


        //eventos

        binding.buttonNew.setOnClickListener(this)
        binding.imageViewAllInclusive.setOnClickListener(this)
        binding.imageViewHappy.setOnClickListener(this)
        binding.imageViewSunny.setOnClickListener(this)
        binding.buttonNew.setOnClickListener(this)
        binding.textHello.setOnClickListener(this)


    }


    override fun onResume() {
        super.onResume()
        handleUserName()}

    override fun onClick(view: View) {
    if (view.id == R.id.button_new){

        handleNextPhrase()

    }
        if (view.id in listOf(R.id.imageView_all_inclusive, R.id.imageView_happy, R.id.imageView_sunny))
        {
            handleFilter(view.id)
        }
        if (view.id == R.id.text_hello){
            startActivity(Intent(this, UserActivity::class.java))
        }
    }

    fun handleNextPhrase(){
        val phrase = Mock().getPhrase(categoryId, Locale.getDefault().language)
        binding.textText.text = phrase.description
    }

    fun handleUserName(){
       val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
       binding.textHello.text = "Olá, $name!"
   }

    fun handleFilter(id: Int){

        binding.imageViewAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imageViewHappy.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imageViewSunny.setColorFilter(ContextCompat.getColor(this, R.color.black))

        when (id ){
            R.id.imageView_all_inclusive ->{
                binding.imageViewAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }

            R.id.imageView_happy ->{
                binding.imageViewHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.HAPPY
            }

            R.id.imageView_sunny -> {
                binding.imageViewSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
        }
    }
}