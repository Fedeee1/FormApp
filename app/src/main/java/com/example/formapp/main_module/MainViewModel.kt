package com.example.formapp.main_module

import android.content.Context
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ListPopupWindow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.FragmentManager
import java.util.Calendar
import java.util.GregorianCalendar

class MainViewModel: AppCompatActivity() {
    fun selectDateOfBirth(fragmentManager: FragmentManager,editSelectDate: EditText){
        val date = DatePickerFragment { year, month, day ->
            editSelectDate.setText("$year/${month+1}/$day")
        }
        date.show(fragmentManager, "date")
    }

    fun isUnderAge(dateOfBirth: String) : Boolean{
        var arrayDate = dateOfBirth.split("/")
        val day = arrayDate[0].toInt()
        val month = arrayDate[1].toInt()
        val year = arrayDate[2].toInt()
        val birthDate = GregorianCalendar(year, month, day)
        val currentDate = Calendar.getInstance()

        var age = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR)
        birthDate.add(Calendar.YEAR, age)
        if (birthDate.before(currentDate)){
            age--
        }
        if (age < 18){
            return true
        }
        return false
    }

    fun currentEditText(editText: EditText, view: View){
        editText.doOnTextChanged { text, start, before, count ->
            showViews(view,  isUnderAge(text.toString()))
        }
    }
    fun showViews(view: View, show: Boolean) {
        if (show){
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

}