import math
class Solution:

    def fib_aux(self,n, arr):
        if arr[n] >= 0:
            return arr[n]
        if n <= 1:
            return n
        v = self.fib_aux(n-1, arr) + self.fib_aux(n-2,arr)
        arr[n] = v 
        return v
    def fib(self, n: int) -> int:
        dp = [-1 * math.inf for i in range(n+1)]
        return self.fib_aux(n,dp)

    
        
