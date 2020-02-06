package certification.mirceasoit.toastskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Short toast
        findViewById<Button>(R.id.short_toast_button).setOnClickListener {
           val text = "Short toast!"
           val duration = Toast.LENGTH_SHORT
           val toast = Toast.makeText(applicationContext, text, duration)
           toast.show()
       }

        //Long toast
        findViewById<Button>(R.id.long_toast_button).setOnClickListener {
            Toast.makeText(applicationContext, "Long toast!", Toast.LENGTH_LONG).show()
        }

        //Custom toast
        findViewById<Button>(R.id.custom_toast_button).setOnClickListener {
            val inflater = layoutInflater
            val container: ViewGroup = findViewById(R.id.container)
            //val container: ViewGroup = window.decorView.rootView as ViewGroup
            //val container: ViewGroup = window.decorView.rootView as ViewGroup
            val layout: View = inflater.inflate(R.layout.custom_toast, container, false)
            val text: TextView = layout.findViewById(R.id.text)
            text.text = getString(R.string.this_is_a_custom_toast)
            with (Toast(applicationContext)) {
                setGravity(Gravity.TOP, 0, 0)
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }
    }
}
