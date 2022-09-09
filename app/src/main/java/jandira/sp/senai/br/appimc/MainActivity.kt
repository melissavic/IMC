package jandira.sp.senai.br.appimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    //Criar as variáveis utilizadas no cálculo
    var weight = 0
    var height = 0.0
    var bmi = 0.0

    //Declarar as views da Activity
    lateinit var buttonCalculate: Button
    lateinit var editWeight: EditText
    lateinit var editHeight: EditText
    lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        //Instanciar as views
        buttonCalculate = findViewById(R.id.button_calculate)
        editWeight = findViewById(R.id.edit_weight)
        editHeight = findViewById(R.id.edit_height)
        textResult = findViewById(R.id.text_view_result)

        //Detectar o click no botão
        buttonCalculate.setOnClickListener {

            if (inputValidate()) {
                bmiCalculate()
            }

        }
    }

    private fun inputValidate(): Boolean {


        if (editWeight.text.isEmpty()) {
            editWeight.error = "Weight is required!"
            return false
        }

        if(editHeight.text.isEmpty()) {
            editHeight.error = "Height is required!"
            return false
        }
        return true
    }



    private fun bmiCalculate() {

        //Calcular o IMC
        //Recuperar os valores digitados
        weight = editWeight.text.toString().toInt()
        height = editHeight.text.toString().toDouble()

        //Calcular o IMC
        bmi = weight / height.pow(2)

        // textResult.text = bmi.toString()
        textResult.text = String.format("%.2f" , bmi)

    }

}