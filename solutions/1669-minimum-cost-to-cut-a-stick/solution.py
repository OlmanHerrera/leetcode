class Solution:
    def minCost(self, n: int, cuts: list[int]) -> int:
        dp = {}
        
        def helper(l, r):
            if (l, r) in dp:
                return dp[(l, r)]
            res = float("inf")
            for c in cuts:
                if l < c < r:
                    res = min(res, (r - l) + helper(l, c) + helper(c, r))
            dp[(l, r)] = 0 if res == float("inf") else res
            return dp[(l, r)]

        return helper(0, n)
