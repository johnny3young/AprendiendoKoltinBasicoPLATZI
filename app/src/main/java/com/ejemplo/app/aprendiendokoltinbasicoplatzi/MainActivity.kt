package com.ejemplo.app.aprendiendokoltinbasicoplatzi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    data class Cursos (val nombre: String, val url: String)

    private val react = Cursos("React", "/react")
    private val kot = Cursos("KotlinBasico", "/kotlin")
    var cursoActual = react.copy()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.btnLogin)
        boton.setOnClickListener {
            switchCurso(cursoActual)
        }
        boton.text = todosLosCursos()

    }


    fun switchCurso(curso:Cursos){
         cursoActual = curso.copy()
        when(curso.url){
            "kotlin" -> cursoActual = react.copy()
            "react" -> cursoActual = kot.copy()
            //Imprime en el depurador entonces no será visisble. Esto nunca va a pasar porque o es el uno o es el otro
            else -> print("")
        }

        verEnPantalla("Curso de ${cursoActual.nombre} en platzi.com/${cursoActual.url}")
    }


    fun verEnPantalla (s:String){
        val txt = findViewById<TextView>(R.id.txtView)
        txt.text = s
    }

    fun todosLosCursos(): String = "${react.nombre} y ${kot.nombre}"
}
