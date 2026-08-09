class Solution:
    def findMaxForm(self, strs: List[str], M: int, N: int) -> int:
        dp = defaultdict(int)


        for i in range(len(strs)):
            s = strs[i]
            mCnt , nCnt  = s.count("0"), s.count("1")

            for m in range(M+1):
                for n in range(N+1):
                    if mCnt <= m and nCnt <= n:
                        dp[(i,m,n)] = max(1+ dp[(i-1, m-mCnt, n -nCnt)], dp[i-1, m,n])
                    else:
                        dp[(i,m,n)] = dp[(i-1, m,n)]
        return dp[(len(strs)-1, M,N)]
