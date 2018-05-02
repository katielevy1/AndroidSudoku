package com.group.goodgames.sudoku

/**
 * Created by katielevy on 3/27/18.
 */

class SudokuMatrixData {

    var mMatrix: Array<IntArray> = Array(9) { IntArray(9) }

    // get the value of that square
    fun getValue(row: Int, col: Int): String {
        return if (mMatrix[row][col] == 0) {
            ""
        } else {
            "" + mMatrix[row][col]
        }
    }

    // set the value of that square
    // TODO: check row, column, box of that square
    fun setValue(row: Int, col: Int, `val`: Int): Boolean {
        //        boolean rowCheck = checkRow(row, val);
        //        boolean colCheck = checkCol(col, val);
        //        boolean boxCheck = checkBox(col, val);
        //        if (rowCheck && colCheck && boxCheck) {
        mMatrix[row][col] = `val`
        //        }
        return true
    }


}
