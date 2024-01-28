import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle2Application {
    public static void main(String[] args) {
        try {
            int sum = 0;
            File input = new File("src/input.txt");
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();

                // For each line in data give me just numbers
                char[] chars = data.toCharArray();
                StringBuilder stringBuilder = new StringBuilder();

                for(int i = 0; chars.length > i; i++){
                    for(String number : new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}){
                        if(data.startsWith(number, i)){
                            // convert that to number and apend to stingBuilder
                            stringBuilder.append(convertToInt(number));
                        }
                    }
                    if(Character.isDigit(chars[i])){
                        stringBuilder.append(chars[i]);
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

    private static int convertToInt(String number) {
        return switch (number) {
            case "one" -> 1;
            case "two" -> 2;
            case "three" -> 3;
            case "four" -> 4;
            case "five" -> 5;
            case "six" -> 6;
            case "seven" -> 7;
            case "eight" -> 8;
            case "nine" -> 9;
            default -> 0;
        };
    }
}