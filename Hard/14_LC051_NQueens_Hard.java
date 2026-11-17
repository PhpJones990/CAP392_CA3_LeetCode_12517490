class Solution {
    private Set<Integer> col = new HashSet<>();
    private Set<Integer> posDiag = new HashSet<>(); // (r + c)
    private Set<Integer> negDiag = new HashSet<>(); // (r - c)
    private List<List<String>> res = new ArrayList<>();
    private char[][] board;
    private int n; 

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.board = new char[n][n];
        for (int i = 0; i < n; i++) 
        {
            Arrays.fill(board[i], '.');
        }

        backtrack(0);
        return res;
    } 

    private void backtrack(int r) 
    {
        if (r == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }

            col.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';

            backtrack(r + 1);

            col.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }
    }
}