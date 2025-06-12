package android.matheus

import android.graphics.Color
import android.matheus.databinding.ActivityMainBinding
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    companion object{
        const val NOME_ARQUIVO = "arquivo.prefs.xml"
    }

    private var cor = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.cor1.setOnClickListener(){
            cor = "#FF0000"
            salvarCor(cor)

        }

        binding.cor2.setOnClickListener(){
            cor = "#0040FF"
            salvarCor(cor)

        }

        binding.cor3.setOnClickListener(){
            cor = "#00FF26"
            salvarCor(cor)

        }

        binding.cor4.setOnClickListener(){
            cor = "#C300FF"
            salvarCor(cor)

        }

        binding.cor5.setOnClickListener(){
            cor = "#FFC300"
            salvarCor(cor)

        }

    }

    private fun salvarCor(cor: String){
        binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))

        binding.btnTrocar.setOnClickListener{
            val preferencias = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
            val editor = preferencias.edit()
            editor.putString("cor", cor)
            editor.putString("nome", "Matheus")
            editor.putString("sobrenome", "Teixeira")
            editor.putInt("idade", 17)
            editor.apply()


        }

    }


}