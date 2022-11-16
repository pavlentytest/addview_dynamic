package ru.samsung.itschool.mdev.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import ru.samsung.itschool.mdev.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var constraintLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        // Создание экземпляра ImageView и определение его свойств
        val i = ImageView(this).apply {
            setImageResource(R.drawable.ic_android_black_24dp)
            contentDescription = resources.getString(R.string.app_name)
            //устанавливаем границы ImageView
            adjustViewBounds = true
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        // Создаем ConstraintLayout, в который нужно добавить ImageView
        constraintLayout = ConstraintLayout(this).apply {
            // Добавляем ImageView в разметку.
            addView(i)
        }
        // Добавляем в существующую разметку ImageView
        bind.root.addView(constraintLayout)
       // setContentView(constraintLayout)
    }
}