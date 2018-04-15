package br.com.cursoandroid.www.whatsappclone.controller

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import br.com.cursoandroid.www.whatsappclone.R
import br.com.cursoandroid.www.whatsappclone.model.entity.User
import br.com.cursoandroid.www.whatsappclone.util.MaskUtil
import br.com.cursoandroid.www.whatsappclone.util.PermissionUtil
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
import kotlinx.android.synthetic.main.activity_basic_fields.*

class BasicFieldsActivity : AppCompatActivity() {

    private val permissions = listOf(android.Manifest.permission.SEND_SMS)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_fields)
        loadComponents()
        PermissionUtil.validPermissions(this, permissions)
    }

    private fun loadComponents() {

        val smfPhoneNumber = SimpleMaskFormatter("NNNNN-NNNN")
        val mtwPhoneNumber = MaskTextWatcher(txtUserPhone,smfPhoneNumber)
        txtUserPhone.addTextChangedListener(mtwPhoneNumber)

        val smfCountryNumber = SimpleMaskFormatter("+NN")
        val mtwCountryNumber = MaskTextWatcher(txCountry,smfCountryNumber)
        txCountry.addTextChangedListener(mtwCountryNumber)

        val smfDDDNumber = SimpleMaskFormatter("NN")
        val mtwDDDNumber = MaskTextWatcher(txDDD,smfDDDNumber)
        txDDD.addTextChangedListener(mtwDDDNumber)

        btnConfirmar.setOnClickListener {
            if (txtUserName.text.isBlank() || txtEmail.text.isBlank() || txCountry.text.isBlank() || txDDD.text.isBlank() || txtUserPhone.text.isBlank()) {
                Toast.makeText(this, "Preencha os campos corretamente", Toast.LENGTH_SHORT).show()
            } else {
                val completePhoneNumber = txCountry.text.toString().plus(txDDD.text.toString()).plus(MaskUtil.removeMask(txtUserPhone.text.toString()))

                val userData = User(txtUserName.text.toString(), completePhoneNumber, txtEmail.text.toString())
                val intent = Intent(this, SmsValidateActivity::class.java)
                intent.putExtra("userData" , userData)

                startActivity(intent)
            }
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        grantResults.forEach {
            if (it == PackageManager.PERMISSION_DENIED) {
                showPermissionAlert()
            }
        }
    }

    private fun showPermissionAlert() {
        val dialog = android.app.AlertDialog.Builder(this)
        dialog.setTitle("Atenção")
        dialog.setMessage("Para utilizar esse aplicativo será necessário aceitar as permissões")
        dialog.setPositiveButton("Confirmar", { dialogInterface: DialogInterface, i: Int ->
            finish()
        })
        dialog.show()
    }
}
