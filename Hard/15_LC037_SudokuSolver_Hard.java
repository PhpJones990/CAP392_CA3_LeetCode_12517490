class Solution {
    private boolean[][] rows = new boolean[9][10];
    private boolean[][] cols = new boolean[9][10];
    private boolean[][] boxes = new boolean[9][10];
    private List<int[]> emptyCells = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) 
            {
                if (board[r][c] == '.') emptyCells.add(new int[]{r, c});
                else 
                {
                    int d = board[r][c] - '0';
                    int boxIdx = (r / 3) * 3 + (c / 3);
                    rows[r][d] = true;
                    cols[c][d] = true;
                    boxes[boxIdx][d] = true;
                }
            }
        }

        backtrack(board, 0);
    } 

    private boolean backtrack(char[][] board, int idx) {
        if (idx == emptyCells.size()) return true; 

        int r = emptyCells.get(idx)[0];
        int c = emptyCells.get(idx)[1];
        int boxIdx = (r / 3) * 3 + (c / 3);

        for (int d = 1; d <= 9; d++) 
        {
            if (rows[r][d] || cols[c][d] || boxes[boxIdx][d]) continue; 

            board[r][c] = (char) ('0' + d);
            rows[r][d] = true;
            cols[c][d] = true;
            boxes[boxIdx][d] = true;

            if (backtrack(board, idx + 1)) return true; 

            board[r][c] = '.';
            rows[r][d] = false;
            cols[c][d] = false;
            boxes[boxIdx][d] = false;
        }

        return false;
    }
}