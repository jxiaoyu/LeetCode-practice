/**
 * 思路也很直接，为了 in place，用 int 型的高位来保存下个状态
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
     
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int count = 0;
                for(int k=0; k<8; k++){
                    int x = i+dx[k];
                    int y = j+dy[k];
                    count += getNeighbor(board, x, y);
                }
                //Any dead cell with exactly three live neighbors becomes a live cell
                if(count==3 && board[i][j]==0){
                    board[i][j] |= 2; // e.g., '01' & '10'='11'
                }
                // any live cells with 2 or 3 neigbors lives on to the next generation 
                if(count>=2 && count<=3 && board[i][j]==1){
                    board[i][j] |= 2;
                }
            }
        }
     
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                board[i][j] >>= 1;
            }
        }
    }
     
    public int getNeighbor(int[][] board, int x, int y){
        int m = board.length;
        int n = board[0].length;
        if(x<0||x>=m||y<0||y>=n)
            return 0;
        return board[x][y]&1;    
    }
}