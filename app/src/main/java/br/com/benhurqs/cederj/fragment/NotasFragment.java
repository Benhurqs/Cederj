package br.com.benhurqs.cederj.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.benhurqs.cederj.R;
import br.com.benhurqs.cederj.widget.NotasTextView;

public class NotasFragment extends Fragment {

    NotasTextView notas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notas, container, false);
        notas = (NotasTextView)view.findViewById(R.id.text);
        notas.setText(9.8f);
        return view;
    }


}
