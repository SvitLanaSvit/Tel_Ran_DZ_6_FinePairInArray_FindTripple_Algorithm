package task2_find_tree;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 10, 20, 30, 35, 50, 55, 70};
        int x = 40;
        //variant_1 Time complexity: O(n^2)
        System.out.println(hasTriplet(arr, x));
        //variant_2 Time complexity: O(n^2)
        System.out.println(hasTripletWithMap(arr, x));
    }

    //var_1---------------------------------------------
    private static boolean hasTriplet(int[]arr, int x){
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == x){
                    return true;
                }
                else if(sum < x){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return false;
    }
    //--------------------------------------------------
    //var_2---------------------------------------------
    private static boolean hasTripletWithMap(int[] arr, int x){
        int n = arr.length;

        // Store the count of each element in the map
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 1));
        }

        // Check for triplet
        for (int i = 0; i < n; i++) {
            int target = x - arr[i];
            for (int j = i + 1; j < n; j++) {
                int diff = target - arr[j];
                if(map.containsKey(diff) && map.get(diff) > ((diff == arr[i]) ? 1 : 0) + ((diff == arr[j]) ? 1 : 0)){
                    return true;
                }
            }
        }
        return false;
    }
}
