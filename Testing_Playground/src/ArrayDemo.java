import java.util.*;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] nums = new int[6];
        nums[1] = 45;
        System.out.println("nums array: " + nums.length);
        nums[nums.length - 1] = 100;
        nums[0] = nums[1] + nums[nums.length-1];

        //copying to a new bigger array
        int[] nums2 = new int[20];
        System.out.print("nums2 content: ");
        for(int i = 0; i < nums.length; i++){
            nums2[i] = nums[i];
            System.out.print(nums2[i] + " ");
        }

        System.out.println();

        /**
         * another way to print an array that i wish i learned sooner
         * don't forget to import Arrays or just do "java.util.*" 
         */
        System.out.println(Arrays.toString(nums2));


        //array of presons size 3
        Person[] persons = new Person[3];

        //first element of persons toPerson object with name "Kate and age 20
        persons[0] = new Person("Kate", 20);
        for(int i = 0; i < persons.length; i++)
            System.out.println(persons[i]);

        persons[persons.length - 1] = new Person(persons[0].getName(), persons[0].getAge());
        
    }
}
