class Solution(object):
    __dp__ = {}
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        if (m,n) in Solution.__dp__:
            return Solution.__dp__[(m,n)]
        if m == 1 or n == 1:
            return 1 
        else:
            Solution.__dp__[(m,n)] = self.uniquePaths(m,n-1) + self.uniquePaths(m-1,n)
            return Solution.__dp__[(m,n)]


            

    
    
    
