class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs = new HashSet<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];

                if(c != '.'){
                    if( !hs.add("num "+ c + " at row " + i) ||
                        !hs.add("num "+ c + " at col " + j) ||
                        !hs.add("num "+ c + " in 3x3 at " + i/3 + " x " + j/3) )
                    return false;
                }
            }
        }
        // System.out.println(hs);
        return true;
    }
}