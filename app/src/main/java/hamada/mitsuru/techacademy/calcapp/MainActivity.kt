package hamada.mitsuru.techacademy.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)

    }

    override fun onClick(view : View){

        //テキストに数字が入力されていない場合
        if(editText.getText().toString()  == "" || editText2.getText().toString() == "") {
            //スナックバー表示
            Snackbar.make(view, "テキストに数字を入力してください。", Snackbar.LENGTH_INDEFINITE)
                .setAction("Action") {
                    Log.d("UI_PARTS", "テキストが空")
                }.show()

            //テキストに数字が入力されている場合
        }else {
            //変数定義
            val num = Convert(editText)
            val num2 = Convert(editText2)
            val intent = Intent(this, Main2Activity::class.java)

            //計算
            when (view.id) {
                R.id.button1 -> {
                    Log.d("button1", "test")

                    val result = num + num2

                    intent.putExtra("VALUE1", result)
                    startActivity(intent)
                }
                R.id.button2 -> {
                    Log.d("button2", "test")

                    val result = num - num2

                    intent.putExtra("VALUE1", result)
                    startActivity(intent)
                }
                R.id.button3 -> {
                    Log.d("button3", "test")

                    val result = num * num2

                    intent.putExtra("VALUE1", result)
                    startActivity(intent)
                }
                R.id.button4 -> {
                    Log.d("button4", "test")

                    val result = num / num2

                    intent.putExtra("VALUE1", result)
                    startActivity(intent)
                }
            }
        }
    }

    //テキストをDoubleに変更
    fun Convert(editText: EditText) :Double{
        val numstring = editText.getText().toString()
        val num = numstring.toDouble()
        return num
    }

}
