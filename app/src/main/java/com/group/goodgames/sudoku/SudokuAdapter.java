package com.group.goodgames.sudoku;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by katielevy on 1/23/18.
 */

public class SudokuAdapter extends BaseAdapter {
    private static final int BOARD_SIZE = 81;
    private Context mContext;
    private SudokuMatrixData mSudokuMatrixData;

    public SudokuAdapter(Context context) {
        mContext = context;
        mSudokuMatrixData = new SudokuMatrixData();
        initBoard();
    }

    private void initBoard() {
        mSudokuMatrixData.setValue(1, 1, 8);
        mSudokuMatrixData.setValue(5, 8, 7);
        mSudokuMatrixData.setValue(0, 0, 1);
        mSudokuMatrixData.setValue(1, 7, 9);
    }

    @Override
    public int getCount() {
        return BOARD_SIZE;
    }

    public Object getItem(int id) {
        int row = (id % 9) - 1;
        int col = id / 9;
        Log.i("Adapter", "row: " + row + " col: " + col);
        return mSudokuMatrixData.getValue(row, col);
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
        int row = position / 9;
        int col = (position % 9);
        Log.i("Adapter", "position: " + position + "row: " + row + " col: " + col);
        String value = mSudokuMatrixData.getValue(row, col);
        textView.setText(value);
        return textView;
    }

}
