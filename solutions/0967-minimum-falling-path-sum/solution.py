class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        ROWS, COLS = len(matrix), len(matrix[0])
        cache = {}

        def helper(r, c):
            # Fuera de los límites
            if c < 0 or c >= COLS:
                return float("inf")

            # Última fila
            if r == ROWS - 1:
                return matrix[r][c]

            if (r, c) not in cache:
                down = helper(r + 1, c)
                diagLeft = helper(r + 1, c - 1)
                diagRight = helper(r + 1, c + 1)

                cache[(r, c)] = matrix[r][c] + min(
                    down,
                    diagLeft,
                    diagRight
                )

            return cache[(r, c)]

        return min(helper(0, c) for c in range(COLS))
