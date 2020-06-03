import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert the name: ");
        String name=in.nextLine();
        System.out.print("Insert the position: ");
        String position=in.nextLine();
        System.out.print("Insert the target: ");
        String target=in.nextLine();
        System.out.print(canMove(name,position,target));
    }
    public static boolean canMove(String name,String position, String target){
        char positionLetter = position.charAt(0);
        int positionDigit = Integer.parseInt(String.valueOf(position.charAt(1)));
        char targetLetter = target.charAt(0);
        int targetDigit = Integer.parseInt(String.valueOf(target.charAt(1)));

        if (positionLetter == targetLetter && positionDigit == targetDigit)
            return false;
        switch (name){
            case "Pawn":
            {
                if (positionLetter==targetLetter && positionDigit==2 && targetDigit==4) return true;
                if (positionLetter==targetLetter && positionDigit==(targetDigit-1)) return true;
                return false;
            }
            case "Knight":
            {
                if ((Math.abs(positionLetter-targetLetter)==2 && Math.abs(positionDigit-targetDigit)==1)||(Math.abs(positionLetter-targetLetter)==1 && Math.abs(positionDigit-targetDigit)==2)) return true;
                return false;
            }
            case "Bishop":
            {
                if (Math.abs(positionLetter-targetLetter)==Math.abs(positionDigit-targetDigit))return true;
                return false;
            }
            case "Rook":
            {
                if ((positionLetter==targetLetter && positionDigit!=targetDigit) || (positionLetter!=targetLetter && positionDigit==targetDigit)) return true;
                return false;
            }
            case "Queen":
            {
                if ((positionLetter==targetLetter && positionDigit!=targetDigit) || (positionLetter!=targetLetter && positionDigit==targetDigit)) return true;
                if (Math.abs(positionLetter-targetLetter)==Math.abs(positionDigit-targetDigit))return true;
                break;
            }
            case "King":
            {
                if (Math.abs(positionLetter-targetLetter)<2 && Math.abs(positionDigit-targetDigit)<2) return true;
                return false;
            }
            default: return false;
        }
        return false;
    }
}