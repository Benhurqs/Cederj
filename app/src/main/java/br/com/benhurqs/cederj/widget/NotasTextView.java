package br.com.benhurqs.cederj.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import br.com.benhurqs.cederj.R;

/**
 * Created by benhur on 05/03/15.
 */
public class NotasTextView extends TextView {

    public NotasTextView(Context context) {
        super(context);
    }

    public NotasTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NotasTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setText(float value){
        this.setText(String.valueOf(value));
        updateNotaColor(value);
    }

    public void updateNotaColor(float nota){
        if(nota < 5.0f){
            this.setBackgroundColor(getResources().getColor(R.color.red));
        }else if(nota < 6.0f){
            this.setBackgroundColor(getResources().getColor(R.color.yellow));
        }else if(nota < 8.0f){
            this.setBackgroundColor(getResources().getColor(R.color.blue));
        }else if(nota <= 10.0f){
            this.setBackgroundColor(getResources().getColor(R.color.green));
        }
    }
}
