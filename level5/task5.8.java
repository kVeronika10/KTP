package app.sass;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

class Scratch {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner in = new Scanner(System.in);
        System.out.print("Insert the string: ");
        String string = in.nextLine();
        System.out.print("Rezult of hashing: "+getSha256Hash(string));
        
    }

    private static String getSha256Hash(String string) throws NoSuchAlgorithmException
    {
        MessageDigest helper = MessageDigest.getInstance("SHA-256");
        byte[] hash = helper.digest(string.getBytes(StandardCharsets.UTF_8));
        StringBuilder newString = new StringBuilder();
        for(byte temp : hash)
            newString.append(String.format("%02x",temp));
        return newString.toString();
    }
}