package brandao.android.gastoviagem2_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import brandao.android.gastoviagem2_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ButtonCalcular.setOnClickListener(this)

    }
    override fun onClick(view: View) {
        if(view.id == R.id.Button_Calcular){
            calculate()
        }
    }
    private fun validate(): Boolean{
        return (binding.EditTextDist.text.toString() != ""
                && binding.EditTextPreco.text.toString() != ""
                && binding.EditTextAuto.text.toString() != ""
                && binding.EditTextAuto.text.toString().toFloat() != 0f)
    }

    private fun calculate(){

        if(validate()){
            val distance = binding.EditTextDist.text.toString().toFloat()
            val preco = binding.EditTextPreco.text.toString().toFloat()
            val auto = binding.EditTextAuto.text.toString().toFloat()
            val totalValue = (distance*preco)/auto

            //limita o numero a duas casas decimais
            val totalValueStr = "R$ ${"%.2f".format(totalValue)}"


            binding.TextGasto.text = totalValueStr

        }else{
            Toast.makeText(this, R.string.preencha ,Toast.LENGTH_LONG).show()
        }




        //

    }

}