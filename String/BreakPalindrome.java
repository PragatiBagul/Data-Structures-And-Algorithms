
class BreakPalindrome {
    public static boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                    int value = Integer.parseInt(Character.toString(board[i][j]));
                    if (rows[i][value - 1] || cols[j][value - 1]) {
                        return false;
                    }
                    rows[i][value - 1] = true;
                    cols[j][value - 1] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] sudoku =  { 
            { '.' ,'.' ,'.' ,'.' ,'5' ,'.' ,'.' ,'1' ,'.'},
            { '.', '4', ' , {  '.,  '.,  '.,  '.,  '.,  '3,  '.,  '.,  '1 ' },
            { '8', '.', '.', '.', '.', '.', '.', '2', '.' },  ', '.', '2', '.', '7', '.', '.', '.', '.' },
            { '.', '1', '5', '.', '.', '.', '.', '.', '.' },  ', '.', '.', '.', '.', '2', '.', '.', '.' },
            { '.', '2', '.', '9', '.', '.', '.', '.', '.' },  ', '.', '4', '.', '.', '.', '.', '.', '.' } };
        System.out.println(isValidSudoku(sudoku)); 
}