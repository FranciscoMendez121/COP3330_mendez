import java.util.Scanner;

public class Decrypter {
    //This method will swap the integer values from the user
    public static void Swapper(int array[]){
        //Swapping the first and third integers
        int temporary = array[0];
        array[0] = array[2];
        array[2] = temporary;

        //Swapping the second and fourth integers
        temporary = array[1];
        array[1] = array[3];
        array[3] = temporary;
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

    //This method will actually decrypt the values from the user and will also call the "helper functions"
    public static String decrypt(String number) {
        //Creating an array
        int[] array = new int[4];
        //I am using the function ".charAt()" which returns the character value at the given index number.
        //I am also filling the array with values to initialize the array.
        for (int i = 0; i < 4; i++) {
            char tempCh = number.charAt(i);
            array[i] = Character.getNumericValue(tempCh);
        }
        //Here I am calling the swapper function to swap the positions of the integers within the array.
        Swapper(array);

        //Here I am actually "decrypting" The numbers
        //I chose to do it using a switch case function because it is easier for me to do it in my head and just
        //check each case and manually switch the numbers than coming up with a mathematical representation
        for(int i = 0; i < 4; i++){

            int integer = array[i];

            switch(integer){
                case 0:
                    array[i] = 3;
                    break;
                case 1:
                    array[i] = 4;
                    break;
                case 2:
                    array[i] = 5;
                    break;
                case 3:
                    array[i] = 6;
                    break;
                case 4:
                    array[i] = 7;
                    break;
                case 5:
                    array[i] = 8;
                    break;
                case 6:
                    array[i] = 9;
                    break;
                case 7:
                    array[i] = 0;
                    break;
                case 8:
                    array[i] = 1;
                    break;
                case 9:
                    array[i] = 2;
                    break;
            }
        }

        //Here I am returning the value from calling the function "arrayConverter"
        return arrayConverter(array);
    }

        public static void main(String[] args){

            //calling the decrypt method which will call the other "helper functions" as well. It will fully decrypt the user input
            String decryptedNumber = Decrypter.decrypt("0189"); //My test code
            System.out.println(""+decryptedNumber); //My tested output

        }
    }
