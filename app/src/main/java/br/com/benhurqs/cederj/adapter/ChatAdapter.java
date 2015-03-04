package br.com.benhurqs.cederj.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.benhurqs.cederj.R;
import br.com.benhurqs.cederj.enums.MessageType;
import br.com.benhurqs.cederj.obj.ChatObj;

/**
 * Created by benhur on 04/03/15.
 */
public class ChatAdapter extends ArrayAdapter<ChatObj> {

    private LayoutInflater mInflater;
    private Context mContext;
    private int layoutResourceId;
    private List<ChatObj> itens;


    public ChatAdapter(Context context, int resource, List<ChatObj> itens) {
        super(context, resource, itens);

        this.mContext = context;
        this.layoutResourceId = resource;
        this.mInflater = LayoutInflater.from(context);
        this.itens = itens;
    }

    @Override
    public ChatObj getItem(int position) {
        return itens.get(position);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ChatObj item = getItem(position);

        if(item.getType() == MessageType.MINE){
            view = mInflater.inflate(R.layout.custom_chat_my_msg, null);
        }else{
            view = mInflater.inflate(R.layout.custom_chat_msg, null);
        }

        TextView txtMsg = (TextView)view.findViewById(R.id.txt_chat_msg);
        txtMsg.setText(item.getMsg());

        return view;

    }
}
