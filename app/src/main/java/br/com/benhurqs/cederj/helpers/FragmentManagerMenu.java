package br.com.benhurqs.cederj.helpers;


import android.support.v4.app.Fragment;

import br.com.benhurqs.cederj.fragment.CalendarioFragment;
import br.com.benhurqs.cederj.fragment.ChatFragment;
import br.com.benhurqs.cederj.fragment.ConfiguracaoFragment;
import br.com.benhurqs.cederj.fragment.MateriasFragment;
import br.com.benhurqs.cederj.fragment.NotasFragment;
import br.com.benhurqs.cederj.fragment.NoticiasFragment;
import br.com.benhurqs.cederj.fragment.PolosFragment;
import br.com.benhurqs.cederj.fragment.TutoresFragment;

/**
 * Created by benhur on 15/02/15.
 */
public class FragmentManagerMenu {

    static CalendarioFragment calendarioFragment;
    static ChatFragment chatFragment;
    static ConfiguracaoFragment configuracaoFragment;
    static MateriasFragment materiasFragment;
    static NotasFragment notasFragment;
    static NoticiasFragment noticiasFragment;
    static PolosFragment polosFragment;
    static TutoresFragment tutoresFragment;



    public FragmentManagerMenu(){

        calendarioFragment = new CalendarioFragment();
        chatFragment = new ChatFragment();
        configuracaoFragment = new ConfiguracaoFragment();
        materiasFragment = new MateriasFragment();
        notasFragment = new NotasFragment();
        noticiasFragment = new NoticiasFragment();
        polosFragment = new PolosFragment();
        tutoresFragment = new TutoresFragment();


    }

    public Fragment getFragment(int position){
        switch (position) {
            case 0:{
                return calendarioFragment;
            }case 1:{
                return materiasFragment;
            }case 2:{
                return noticiasFragment;
            }case 3:{
                return chatFragment;
            }case 4:{
                return notasFragment;
            }case 5:{
                return configuracaoFragment;
            }case 6:{
                return polosFragment;
            }case 7:{
                return tutoresFragment;
            }
            default:{
                return null;
            }

        }
    }

}