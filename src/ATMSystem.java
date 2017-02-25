import java.util.Scanner;

/**
 * Created by aniquedavla on 2/25/17.
 */
public class ATMSystem {
    public static void main(String[] args){
        Bank bankA = new Bank("B1");
        Account aniqueAcct = new Account("act1",10.0);
            CashCard aniqueCard = new Card("1","02/19/2012","!@#");

        bankA.addAccount(aniqueAcct);
        Bank bankB = new Bank("B2");
        bankB.addAccount
        ATM atm1 = new ATM("B1",100);
        ATM atm2 = new ATM("B1",50);
        ATM atm3 = new ATM("B2",150);
        ATM atm4 = new ATM("B2",200);

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to ATM Network System"+"\n");
        System.out.println("Enter your choice of ATM");
        String atmChoice = in.nextLine();
        System.out.println("Enter your card");
        String cardNum = in.next();



    }
}
