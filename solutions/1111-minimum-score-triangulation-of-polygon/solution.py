from functools import cache

class Solution:
    def minScoreTriangulation(self, values: list[int]) -> int:
        @cache
        def helper(l, r):
            if r - l < 2:
                return 0
            return min(
                helper(l, k) + helper(k, r) + values[l] * values[k] * values[r]
                for k in range(l + 1, r)
            )

        return helper(0, len(values) - 1)
