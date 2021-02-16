package com.example.actividad1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var tiros = 0
    var player = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //test_Kotlin()
        tira_Dado()
    }
    fun tira_Dado() {
        var p1Points = 0
        var p2Points = 0
        roll_dice.setOnClickListener {
            val rand = Random.nextInt(1, 6)
            when (player) {
                0 -> player = 1
                1 -> player = 2
                else -> {
                    player = 1
                }
            }
            if (tiros == 6) {
                if (p1Points > p2Points) { mensaje.text = "Se acabo el juego, jugador 1 gana con $p1Points" }
                else if (p1Points < p2Points) { mensaje.text = "Se acabo el juego, jugador 2 gana con $p2Points" }
                else { mensaje.text = "Se acabo el juego, ambos jugadores empatan con $p2Points" }
                tiros = 0
                player = 0
                p1Points = 0
                p2Points = 0
            } else {
                if (player == 1) { p1Points += rand } else if (player == 2) { p2Points += rand }
                else { "error" }
                mensaje.text = "Tiro #${tiros++} jugador $player : $rand"
            }
        }
    }

    fun test_Kotlin(){
        val edad = 45
        val peso : Double = 67.7
        val altura: Float = 1.58F

        print(imc(peso,altura))
    }
    fun imc(peso:Double, altura : Float) : String{
        val imc_cal = peso / altura * altura
        val imc_str = if(imc_cal > 18.5 && imc_cal < 25){
            "$imc_cal normal"
        }else if(imc_cal > 25 && imc_cal < 30){
            "$imc_cal sobrepeso"
        }else{
            "$imc_cal obesidad"
        }
        return imc_str
    }

}