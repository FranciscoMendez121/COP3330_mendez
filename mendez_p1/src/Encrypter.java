import java.util.Scanner;

public class Encrypter {
    //Creating a method that will swap the positions of the integers
    public static void Swapper(int array[]){
        //Swapping the first and third positions.
        int temporary = array[0];
        array[0] = array[2];
        array[2] = temporary;
        //After swapping the first and third positions, i will swap the second and fourth.
        temporary = array[1];
        array[1] = array[3];
        array[3] = temporary;

        //Because it is a void function, it will not return any value, only swapping is wanted here.
    }

    //This method creates a String by converting the array values into a string.
    public static String arrayConverter(int array[]){

        int newNum = 0;
        int k;
        for(k = 0; k < 4;k++) {
            newNum = newNum * 10 + array[k];
        }
        //This is a built in function that converts the integer into a string.
        String out = Integer.toString(newNum);
        //The process above does not account for "0" values in the first position, thus I am accounting for that in this if statement.
        if(array[0] == 0)
            out = "0" + out;
        return out;
    }

    public static String encrypt(String num) {
        //Initializing the array
        int[] array = new int[4];
        int i;
        //initialize the numbers and store the values into the created array
        for(i = 0; i < 4;i++) {
            char c = num.charAt(i);
            array[i] = Character.getNumericValue(c);
        }

        //Here I am actually encrypting the numbers using the math expressions.
        for(int j = 0; j < 4; j++) {
            int temp = array[j];
            temp = temp + 7;
            temp = temp % 10;
            array[j] = temp;
        }

        //Here I am calling the swapper method to swap the integers.
        Swapper(array);

        //Here I am returning the String that I had created using the arrayConverter function.
        return arrayConverter(array);
    }


    public static void main(String[] args){
        //Here I am scanning the input from the user using the Scanner "scan"
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter a four digit number: ");
        //storing the scanned value into the String num
        String num = scan.nextLine();
        //Calling the method encrypt which will then call the two "helper" functions.
        String encryptedNumber = encrypt(num);
        System.out.println("The encrypted number is: "+encryptedNumber);
    }
}
