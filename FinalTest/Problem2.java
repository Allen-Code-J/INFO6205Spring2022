package FinalTest;



/**
 * Question2: Given an m x n 2D binary grid grid which represents a map of '1's (land)
 * and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed
 * by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */

public class Problem2 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{

                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','1','0','0','0'},

        };

        char[][] grid2 = new char[][]{

                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},

        };

        System.out.println(new SolutionTwo().numIslands(grid));
        System.out.println(new SolutionTwo().numIslands(grid2));
    }
}
class SolutionTwo {

    int m;//length of row
    int n;//length of col
    boolean[][] boo;//if or not be used

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int result = 0;
        boo = new boolean[m][n];
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col]=='1'&&boo[row][col]==false){
                    dfs(grid, row, col);
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int row, int col){
        if(row<0||row>m-1||col<0||col>n-1) return;
        if(grid[row][col]=='0'||boo[row][col]==true) return;
        if(grid[row][col]=='1'){
            boo[row][col] = true;
            dfs(grid, row + 1, col);
            dfs(grid, row - 1, col);
            dfs(grid, row, col + 1);
            dfs(grid, row, col - 1);
        }
    }
}
