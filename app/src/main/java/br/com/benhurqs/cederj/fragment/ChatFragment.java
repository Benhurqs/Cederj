package br.com.benhurqs.cederj.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import br.com.benhurqs.cederj.R;

public class ChatFragment extends Fragment {

    private EditText edtMsg;
    private ListView msgList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        initView(view);

        return view;
    }

    public void initView(View view){
        edtMsg = (EditText)view.findViewById(R.id.edt_msg_chat);
        msgList = (ListView)view.findViewById(R.id.lv_chat);
    }


}
