package org.example;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //create a copy of the given array
        int[] sort = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sort[i] = nums[i];
        }
        //create a priority queue to sort the array
        HashMap<Integer, Integer> map = getIntegerIntegerHashMap(sort);
        //modify the created array changing the values to the correct rankings
        for (int i = 0; i < nums.length; i++) {
            sort[i] = nums.length - (map.get(nums[i]) + 1);
        }
        return sort;
    }

    private static HashMap<Integer, Integer> getIntegerIntegerHashMap(int[] sort) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        //add integer to the priority queue
        for (int num : sort) {
            pq.offer(num);
        }
        //create a hashmap to map integers to their rankings
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        //map integers to their rankings
        while(!pq.isEmpty()) {
            map.put(pq.remove(), count++);
        }
        return map;
    }
}
