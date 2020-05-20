import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert your essay: ");
        String string=in.nextLine();
        System.out.print("Insert N: ");
        int N=in.nextInt();
        System.out.print("Insert K: ");
        int K=in.nextInt();
        System.out.print("formatted essay: \n"+essay(N,K,string));
    }

    public static String essay(int N,int K,String str)
    {
        String temp="";
        String rezult="";
        String word;
        String[] words=str.split(" ");
        for (int i=0;i<words.length;i++)
        {
            word=words[i];
            if ((temp.replace(" ","").length()+word.length())<=K)
                temp+=(word+" ");
            else
            {
                rezult+=temp+"\n";
                temp=(word+" ");
            }
        }
        if (temp.length()>0)
        {
            rezult+=temp+"\n";
        }
        return rezult;
    }
}