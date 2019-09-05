import java.util.ArrayList;

public class NQueens {
    private int size;
    private int board[][];

    public NQueens(int n) {
        size = n;
        board = new int[size][size]; // initialized with 0's inside the array
    }

    public boolean placeNQueens()throws Exception{ // exception for if the parameter entered is not valid
        if (size <= 0){

            throw new IllegalArgumentException("ERROR");
        }

        return placeNQueens(0);
    }

    public boolean placeNQueens(int col) { // goes through the column and places the Q's
        if(col >= size) {
            return true;
        }
        for(int i = 0; i < size; i++) {
            if (isAttacked(i, col)) {
                board[i][col] = 1;
                if (placeNQueens(col + 1)) { // this is used to backtrack it goes forward to check if it fits otherwise it will come back and change the position of the first one
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    public void placeQ(int row, int col) { // places Q and then return true but if there is a misstep then it will recursively solve this
        board[row][col] = 1;
    }

    public boolean isAttacked(int row, int col) { // this checks whether
        int a;
        int b;

        for(a = 0; a < col; a++) {
            if(board[row][a] == 1) {
                return false;
            }
        }
        for(b = row, a = col; b >= 0 && a >= 0; b--, a--){
            if(board[b][a] == 1) {
                return false;
            }
        }
        for(b = row, a = col; a >= 0 && b < size; b++, a--) {
            if(board[b][a] == 1) {
                return false;
            }
        }
        return true;
    }

}
