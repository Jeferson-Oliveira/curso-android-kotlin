package br.com.cursoandroid.www.whatsappclone.model.repository

import br.com.cursoandroid.www.whatsappclone.model.entity.User
import br.com.cursoandroid.www.whatsappclone.util.Base64Util
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener



/**
 * Created by jeferson.jesus on 18/04/18.
 */
class UserRepository {

    val userReferenceIdentifier = "usuarios"
    val firebaseAuth = FirebaseAuth.getInstance()
    val firebaseDatabase = FirebaseDatabase.getInstance().reference

    fun saveUserData(user: User, onSuccess: () -> Unit, onError: (errorMessage: String) -> Unit) {
        firebaseDatabase.child(userReferenceIdentifier).child(user.id).setValue(user).addOnCompleteListener {
            if (it.isSuccessful) {
                onSuccess()
            } else {
                it.exception?.message?.let {
                    onError("Usuário cadastrado com sucesso porém os dados não foram guardados ".plus(it))
                }
            }
        }
    }

    fun addContact(id: String, onSuccess: () -> Unit, onError: (errorMessage: String) -> Unit) {

        // busca o contato pela identificação
        firebaseDatabase.child(userReferenceIdentifier).child(id).addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                //caso exista o contato será adicinado à lista do usuário logado
                dataSnapshot.value.let {
                    firebaseAuth.currentUser?.email?.let {
                        firebaseDatabase.child("contatos").child(it).setValue(Base64Util.decode(id))
                        onSuccess()
                        return
                    }
                }
                onError("O usuário informado não existe")
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }
}