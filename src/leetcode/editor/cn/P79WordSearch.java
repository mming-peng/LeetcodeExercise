//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 662 👎 0


package leetcode.editor.cn;

//单词搜索

public class P79WordSearch {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P79WordSearch().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            int rows = board.length, cols = board[0].length;
            boolean[][] visited = new boolean[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    boolean flag = check(board, visited, i, j, word, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
            if (board[i][j] != word.charAt(k)) {
                return false;
            } else if (k == word.length() - 1) {
                return true;
            }
            visited[i][j] = true;
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            boolean result = false;
            for (int[] dir : directions) {
                int newI = i + dir[0], newJ = j + dir[1];
                if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
                    if (!visited[newI][newJ]) {
                        boolean flag = check(board, visited, newI, newJ, word, k + 1);
                        if (flag) {
                            result = true;
                            break;
                        }
                    }
                }
            }
            visited[i][j] = false;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}