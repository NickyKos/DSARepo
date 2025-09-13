//import java.util.*;
/*
 * IT-2660 - Lab 1
 * Nick Kostura: 
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("hello, world!");

        Lab1 lab = new Lab1();
        System.out.println(lab.increment(1));

        // Create array
        int[] nums = {5, 9, 3, 12, 7, 3, 11, 5};

        // Output array in order using while loop
        System.out.print("Array in order: ");
        int i = 0;
        while (i < nums.length) {
            System.out.print(nums[i] + " ");
            i++;
        }
        System.out.println();

        // Output array in reverse using for loop
        System.out.print("Array in reverse: ");
        for (int j = nums.length - 1; j >= 0; j--) {
            System.out.print(nums[j] + " ");
        }
        System.out.println();

        // Output first and last values
        System.out.println("First value: " + nums[0]);
        System.out.println("Last value: " + nums[nums.length - 1]);

        // Call Lab1 methods
        System.out.println("Max of 5 and 9: " + lab.max(5, 9));
        System.out.println("Min of 5 and 9: " + lab.min(5, 9));
        System.out.println("Sum of array: " + lab.sum(nums));
        System.out.println("Average of array: " + lab.average(nums));
        System.out.println("Max of array: " + lab.max(nums));
        System.out.println("Min of array: " + lab.min(nums));
    }
}

class Lab1 {

    // Increment method
    public int increment(int num) {
        return ++num;
    }

    // Return max of two integers
    public int max(int a, int b) {
        if (a > b) return a;
        else return b;
    }

    // Return min of two integers
    public int min(int a, int b) {
        if (a < b) return a;
        else return b;
    }

    // Return sum of array
    public int sum(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        return total;
    }

    // Return average of array
    public double average(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        return (double) total / nums.length;
    }

    // Return max of array
    public int max(int[] nums) {
        int max = nums[0];
        for (int n : nums) {
            if (n > max) max = n;
        }
        return max;
    }

    // Return min of array
    public int min(int[] nums) {
        int min = nums[0];
        for (int n : nums) {
            if (n < min) min = n;
        }
        return min;
    }
}
