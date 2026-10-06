
import java.util.*;
public class Solution{
    public int minMutation(String startGene, String endGene, String[] bank){
        Set<String> valid = new HashSet<>(Arrays.asList(bank));
        if (!valid.contains(endGene)) return -1;

        Queue<String> cola = new LinkedList<>();
        Set<String> visitados = new HashSet<>();
        cola.add(startGene);
        visitados.add(startGene);
        int pasos = 0;
        while (!cola.isEmpty()){
            int size = cola.size();
            for (int i =0; i< size; i++){
                String actual = cola.poll();
                if (actual.equals(endGene)) return pasos;

                for (String gen:bank){
                    if (!visitados.contains(gen) && difiereEnUno(actual, gen)){
                        visitados.add(gen);
                        cola.add(gen);
                    }
                }
            }
            pasos++;
        }
        return -1;
    }

    public boolean difiereEnUno(String a, String b){
        int dif = 0;
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i) != b.charAt(i)){
                dif++;
            }
        }
        return dif == 1; 
    }
}
