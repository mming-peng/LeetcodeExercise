//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 615 👎 0


package leetcode.editor.cn;

//N 皇后

import java.util.*;

public class P51NQueens{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P51NQueens().new Solution();
	 	 solution.solveNQueens(4);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
		List<List<String>> solutions = new ArrayList<>();
		int[] queens = new int[n];
		Arrays.fill(queens,-1);

		Set<Integer> columns = new HashSet<>();
		Set<Integer> diagonals1 = new HashSet<>();
		Set<Integer> diagonals2 = new HashSet<>();

		backtack(solutions,queens,n,0,columns,diagonals1,diagonals2);
		return solutions;
     }

	private void backtack(List<List<String>> solutions, int[] queens, int n, int row,Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
		if(row == n){
			List<String> board = generateboard(queens,n);
			solutions.add(board);
		}else{
			for(int i = 0;i < n;i++){
				if(columns.contains(i)){
					continue;
				}
				int diagonal1 = row - i;
				if(diagonals1.contains(diagonal1)){
					continue;
				}
				int diagonal2 = row + i;
				if(diagonals2.contains(diagonal2)){
					continue;
				}

				queens[row] = i;
				columns.add(i);
				diagonals1.add(diagonal1);
				diagonals2.add(diagonal2);
				backtack(solutions,queens,n,row+1,columns,diagonals1,diagonals2);
				queens[row] = -1;
				columns.remove(i);
				diagonals1.remove(diagonal1);
				diagonals2.remove(diagonal2);
			}
		}

    }

	private List<String> generateboard(int[] queens, int n) {
		List<String> board = new ArrayList<>();
		for(int i = 0;i < n;i++){
			char[] row = new char[n];
			Arrays.fill(row,'.');
			row[queens[i]] = 'Q';
			board.add(new String(row));
		}
		return board;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}