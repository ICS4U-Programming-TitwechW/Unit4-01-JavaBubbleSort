import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
* Program return the result of the base.
*
* @author Titwech Wal
* @version 1.0
* @since   2023-06-08
*/

public final class BubbleSort {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private BubbleSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {

        // Pass path to file as parameter.
        final File input = new File("input.txt");

        // Pass path to file as parameter.
        final File output = new File("output.txt");

        // Create a list of strings.
        final List<String> listOfStrings =
            new ArrayList<String>();

        // Declare variable
        String inputStr;

        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(output);

            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(input);

            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {
                // Read line as string.
                inputStr = sc.nextLine();

                // Add into list.
                listOfStrings.add(inputStr);

            }

            // Convert from list to array.
            final String[] arrayOfStrings =
                listOfStrings.toArray(new String[0]);

            // Convert all elements in array to integers.
            // To do this, loop through each element & convert
            // each string.
            // Convert all elements in array to integers.
            final String[] arrayOfStr = listOfStrings.toArray(new String[0]);

            // Convert all elements in array to integers.
            for (int counter = 0; counter < arrayOfStr.length; counter++) {
                try {

                    final String[] inputNum = arrayOfStr[counter].split(" ");

                    final int[] arrayNum = new int[inputNum.length];

                    for (int counter2 = 0; counter2 < inputNum.length;
                        counter2++) {
                        arrayNum[counter2] =
                            Integer.parseInt(inputNum[counter2]);

                    }
                    // Call function.
                    final int[] bubSort = sortBubble(arrayNum);

                    // Display & write to file.
                    System.out.println(Arrays.toString(bubSort));
                    write.println(Arrays.toString(bubSort));

                } catch (NumberFormatException error) {
                    // Write error in file.
                    write.println("Only valid input:)");
                    System.out.println("Only valid input:)");
                    continue;
                }

            }
            // Closes scanner & writer.
            write.close();
            sc.close();

        } catch (IOException error) {
            System.out.println("An error occurred: "
                + error.getMessage());
        }
    }

    /**
    * This function uses recursion to
    * find the search of number.
    *
    * @param listNum passed
    * @return listNum.
    */
    public static int[] sortBubble(int[] listNum) {
        // This loop will access each element in array.
        for (int counter1 = 0; counter1 < listNum.length - 1;
                counter1++) {
            for (int counter2 = 0; counter2 < listNum.length - counter1 - 1;
                    counter2++) {
                // Check the elements, store them into temp variable.
                if (listNum[counter2] > listNum[counter2 + 1]) {
                    // Declare variable.
                    final int temp = listNum[counter2];
                    // Setting value equal to the temp variable.
                    listNum[counter2] = listNum[counter2 + 1];
                    listNum[counter2 + 1] = temp;
                }
            }
        }
        // Return to main.
        return listNum;
    }
}
