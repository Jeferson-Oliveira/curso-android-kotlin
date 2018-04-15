package br.com.cursoandroid.www.whatsappclone.util

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat

class PermissionUtil {
    companion object {
        fun validPermissions(context: Activity, permissions: List<String>) : Boolean {

            if (Build.VERSION.SDK_INT >= 23) {//Marshmallow

                var permissionsNotGranted = ArrayList<String>()

                permissions.forEach {
                    val permissionValid = context.checkSelfPermission(it) == PackageManager.PERMISSION_GRANTED
                    if (!permissionValid) {
                        permissionsNotGranted.add(it)
                    }
                }

                if (!permissionsNotGranted.isEmpty()) {
                    var newPermitions = emptyArray<String>()
                    permissionsNotGranted.toArray(newPermitions)

                    ActivityCompat.requestPermissions(context,newPermitions, 1)
                }
            }


            return true
        }
    }
}