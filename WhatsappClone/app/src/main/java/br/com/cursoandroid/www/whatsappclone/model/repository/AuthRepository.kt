package br.com.cursoandroid.www.whatsappclone.model.repository

import android.telephony.SmsManager
import android.util.Log
import br.com.cursoandroid.www.whatsappclone.model.entity.User
import br.com.cursoandroid.www.whatsappclone.util.Base64Util
import com.google.firebase.auth.*
import java.util.*

/**
 * Created by jeferson on 14/04/18.
 */
class AuthRepository {

    val firebaseAuth = FirebaseAuth.getInstance()
    val userRepository = UserRepository()

    var token: String = ""

    fun isUserLogged(): Boolean {
        return firebaseAuth.currentUser != null
    }

    fun signIn(user: User, onSuccess: () -> Unit, onError: (errorMessage: String) -> Unit) {
        firebaseAuth.signInWithEmailAndPassword(user.email, user.password).addOnCompleteListener {
            if (it.isSuccessful) {
                onSuccess()
            } else {
                it.exception?.message?.let {
                    onError(it)
                }
            }
        }
    }

    fun signUp(user: User, onSuccess: () -> Unit, onError: (errorMessage: String) -> Unit) {
        firebaseAuth.createUserWithEmailAndPassword(user.email, user.password).addOnCompleteListener {

            try {
                if (it.isSuccessful) {
                    user.id = Base64Util.encode(user.email)
                    userRepository.saveUserData(user,onSuccess,onError)
                } else {
                    it.exception?.let {
                        throw it
                    }
                }
            } catch (wpe: FirebaseAuthWeakPasswordException) {
                onError("Por favor preencha uma senha mais forte")
            } catch (ice: FirebaseAuthInvalidCredentialsException) {
                onError("Por favor verifique se se email está correto")
            } catch (fce: FirebaseAuthUserCollisionException) {
                onError("Já existe um usuário com essas credenciais cadastrado")
            }

        }
    }



    fun signOut() {
        firebaseAuth.signOut();
    }

    fun sendToken(toNumber: String, onSuccess: () -> Unit, onError: (errorMessage: String) -> Unit) {

        val token = (Random().nextInt(9999 - 1000) + 1000).toString()
/*
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("userToken",token)
*/
        Log.i("SMS", token)

        this.token = token

        try {
            SmsManager.getDefault().sendTextMessage("+5571983377911",null,"Olá, seu token de confirmação é ${token}",null, null)
            onSuccess()
        } catch (e: Exception) {
            onError("Não foi possível enviar o código de SMS, ${e.message}")
        }

    }

    fun validateToken(token: String, onSuccess: () -> Unit, onError: (errorMessage: String) -> Unit) {
        val sendedToken = this.token //sharedPreferences.getString("userToken" , "")

        if (token.equals(sendedToken)) {
            onSuccess()
        } else {
            onError("Código de SMS inválido")
        }

    }
}