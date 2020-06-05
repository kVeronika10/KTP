import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert the number: ");
        int number=in.nextInt();
        System.out.print("Rezult: "+bell(number));
    }

    public static int bell(int n)
    {
        int[][] array = new int[n+1][n+1];
        array[0][0] = 1;

        for (int i=1; i<=n; i++)
        {
            array[i][0] = array[i-1][i-1];

            for (int j=1; j<=i; j++)
                array[i][j] = array[i-1][j-1] + array[i][j-1];
        }
        return array[n][0];
    }
}