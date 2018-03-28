package com.group.goodgames.sudoku;

/**
 * Created by katielevy on 3/27/18.
 */

public class SudokuMatrixData {

    public int[][] mMatrix;

    public SudokuMatrixData() {
        mMatrix = new int[9][9];
    }

    public String getValue(int row, int col) {
        int val = mMatrix[row][col];
        if(val == -1) {
            return "1";
        } else {
            return "" + val;
        }
    }

    public boolean setValue(int row, int col, int val) {
//        boolean rowCheck = checkRow(row, val);
//        boolean colCheck = checkCol(col, val);
//        boolean boxCheck = checkBox(col, val);
//        if (rowCheck && colCheck && boxCheck) {
            mMatrix[row][col] = val;
//        }
        return true;
    }


}
