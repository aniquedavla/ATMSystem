import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by aniquedavla on 2/25/17.
 */
public class ATMSystem {


    public static void main(String[] args) throws ParseException {
        Bank bankA = new Bank("A");
        Account acctA1 = new Account(new CashCard("A100","02/19"),"!@#",100);
        bankA.addAccount(acctA1);

        Bank bankB = new Bank("B");
        //bankB.addAccount(acctB1);
        ATM atm1A = new ATM(bankA,100);
        ATM atm2A = new ATM(bankA,50);
        ATM atm1B = new ATM(bankB,150);
        ATM atm2B = new ATM(bankB,200);

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to ATM Network System"+"\n");
        System.out.println("Enter your choice of ATM");
        String atmChoice = in.nextLine();
        int totalATM = 4;
        String choice;
        switch(totalATM){
            case 1: choice = "atm1A";
                break;
            case 2: choice = "atm1B";
                break;
            case 3: choice = "atm2A";
                break;
            case 4: choice = "atm2B";
                break;
            default: choice = "Invalid ATM";
                break;
        }
        while(atmChoice.equals("atm1A")||atmChoice.equals("atm1B")||atmChoice.equals("atm2A")||atmChoice.equals("atm2B")||!(in.nextLine().equals("quit"))){
            if(atmChoice.equals("atm1A")) {
                System.out.println("Enter your card");
                String cardNum = in.nextLine();
                String response = atm1A.validateCard(cardNum);
                System.out.println(response);
                String password = in.nextLine();
                atm1A.authenticateCard(cardNum,password);
                double transactionAmount = in.nextDouble();
                String transactionResponse = atm1A.withdraw(cardNum,transactionAmount);
                System.out.println(transactionResponse);
            } else{
                System.out.println("Invalid ATM choice");
            }
        }
    }
}

