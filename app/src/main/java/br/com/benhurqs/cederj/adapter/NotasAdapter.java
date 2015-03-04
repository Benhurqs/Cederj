package br.com.benhurqs.cederj.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import br.com.benhurqs.cederj.R;
import br.com.benhurqs.cederj.obj.NotasObj;

/**
 * Created by benhur on 04/03/15.
 */
public class NotasAdapter extends ArrayAdapter<NotasObj> {

    private LayoutInflater mInflater;
    private Context mContext;
    private int layoutResourceId;
    private List<NotasObj> itens;


    public NotasAdapter(Context context, int resource, List<NotasObj> itens) {
        super(context, resource, itens);

        this.mContext = context;
        this.layoutResourceId = resource;
        this.mInflater = LayoutInflater.from(context);
        this.itens = itens;
    }

    @Override
    public NotasObj getItem(int position) {
        return itens.get(position);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        NotasObj item = getItem(position);
        view = mInflater.inflate(R.layout.custom_notas, null);

        TextView txtAd1 = (TextView)view.findViewById(R.id.txt_ad1);
        TextView txtAd2 = (TextView)view.findViewById(R.id.txt_ad2);
        TextView txtAp1 = (TextView)view.findViewById(R.id.txt_ap1);
        TextView txtAp2 = (TextView)view.findViewById(R.id.txt_ap2);
        TextView txtAp3 = (TextView)view.findViewById(R.id.txt_ap3);
        TextView txtNome = (TextView)view.findViewById(R.id.txt_materia);

        if(!item.getAd1().isEmpty()){

        }


        return view;

    }
}
