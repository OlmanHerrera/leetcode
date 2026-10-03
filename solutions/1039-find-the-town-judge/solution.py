class Solution:
    def findJudge(self, n: int, trust: list[list[int]]) -> int:
        score = [0] * (n + 1)
        for a, b in trust:
            score[a] -= 1   # a confía en alguien: deja de ser candidato
            score[b] += 1   # b recibe un voto
        for i in range(1, n + 1):
            if score[i] == n - 1:
                return i
        return -1
