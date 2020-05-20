package com.company;
import java.util.Scanner;
class Scratch {
    public static void main(String[] args) {
        System.out.print("Insert string camel: ");
        Scanner in=new Scanner(System.in);
        String camel=in.nextLine();
        System.out.print("Insert string snake: ");
        String snake=in.nextLine();
        System.out.println("The snake case: "+ toSnakeCase(camel));
        System.out.println("The camel case: "+ toCamelCase(snake));
    }

    public static StringBuilder toSnakeCase(String str)
    {
        StringBuilder newString= new StringBuilder();
        for (int i=0;i<str.length()-1;i++)
        {
            String nextChar = str.substring(i,i+1);
            if(Character.isUpperCase(str.charAt(i+1)))
            {
                newString.append(str.charAt(i));
                newString.append('_');
            }
            else
                if (Character.isUpperCase(str.charAt(i))) {
                nextChar=nextChar.toLowerCase();
                newString.append(nextChar);
                }
                else
                    newString.append(str.charAt(i));
        }
        newString.append(str.charAt(str.length()-1));
        return newString;
    }

    public static StringBuilder toCamelCase(String str)
    {
        StringBuilder camelString=new StringBuilder();
        boolean flag=false;
        for (int i=0;i<str.length()-1;i++) {
            String temp = str.substring(i+1,i+2);
            if (str.charAt(i) == '_') {
                temp=temp.toUpperCase();
                camelString.append(temp);
                flag=true;
            }
            else if (flag) {
                flag=false;
                continue;
            }
            else
                camelString.append(str.charAt(i));
        }
        camelString.append(str.charAt(str.length()-1));
        return camelString;
    }
}