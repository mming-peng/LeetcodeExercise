//给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。 
//
// 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。 
//
// 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿
//的周长。 
//
// 
//
// 示例 : 
//
// 输入:
//[[0,1,0,0],
// [1,1,1,0],
// [0,1,0,0],
// [1,1,0,0]]
//
//输出: 16
//
//解释: 它的周长是下面图片中的 16 个黄色的边：
//
//
// 
// Related Topics 哈希表 
// 👍 311 👎 0


package leetcode.editor.cn;

//岛屿的周长

public class P463IslandPerimeter {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P463IslandPerimeter().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int islandPerimeter(int[][] grid) {
            if (grid == null) {
                return 0;
            }
            int m = grid.length, n = grid[0].length;
            int counts = 0, edges = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        continue;
                    }
                    ++counts;
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        edges++;
                    }
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        edges++;
                    }
                }
            }
            return 4 * counts - 2 * edges;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}