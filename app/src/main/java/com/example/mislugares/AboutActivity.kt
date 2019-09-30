package com.example.mislugares

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.about.*

class AboutActivity : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)

        val extras = intent.extras
        val s = extras?.getString("usuario")?:"sin usuario"
        val i = extras?.getInt("edad")?:-1

        val label_name : String = getString(R.string.label_name)
        val label_age : String = getString(R.string.label_age)
        TextView01.text = "$label_name: $s \n$label_age: $i \n\n${TextView01.text}"

        val intent = Intent()
        intent.putExtra("resultado", "OK")
        setResult(Activity.RESULT_OK, intent)
    }
}