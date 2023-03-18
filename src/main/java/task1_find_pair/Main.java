package task1_find_pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //variant_1 Time complexity: O(n lon n)!!! not good
        int[] arr = {10, 20, 20, 35, 50, 75, 80};
        int x = 55;
        int[] res1 = findPair(arr, x);
        if (res1 != null) {
            System.out.println("Pair found: " + res1[0] + ", " + res1[1]);
        } else {
            System.out.println("Pair not found");
        }

        //variant_2 Time complexity: O(n)
        int[] res2 = findPairWithMap(arr, x);
        if (res2 != null) {
            System.out.println("Pair found: " + res2[0] + ", " + res2[1]);
        } else {
            System.out.println("Pair not found");
        }

        //variant_3 Time complexity: O(n)
        int[] res3 = findPairWithSet(arr, x);
        if (res3 != null) {
            System.out.println("Pair found: " + res3[0] + ", " + res3[1]);
        } else {
            System.out.println("Pair not found");
        }
    }

    //var_1---------------------------------------------
    private static int[] findPair(int[] arr, int x){
        int mid = x/2;
        int idx = Arrays.binarySearch(arr, findValue(arr, mid));
        //System.out.println(idx);
        if(idx < 0){
            idx = -(idx + 1);
        }
        int left = idx;
        int right = idx + 1;
        //System.out.println("left: " + left + "; right:" + right);
        while(left >= 0 && right < arr.length){
            int sum = arr[left] + arr[right];
            if(sum == x){
                return new int[]{arr[left], arr[right]};
            }
            else if(sum > x){
                left--;
            }
            else {
                right++;
            }
        }

        return null;
    }
    private static int findValue(int[] arr, int val){
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] < val){
                index = mid;
                left = mid + 1;
            }
            else if(arr[mid] == val){
                index = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        if (index == -1) {
            return -1; // no value found
        } else {
            return arr[index];
        }
    }
    //--------------------------------------------------

    //var_2---------------------------------------------
    //Used HashMap:
    private static int[] findPairWithMap(int[] arr, int x){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = x - arr[i];
            if(map.containsKey(complement)){
                return  new int[]{complement, arr[i]};
            }
            map.put(arr[i], i);
        }
        return null;
    }
    //--------------------------------------------------

    //var_3---------------------------------------------
    //Used HashSet
    private static int[] findPairWithSet(int[] arr, int x){
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            int complement = x - j;
            if (set.contains(complement)) {
                return new int[]{complement, j};
            }
            set.add(j);
        }
        return null;
    }
}
