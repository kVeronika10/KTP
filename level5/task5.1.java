import java.util.Arrays;
import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert the string: ");
        String string=in.nextLine();
        System.out.println(Arrays.toString(encrypt(string)));
        System.out.print("Insert amount of elements for the array: ");
        int amount=in.nextInt();
        int[] array=new int [amount];
        for (int i=0;i<amount;i++) {
            System.out.print("Insert the " + i + "st element ");
            array[i] = in.nextInt();
        }
        System.out.println(decrypt(array));
    }

    private static int[] encrypt(String string)
    {
        int[] array = new int[string.length()];
        array[0] = string.charAt(0);

        for(int i = 1; i < string.length(); i++)
        {
            array[i] = (string.charAt(i) - string.charAt(i-1));
        }
        return array;
    }
    private static String decrypt(int[] array)
    {
        String stringRezult = "";
        stringRezult += (char) array[0];

        for(int i = 1; i < array.length; i++)
        {
            int cymbol = stringRezult.charAt(i-1);
            stringRezult += (char) (cymbol + array[i]);
        }
        return stringRezult;
    }
}