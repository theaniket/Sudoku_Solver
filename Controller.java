package sample;

public class Controller {

    public static boolean isRectangleLegal(int[][] board, int x1, int x2, int y1, int y2, String errormsg) {
        boolean[] isPresent = {false, false, false, false, false, false, false, false, false, false};

        for (int x=x1; x<=x2; x++) {
            for (int y=y1; y<=y2; y++) {
                if (board[x][y] > 0) {
                    if (isPresent[board[x][y]]) {
                        return false;
                    }
                    isPresent[board[x][y]] = true;
                }
            }
        }
        return true;
    }

    public static boolean isLegal(int[][] board) {

        if (!isRectangleLegal(board, 0, 2, 0, 2, "Block 1")) return false;
        if (!isRectangleLegal(board, 3, 5, 0, 2, "Block 2")) return false;
        if (!isRectangleLegal(board, 6, 8, 0, 2, "Block 3")) return false;
        if (!isRectangleLegal(board, 0, 2, 3, 5, "Block 4")) return false;
        if (!isRectangleLegal(board, 3, 5, 3, 5, "Block 5")) return false;
        if (!isRectangleLegal(board, 6, 8, 3, 5, "Block 6")) return false;
        if (!isRectangleLegal(board, 0, 2, 6, 8, "Block 7")) return false;
        if (!isRectangleLegal(board, 3, 5, 6, 8, "Block 8")) return false;
        if (!isRectangleLegal(board, 6, 8, 6, 8, "Block 9")) return false;

        if (!isRectangleLegal(board, 0, 0, 0, 8, "Column 0")) return false;
        if (!isRectangleLegal(board, 1, 1, 0, 8, "Column 1")) return false;
        if (!isRectangleLegal(board, 2, 2, 0, 8, "Column 2")) return false;
        if (!isRectangleLegal(board, 3, 3, 0, 8, "Column 3")) return false;
        if (!isRectangleLegal(board, 4, 4, 0, 8, "Column 4")) return false;
        if (!isRectangleLegal(board, 5, 5, 0, 8, "Column 5")) return false;
        if (!isRectangleLegal(board, 6, 6, 0, 8, "Column 6")) return false;
        if (!isRectangleLegal(board, 7, 7, 0, 8, "Column 7")) return false;
        if (!isRectangleLegal(board, 8, 8, 0, 8, "Column 8")) return false;

        if (!isRectangleLegal(board, 0, 8, 0, 0, "Row 0")) return false;
        if (!isRectangleLegal(board, 0, 8, 1, 1, "Row 1")) return false;
        if (!isRectangleLegal(board, 0, 8, 2, 2, "Row 2")) return false;
        if (!isRectangleLegal(board, 0, 8, 3, 3, "Row 3")) return false;
        if (!isRectangleLegal(board, 0, 8, 4, 4, "Row 4")) return false;
        if (!isRectangleLegal(board, 0, 8, 5, 5, "Row 5")) return false;
        if (!isRectangleLegal(board, 0, 8, 6, 6, "Row 6")) return false;
        if (!isRectangleLegal(board, 0, 8, 7, 7, "Row 7")) return false;
        if (!isRectangleLegal(board, 0, 8, 8, 8, "Row 8")) return false;
        return true;
    }

    public static boolean solve(int[][] board) throws Exception {

        for (int x=0; x<9; x++) {
            for (int y=0; y<9; y++) {
                if (board[x][y] == 0) {

                    for (board[x][y]=1; board[x][y]<=9; board[x][y]++) {
                        if (isLegal(board) && solve(board)) {
                            return true;
                        }
                    }

                    board[x][y] = 0;
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean Algorithm(int[][] a) throws Exception{
        return solve(a);
    }

}
