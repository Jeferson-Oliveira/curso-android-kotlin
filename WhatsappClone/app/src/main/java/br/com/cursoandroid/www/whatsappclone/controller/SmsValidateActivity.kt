package br.com.cursoandroid.www.whatsappclone.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
import br.com.cursoandroid.www.whatsappclone.R
import br.com.cursoandroid.www.whatsappclone.model.repository.AuthRepository
import kotlinx.android.synthetic.main.activity_sms_validate.*


class SmsValidateActivity : AppCompatActivity() {

    var phoneNumber: String = ""
    val repository = AuthRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_validate)
        loadComponents()

        this.phoneNumber = intent.extras.getString("phoneNumber")
        sendSms(phoneNumber)
    }

    private fun sendSms(toNumber: String) {
        repository.sendToken(toNumber, onSuccess = {} , onError = {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun loadComponents() {
        val smfSmsCode = SimpleMaskFormatter("NNNN")
        val mtwSmsCode = MaskTextWatcher(txtSmsCode,smfSmsCode)
        txtSmsCode.addTextChangedListener(mtwSmsCode)

        btnValidarSMS.setOnClickListener {
            if(!txtSmsCode.text.isBlank()) {
                repository.validateToken(txtSmsCode.text.toString(), onSuccess = {
                    Toast.makeText(this, "Código válido", Toast.LENGTH_SHORT).show()
                }, onError = {
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                })
            }
        }

        lblReenviar.setOnClickListener {
            sendSms(this.phoneNumber)
        }
    }


}
