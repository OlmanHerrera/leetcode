class Solution:
    def minPathSum(self, grid: list[list[int]]) -> int:
        cols =  len(grid[0])
        rows = len(grid)
        dp = [float("inf")]*(cols+1)
        dp[cols-1] = 0
        for r in range(rows-1, -1,-1 ):
            for c in range(cols-1, -1,-1):
                dp[c] =grid[r][c] + min(dp[c+1], dp[c])
        return dp[0]

