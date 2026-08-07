import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;



class Solution {
    public int deleteAndEarn(int[] nums) {

        int earn1;
        int earn2;
        Map<Integer,Integer> contador = new HashMap<>();
        Set<Integer> sortedSet = new TreeSet<>(); 

        for(int number: nums){
            sortedSet.add(number);
        }
        int[] sortedNums = sortedSet.stream().mapToInt(Integer::intValue).toArray();
        for(int number : nums){
            contador.put(number, contador.getOrDefault(number, 0)+1);
        }

        earn1 = earn2 = 0;
        int temp;
        for (int i = 0; i < sortedNums.length; i++ ){
            int current = sortedNums[i] * contador.get(sortedNums[i]);

            if (i > 0 &&  sortedNums[i] == sortedNums[i-1]+1){
                temp = earn2;
                earn2 = Math.max(earn1+ current,earn2 );
                earn1 = temp;
            }
            else{
                temp = earn2;
                earn2 = current + earn2;
                earn1 = temp;
            }
        }
        return earn2;
    }
}
