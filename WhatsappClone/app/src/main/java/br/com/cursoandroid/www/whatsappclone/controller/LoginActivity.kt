package br.com.cursoandroid.www.whatsappclone.controller

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.cursoandroid.www.whatsappclone.Manifest
import br.com.cursoandroid.www.whatsappclone.R
import br.com.cursoandroid.www.whatsappclone.model.repository.AuthRepository
import br.com.cursoandroid.www.whatsappclone.util.MaskUtil
import br.com.cursoandroid.www.whatsappclone.util.PermissionUtil
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val repository = AuthRepository()
    private val permissions = listOf(android.Manifest.permission.SEND_SMS)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loadComponents()
        PermissionUtil.validPermissions(this, permissions)
    }

    private fun loadComponents() {
        val smfPhoneNumber = SimpleMaskFormatter("NNNNN-NNNN")
        val mtwPhoneNumber = MaskTextWatcher(txPhoneNumber,smfPhoneNumber)
        txPhoneNumber.addTextChangedListener(mtwPhoneNumber)

        val smfCountryNumber = SimpleMaskFormatter("+NN")
        val mtwCountryNumber = MaskTextWatcher(txCountry,smfCountryNumber)
        txCountry.addTextChangedListener(mtwCountryNumber)

        val smfDDDNumber = SimpleMaskFormatter("NN")
        val mtwDDDNumber = MaskTextWatcher(txDDD,smfDDDNumber)
        txDDD.addTextChangedListener(mtwDDDNumber)

        btnCadastrar.setOnClickListener {
            if (txtUserName.text.isBlank() || txCountry.text.isBlank() || txDDD.text.isBlank() || txPhoneNumber.text.isBlank()) {
                Toast.makeText(this, "Preencha os campos corretamente", Toast.LENGTH_SHORT).show()
            } else {
                val completePhoneNumber = txCountry.text.toString().plus(txDDD.text.toString()).plus(MaskUtil.removeMask(txPhoneNumber.text.toString()))
                Toast.makeText(this, "Número sem formatação ${completePhoneNumber}", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, SmsValidateActivity::class.java)
                intent.putExtra("phoneNumber" , completePhoneNumber)

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
