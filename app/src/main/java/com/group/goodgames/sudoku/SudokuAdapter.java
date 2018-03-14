package com.group.goodgames.sudoku;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by katielevy on 1/23/18.
 */

public class SudokuAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mMatrix = {
           "1", "2", "3", "4", "5", "6", "7", "8", "9"
    };

    public SudokuAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return (mMatrix.length * 9);
    }

    public Object getItem(int id) {
        return mMatrix[(id % 9)];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView == null) {
            textView = new TextView(mContext);
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            textView.setLayoutParams(new GridView.LayoutParams(85, 85));
            textView.setPadding(8, 8, 8, 8);
        } else {
            textView = (TextView) convertView;
        }
        textView.setText(mMatrix[position % 9]);
        return textView;
    }

}
