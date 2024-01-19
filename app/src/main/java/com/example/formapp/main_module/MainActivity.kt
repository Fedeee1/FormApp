package com.example.formapp.main_module

/*
haceis un formulario en el que se pide nombre, otro campo con apellido, otro campo que sera un selector de fecha
si es menor de edad, habra otro campo para introducir el nombre del colegio que se habilitara para poder poner el nombre del cole
y otro campo mas donde se ponen observaciones
ademas, cuando se escribe el nombre y se pulsa el enter del teclado, se asume que ha terminado y debera poner el cursor en el
siguiente campo.

Por supuesto si pulso sobre la pantalla se ha de ocultar el teclado
una vez que se termine de rellenar todos los campos, el de observaciones es opcional y el del colegio es obligatorio en el caso
de ser menor de edad,
pulsaremos un boton de finalizar que mostrara una alerta,
modal o algo (me da lo mismo el que). que indique que el formulkario se ha rellenado correctamente
ademas existira otro boton de reset, donde eliminara todos los campos del formulario
para esto, ademas haceis un repo de git localmente, que esto se me ha pasado contarlo como se crea
en ios al crear el proyecto te dice si quereis crearlo, decis que si y lo hace
en android imagino que tambien, si no, desde el terminal y en la carpeta donde creeis el proyecto haceis git init
 */

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.example.formapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editDateOfBirth.setOnClickListener{
            mainViewModel.selectDateOfBirth(supportFragmentManager ,binding.editDateOfBirth)
        }
        mainViewModel.currentEditText(binding.editDateOfBirth,binding.tfCollege)
        mainViewModel.currentEditText(binding.editDateOfBirth,binding.tfObservations)

        hideKeyboard()
    }
    private fun hideKeyboard() {
        var imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

}