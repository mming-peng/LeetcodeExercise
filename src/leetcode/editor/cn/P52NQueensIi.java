//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N
//-1 步，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 149 👎 0


package leetcode.editor.cn;

//N皇后 II

import java.util.*;

public class P52NQueensIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P52NQueensIi().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	private int ans = 0;
    public int totalNQueens(int n) {
		int[] queens = new int[n];
		Arrays.fill(queens,-1);

		Set<Integer> columns = new HashSet<>();
		Set<Integer> diagonals1 = new HashSet<>();
		Set<Integer> diagonals2 = new HashSet<>();

		backtack(queens,n,0,columns,diagonals1,diagonals2);
    	return ans;

    }
	private void backtack(int[] queens, int n, int row,Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
		if(row == n){
			this.ans++;
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
				backtack(queens,n,row+1,columns,diagonals1,diagonals2);
				queens[row] = -1;
				columns.remove(i);
				diagonals1.remove(diagonal1);
				diagonals2.remove(diagonal2);
			}
		}

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}