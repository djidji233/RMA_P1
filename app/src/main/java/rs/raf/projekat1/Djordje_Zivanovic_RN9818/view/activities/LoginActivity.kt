package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_login.*
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R

class LoginActivity : AppCompatActivity() {

    private val PASSWORD = "1234"
    private val USER_DATA = "UserData"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener() {
            if (user_first_name.text.isBlank() || user_last_name.text.isBlank() || user_workplace.text.isBlank()){
                Toast.makeText(applicationContext,"Please fill in all the fields!",Toast.LENGTH_SHORT).show()
            } else if (!user_password.text.toString().equals(PASSWORD)){
                Toast.makeText(applicationContext,"Wrong password!",Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this,MainActivity::class.java)
                getSharedPreferences(USER_DATA, Context.MODE_PRIVATE).edit{
                    putString("user_first_name", user_first_name.text.toString())
                    putString("user_last_name", user_last_name.text.toString())
                    putString("user_workplace", user_workplace.text.toString())
                    apply()
                }
                startActivity(intent)
                finish()
            }
        }
    }
}