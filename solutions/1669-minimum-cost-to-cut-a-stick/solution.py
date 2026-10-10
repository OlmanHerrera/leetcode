class Solution:
    def minCost(self, n: int, cuts: list[int]) -> int:
        dp = {}
        costos_t = sorted([0]+ cuts+ [n])
        
        def helper(l, r):
            if (l, r) in dp:
                return dp[(l, r)]
            res = float("inf")
            for c in range(l+1, r):
                costo_tramo = costos_t[r]- costos_t[l]
                res = min(res, costo_tramo + helper(l, c) + helper(c, r))
            dp[(l, r)] = 0 if res == float("inf") else res
            return dp[(l, r)]

        return helper(0, len(costos_t)-1)
