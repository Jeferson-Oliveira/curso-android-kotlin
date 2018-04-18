package br.com.cursoandroid.www.whatsappclone.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import br.com.cursoandroid.www.whatsappclone.fragments.ContatosFragment
import br.com.cursoandroid.www.whatsappclone.fragments.ConversasFragment

class TabAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    private val pageTitles = arrayOf("CONVERSAS","CONTATOS")

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> {
                fragment = ConversasFragment()
            }
            1 -> {
                fragment = ContatosFragment()
            }
        }

        fragment?.let {
            return it
        }
        return Fragment()
    }

    override fun getCount(): Int {
        return pageTitles.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return pageTitles[position]
    }

}