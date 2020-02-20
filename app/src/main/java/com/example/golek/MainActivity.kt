package com.example.golek

import android.R.id.input
import android.R.id.message
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bSave.setOnClickListener {
            val errNama: String = "Nama tidak boleh kosong Bos!";
            val errDuit: String = "Duit kamu kurang bos!"
            val errDuit2: String = "Ini tidak boleh kosong Bos!"
            val errRasa: String = "Rasa tidak boleh kosong Bos!"

            val hargaLeker: Int = 2000

            var inputNama = fInputnama.text.toString()
            if (inputNama.isNullOrBlank()) {
                Toast.makeText(this, errNama, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var inputLeker = fInputLeker.text.toString().toInt()

            if (inputLeker < 0) {
                Toast.makeText(this, errDuit2, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var inputRasa = fInputRasa.text.toString()
            if (inputRasa.isNullOrBlank()) {
                Toast.makeText(this, errRasa, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

//            var bayarLeker = inputLeker * hargaLeker
//            var bayarLekers = inputLeker / hargaLeker
          var bayarLeker: Int =
            if (inputLeker > 100){
                inputLeker / hargaLeker
            } else {
                inputLeker * hargaLeker
            }

            fInputnama.text.clear()
            fInputLeker.text.clear()
            fInputRasa.text.clear()


            fPesanan.text = "Ini Pesanan Kamu\n\n\n\n" +
                    "Nama Kamu : $inputNama\n\n" +
                    "Rasa Kamu : $inputRasa\n\n\n\n" +
                    "Maacih ya.."

            if (bayarLeker > 100){
                fPesanan.text = "Ini Pesanan Kamu\n\n\n\n" +
                        "Nama Kamu : $inputNama\n\n" +
                        "Leker Kamu : $inputLeker biji\n\n" +
                        "Kamu harus bayar :  Rp.$bayarLeker\n\n" +
                        "Rasa Kamu : $inputRasa"
            } else {
                fPesanan.text = "Ini Pesanan Kamu\n\n\n\n" +
                        "Duit kamu : Rp.$inputLeker\n\n" +
                        "Kamu dapet Leker : $bayarLeker biji\n\n" +
                        "Rasa Kamu : $inputRasa"

            }

            bKirim.setOnClickListener {


                fInputnama.text.clear()
                fInputLeker.text.clear()
                fInputRasa.text.clear()
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(
                    Intent.EXTRA_TEXT, "Ini Pesanan Kamu\n\n\n\n" +
                            "Nama Kamu : $inputNama\n\n" +
                            "Jumlah Leker : $inputLeker\n\n" +
                            "Kamu harus bayar :  Rp.$bayarLeker\n\n" +
                            "Rasa Kamu : $inputRasa\n\n\n\n" +
                            "Maacih ya.."
                )
                sendIntent.type = "text/plain"
                sendIntent.setPackage("com.whatsapp")
                if (sendIntent.resolveActivity(packageManager) != null) {
                    startActivity(sendIntent)
                }

            }
        }
        }
    }
