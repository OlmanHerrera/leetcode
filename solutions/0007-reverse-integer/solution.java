class Solution {
    public int reverse(int x) {
        int resultado = 0;
        
        while (x != 0) {
            int ultimoDigito = x % 10;
            x /= 10;
            
            // 1. Controlar desbordamiento positivo (Integer.MAX_VALUE = 2147483647)
            if (resultado > Integer.MAX_VALUE / 10 || 
               (resultado == Integer.MAX_VALUE / 10 && ultimoDigito > 7)) {
                return 0;
            }
            
            // 2. Controlar desbordamiento negativo (Integer.MIN_VALUE = -2147483648)
            if (resultado < Integer.MIN_VALUE / 10 || 
               (resultado == Integer.MIN_VALUE / 10 && ultimoDigito < -8)) {
                return 0;
            }
            
            // Multiplicar y sumar el dígito de forma segura
            resultado = (resultado * 10) + ultimoDigito;
        }
        return resultado;
    }
}
