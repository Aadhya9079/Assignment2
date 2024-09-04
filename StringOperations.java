/***
 * Problem Statement : When the program is run, the user will first enter a string.
   After that, the program should ask the user which operation they want to execute on the string.
   The available operations are listed below: Append, CountWords, Replace, isPalindrome, Splice, Split,
   MaxRepeatingCharacter, Sort, Shift, and Reverse. Each method should perform its respective operation based on the user's input.
 * Owner-Name : Aadhya Goyal
 * Date of Creation : 04-09-24
 */

import java.util.*;

public class StringOperations {
    public static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        s = scanner.nextLine();

        while (true) {

            System.out.println("Available operations:\n * Append\n * CountWords\n * Replace\n * isPalindrome\n * Splice\n * Split\n * MaxRepeatingCharacter\n * Sort\n * Shift\n * Reverse");


            System.out.print("Which operation would you like to execute? ");
            String operation = scanner.nextLine();

            switch (operation) {
                case "Append":
                    System.out.print("Enter the string to append: ");
                    String toAppend = scanner.nextLine();
                    System.out.println("Updated string: " + appendToString(toAppend));
                    break;

                case "CountWords":
                    System.out.println("Number of words: " + countWords());
                    break;

                case "Replace":
                    System.out.print("Enter the substring to replace: ");
                    char a = scanner.next().charAt(0);
                    System.out.print("Enter the new substring: ");
                    char b = scanner.next().charAt(0);
                    System.out.println("Updated string: " + replace(a,b));
                    break;

                case "isPalindrome":
                    System.out.println("Is palindrome: " + isPalindrome());
                    break;

                case "Splice":
                    System.out.print("Enter the start index: ");
                    int start = scanner.nextInt();
                    System.out.print("Enter the end index: ");
                    int end = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Spliced string: " + spliceString(start, end));
                    break;

                case "Split":
                    String[] arr = Split();
                    for (String s : arr) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    break;

                case "MaxRepeatingCharacter":
                    System.out.println(Constant.maxRepeatingChar+ maxChar());
                    break;

                case "Sort":
                    System.out.println(Constant.sortedString + sort());
                    break;

                case "Shift":
                    System.out.println(Constant.shiftOperation);
                    System.out.println(Constant.shiftIndex);
                    int n = scanner.nextInt();
                    System.out.println(shift(n));
                    break;

                case "Reverse":
                    System.out.println("Reversed string is: " + Reverse());
                    break;

                default:
                    System.out.println("Invalid operation. Please choose from the list.");
                    break;
            }

            System.out.print("Do you want to perform another operation? (yes/no): ");
            String cont = scanner.nextLine().trim().toLowerCase();
            if (!cont.equals("yes")) {
                break;
            }
        }
        scanner.close();
    }


    public static String appendToString(String toAppend) {
        s += toAppend;
        return s;

    }

    public static int countWords() {
        int count = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            if ((s.charAt(i) == ' ') && (s.charAt(i - 1) != ' ')) {
                count++;
            }
        }
        return count;
    }

        public static String replace(char a , char b){
            char[] arr = new char[s.length()];
            for(int i = 0 ;i<arr.length;i++){
                arr[i] = s.charAt(i);
            }
            for(int i = 0;i<arr.length;i++){
                if(arr[i]==a){
                    arr[i] = b;
                }
            }
            return new String(arr);
        }


    public static boolean isPalindrome() {
        String a ="";
        for(int i = s.length()-1;i>=0;i--){
            a = a + s.charAt(i);
        }
        return a.equals(s);
    }

    public static String spliceString(int start , int length){
        if (start < 0 || start >= s.length() || start + length > s.length()) {
            return Constant.InvalidInput;
        }
        char[] arr = new char[s.length()- length];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < start || i >= start + length) {
                arr[index++] = s.charAt(i);
            }
        }

        return new String(arr);
    }

    public static String[] Split(){
        String temp = s;
        String[] words = new String[countWords()];
        temp = " "+temp+" ";
        int index = 0;
        for(int i = 0;i<temp.length()-1;i++){
            for(int j = i+1;j<temp.length();j++){
                if(temp.charAt(i)==' ' && temp.charAt(j)==' ' && temp.charAt(i+1) != ' '){
                    words[index++] = temp.substring(i,j);
                    i = j;
                }
            }
        }
        return words;
    }


    public static String maxChar(){
        char[] arr = new char[s.length()];
        for(int i = 0;i<arr.length;i++){
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr);
        char temp = ' ';
        int count = 1;
        int maxCount = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i+1]) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    temp = arr[i];
                }
                count = 1;
            }
        }


        if (count > maxCount) {
            maxCount = count;
            temp = arr[arr.length - 1];
        }

        return temp + " -> " + maxCount;
    }

    public static String sort(){
        char[] arr = new char[s.length()];
        for(int i = 0;i<s.length();i++){
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr);
        return new String(arr) ;
    }

    public static String shift(int n){
        n= n % s.length();
        char[] arr = new char[s.length()];
        int index = 0;
        for(int i = s.length() - n;i<s.length();i++ ){
            arr[index++] = s.charAt(i);
        }
        for(int i = 0; i < s.length() - n ; i++){
            arr[index++] = s.charAt(i);
        }
        return new String(arr);
    }

    public static String Reverse(){
        String a = "";
        for(int i = s.length()-1;i>=0;i--){
            a = a + s.charAt(i);
        }
        return a;
    }
}

