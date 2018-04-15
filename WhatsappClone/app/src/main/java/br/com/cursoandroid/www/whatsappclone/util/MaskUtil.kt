package br.com.cursoandroid.www.whatsappclone.util

class MaskUtil {

    companion object {
        fun removeMask(from: String): String {
            return from.replace(" ", "").
                        replace("(","").
                        replace(")","").
                        replace("-","").
                        replace("+","")
        }
    }
}