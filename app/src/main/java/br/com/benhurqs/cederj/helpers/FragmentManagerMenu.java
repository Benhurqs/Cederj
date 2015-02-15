package br.com.benhurqs.cederj.helpers;


import android.support.v4.app.Fragment;

import br.com.benhurqs.cederj.fragment.CalendarioFragment;
import br.com.benhurqs.cederj.fragment.ChatFragment;
import br.com.benhurqs.cederj.fragment.MateriasFragment;
import br.com.benhurqs.cederj.fragment.NotasFragment;
import br.com.benhurqs.cederj.fragment.NoticiasFragment;
import br.com.benhurqs.cederj.fragment.PolosFragment;
import br.com.benhurqs.cederj.fragment.TutoresFragment;

/**
 * Created by benhur on 15/02/15.
 */
public class FragmentManagerMenu {

    public static int CALENDAR_POSITION = 0;
    public static int MATERIAS_POSITION = 1;
    public static int NOTICIAS_POSITION = 2;
    public static int CHAT_POSITION = 3;
    public static int NOTAS_POSITION = 4;
    public static int CONFIGURACAO_POSITION = 5;
    public static int POLOS_POSITION = 6;
    public static int TUTORES_POSITION = 7;


    static CalendarioFragment calendarioFragment;
    static ChatFragment chatFragment;
//    static ConfiguracaoFragment configuracaoFragment;
    static MateriasFragment materiasFragment;
    static NotasFragment notasFragment;
    static NoticiasFragment noticiasFragment;
    static PolosFragment polosFragment;
    static TutoresFragment tutoresFragment;



    public FragmentManagerMenu(){

        calendarioFragment = new CalendarioFragment();
        chatFragment = new ChatFragment();
//        configuracaoFragment = new ConfiguracaoFragment();
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
//            }case 5:{
//                return configuracaoFragment;
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