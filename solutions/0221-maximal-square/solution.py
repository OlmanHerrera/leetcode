class Solution:
    def maximalSquare(self, matrix: list[list[str]]) -> int:
            m, n = len(matrix), len(matrix[0])
            dp = [0] * (n + 1)          
            best = 0
            for r in range(m - 1, -1, -1):
                diag = 0                
                for c in range(n - 1, -1, -1):
                    down = dp[c]       
                    if matrix[r][c] == "1":
                        dp[c] = 1 + min(down, dp[c+1], diag)   
                        best = max(best, dp[c])
                    else:
                        dp[c] = 0
                    diag = down
            return best * best
