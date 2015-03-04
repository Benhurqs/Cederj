package br.com.benhurqs.cederj.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.benhurqs.cederj.R;
import br.com.benhurqs.cederj.adapter.ChatAdapter;
import br.com.benhurqs.cederj.enums.MessageType;
import br.com.benhurqs.cederj.obj.ChatObj;

public class ChatFragment extends Fragment {

    private EditText edtMsg;
    private ListView msgList;
    private ChatAdapter chatAdapter;
    private List<ChatObj> listObj;

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

        populateList();

        edtMsg.setImeActionLabel("Enviar", KeyEvent.KEYCODE_ENTER);
        edtMsg.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    if(!edtMsg.getText().toString().isEmpty()) {
                        ChatObj obj = new ChatObj(edtMsg.getText().toString(), MessageType.MINE);
                        notifyMessage(obj);
                    }
                    return true;
                }
                return false;
            }
        });
    }

    public void notifyMessage(ChatObj obj){
        listObj.add(obj);
        chatAdapter.notifyDataSetChanged();
        msgList.setSelection(msgList.getChildCount()-1);
        edtMsg.setText("");
    }

    public void populateList(){
        listObj = new ArrayList<ChatObj>();

        ChatObj obj = new ChatObj("Oi, Tudo bem?", MessageType.ANOTHER);
        listObj.add(obj);

        obj = new ChatObj("Tudo sim. E com voce?", MessageType.MINE);
        listObj.add(obj);

        obj = new ChatObj("Sabe qual a matéria da prova?", MessageType.MINE);
        listObj.add(obj);

        obj = new ChatObj("Vai ser a unidade 1 e 2 do livro?", MessageType.ANOTHER);
        listObj.add(obj);

        obj = new ChatObj("Estou desesperado. Acho que não vou conseguir tirar a nota que preciso, pois esqueci de fazer uma AD e fiquei com pouca nota.", MessageType.MINE);
        listObj.add(obj);

        obj = new ChatObj("Xii", MessageType.ANOTHER);
        listObj.add(obj);

        obj = new ChatObj("De qualquer forma obrigado!", MessageType.MINE);
        listObj.add(obj);

        obj = new ChatObj("de nada. Boa sorte!", MessageType.ANOTHER);
        listObj.add(obj);

        chatAdapter = new ChatAdapter(getActivity(), R.layout.custom_chat_msg, listObj);
        msgList.setAdapter(chatAdapter);
        msgList.setSelection(msgList.getChildCount()-1);

    }


}
