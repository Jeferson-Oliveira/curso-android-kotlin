package br.com.cursoandroid.www.whatsappclone.controller

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import br.com.cursoandroid.www.whatsappclone.R
import br.com.cursoandroid.www.whatsappclone.model.entity.User
import br.com.cursoandroid.www.whatsappclone.model.repository.AuthRepository
import br.com.cursoandroid.www.whatsappclone.util.PermissionUtil
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
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

        if (repository.isUserLogged()) {
            abrirHome()
        }

        btnLogin.setOnClickListener {
            if (txtUserEmail.text.isBlank() || txtUserPassword.text.isBlank()) {
                Toast.makeText(this, "Preencha os campos corretamente", Toast.LENGTH_SHORT).show()
            } else {
                repository.signIn(User(txtUserEmail.text.toString(),txtUserPassword.text.toString()), onSuccess = {
                    abrirHome()
                }, onError = {
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                })
            }
        }

        lblCadastre.setOnClickListener {
            startActivity(Intent(this, BasicFieldsActivity::class.java))
        }

    }

    private fun abrirHome() {
        val intent = Intent(this, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
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
        dialog.setPositiveButton("Confirmar", { _: DialogInterface, _: Int ->
            finish()
        })
        dialog.show()
    }
}
