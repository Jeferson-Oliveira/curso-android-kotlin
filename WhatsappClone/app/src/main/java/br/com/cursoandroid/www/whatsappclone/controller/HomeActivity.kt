package br.com.cursoandroid.www.whatsappclone.controller

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import br.com.cursoandroid.www.whatsappclone.R
import br.com.cursoandroid.www.whatsappclone.adapters.TabAdapter
import br.com.cursoandroid.www.whatsappclone.model.repository.AuthRepository
import br.com.cursoandroid.www.whatsappclone.util.Base64Util
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val repository = AuthRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        loadComponents()
    }

    private fun loadComponents() {

        val toolbar = findViewById<Toolbar>(barra_menu.id)
        toolbar.title = "Whatsapp"
        setSupportActionBar(toolbar)

        stl_layout.setDistributeEvenly(true)

        vp_pagina.adapter = TabAdapter(supportFragmentManager)

        stl_layout.setViewPager(vp_pagina)
        stl_layout.setSelectedIndicatorColors(ContextCompat.getColor(this,R.color.colorAccent))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId) {
            R.id.action_sair -> {
                deslogar()
                return true
            }
            R.id.action_add_contato -> {
                abrirCadastroContato()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun abrirCadastroContato() {
        val alertDialog = AlertDialog.Builder(this).apply {
            setTitle("Novo contato")
            setMessage("Informe o e-mail do usuário")
            setCancelable(false)
        }

        var editTextEmail = EditText(this)
        editTextEmail.setTextColor(ContextCompat.getColor(this,android.R.color.black))

        alertDialog.setView(editTextEmail)

        alertDialog.setPositiveButton("CADASTRAR", { di: DialogInterface, which: Int ->
            val emailUsuario = editTextEmail.text.toString()
            if(emailUsuario.isNullOrBlank()) {
                Toast.makeText(getContext(), "Preencha o campo email" , Toast.LENGTH_SHORT)
            } else {
                Base64Util.encode(emailUsuario)
            }
        })

        alertDialog.setNegativeButton("CANCELAR", { _:DialogInterface, _:Int ->

        })

        alertDialog.create()
        alertDialog.show()
    }

    private fun getContext(): HomeActivity {
        return this
    }

    private fun deslogar() {
        repository.signOut()
        val loginIntent = Intent(this, LoginActivity::class.java)
        loginIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(loginIntent)
    }
}
