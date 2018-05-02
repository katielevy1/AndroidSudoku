package com.group.goodgames.sudoku

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.TextView

/**
* Created by katielevy on 1/23/18.
*/

class SudokuAdapter(private val mContext: Context) : BaseAdapter() {
    private val mSudokuMatrixData: SudokuMatrixData = SudokuMatrixData()

    init {
        initBoard()
    }

    // Initialize some of the board with preset values
    private fun initBoard() {
        mSudokuMatrixData.setValue(1, 1, 8)
        mSudokuMatrixData.setValue(5, 8, 7)
        mSudokuMatrixData.setValue(0, 0, 1)
        mSudokuMatrixData.setValue(1, 7, 9)
    }

    override fun getCount(): Int {
        return BOARD_SIZE
    }

    // get value of square from table id number, ie. 78
    override fun getItem(id: Int): Any {
        val row = id % 9 - 1
        val col = id / 9
        Log.i("Adapter", "row: $row col: $col")
        return mSudokuMatrixData.getValue(row, col)
    }

    override fun getItemId(i: Int): Long {
        return 0
    }


    // Create view for square if it has not been created before
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val textView: TextView
        if (convertView == null) {
            textView = TextView(mContext)
            textView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white))
            textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
//            textView.layoutParams = GridView.LayoutParams(85, 85)
            textView.setPadding(8, 8, 8, 8)
        } else {
            textView = convertView as TextView
        }
        val row = position / 9
        val col = position % 9
        Log.i("Adapter", "position: $position row: $row col: $col")
        val value = mSudokuMatrixData.getValue(row, col)
        textView.text = value
        return textView
    }

    companion object {
        private const val BOARD_SIZE = 81
    }


}
