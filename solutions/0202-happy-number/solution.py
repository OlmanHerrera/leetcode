class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """

        def sum_square(num):
            suma = 0
            while num > 0:
                digito = num % 10
                suma += digito * digito
                num //= 10
            return suma

        def helper(num, visited):
            if num == 1:
                return True
            if num in visited:
                return False
            visited.add(num)
            return helper(sum_square(num), visited)

        return helper(n, set())
