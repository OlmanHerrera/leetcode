class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] estado = new int[n];
        List<Integer> seguros = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (esSeguro(i, graph, estado)) {
                seguros.add(i);
            }
        }
        return seguros;
    }

    private boolean esSeguro(int nodo, int[][] graph, int[] estado) {
        if (estado[nodo] != 0) return estado[nodo] == 2;

        estado[nodo] = 1;
        for (int vecino : graph[nodo]) {
            if (!esSeguro(vecino, graph, estado)) return false;
        }
        estado[nodo] = 2;
        return true;
    }
}
        
        

