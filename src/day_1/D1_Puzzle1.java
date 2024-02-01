package day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D1_Puzzle1 {
    public static void main(String[] args) {
        try {
            int sum = 0;
            File input = new File("/src/day_1/input.txt");
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();

                // For each line in data give me just numbers
                char[] chars = data.toCharArray();
                StringBuilder stringBuilder = new StringBuilder();
                for(char singleChar : chars){
                    if(Character.isDigit(singleChar)){
                        stringBuilder.append(singleChar);
                    }
                }

                // From stringBuilder each line, give me 1st and last
                char first = stringBuilder.charAt(0);
                char last = stringBuilder.charAt(stringBuilder.length() - 1);

                // Take first and last - make a couple - 2 digit values
                String firstAndLast = String.valueOf(first) + last;

                // Total sum of first and last
                sum += Integer.parseInt(firstAndLast);
            }
            // Print total sum of first and last
            System.out.println(sum);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}