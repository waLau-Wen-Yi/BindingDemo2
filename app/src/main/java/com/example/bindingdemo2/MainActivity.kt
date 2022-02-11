package com.example.bindingdemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.bindingdemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //create this for data binding
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val student = Student("2005659", "waLau")

        //bind this activity to the kt file
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //pass the kt class into xml
        binding.myData = student

        //start bind the xml to the data
        //binding.tvStudID.text = student.id
        //binding.tvStudName.text = student.name
        binding.btnUpd.setOnClickListener {
            student.name = "PotatoLau"
            binding.apply {
                invalidateAll()
            }
        }

        //Find id
        //val studentId :TextView = findViewById(R.id.tv_studID)
        //studentId.text = student.id


    }
}