package com.example.formapp.main_module

import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainViewModel: AppCompatActivity() {
    fun selectDateOfBirth(fragmentManager: FragmentManager,editSelectDate: EditText){
        val date = DatePickerFragment { year, month, day ->
            editSelectDate.setText("$year/${month+1}/$day")
        }
        date.show(fragmentManager, "date")
    }

}