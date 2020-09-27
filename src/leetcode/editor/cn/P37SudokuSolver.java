//编写一个程序，通过填充空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// 提示： 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 649 👎 0


package leetcode.editor.cn;

//解数独

import java.util.ArrayList;
import java.util.List;

public class P37SudokuSolver{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P37SudokuSolver().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	private boolean[][] line = new boolean[9][9];
	private boolean[][] column = new boolean[9][9];
	private boolean[][][] block = new boolean[3][3][9];
	private boolean valid = false;
	private List<int[]> spaces = new ArrayList<int[]>();

	public void solveSudoku(char[][] board) {
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				if (board[i][j] == '.') {
					spaces.add(new int[]{i, j});
				} else {
					int digit = board[i][j] - '0' - 1;
					line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
				}
			}
		}

		dfs(board, 0);
	}

	public void dfs(char[][] board, int pos) {
		if (pos == spaces.size()) {
			valid = true;
			return;
		}

		int[] space = spaces.get(pos);
		int i = space[0], j = space[1];
		for (int digit = 0; digit < 9 && !valid; ++digit) {
			if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
				line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
				board[i][j] = (char) (digit + '0' + 1);
				dfs(board, pos + 1);
				line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
			}
		}
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}