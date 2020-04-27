package com.example.graduationprojectkotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class UserInfoActivity : AppCompatActivity() {

    companion object{
        fun actionStart(context: Context,userId :Int) {
            val intent = Intent(context, UserInfoActivity::class.java)
            intent.putExtra("userId", userId)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
    }


}
