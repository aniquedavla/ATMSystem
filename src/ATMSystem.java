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
        Account acctA1 = new Account(new CashCard("A100","02/19"),"!@#");
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
        if(atmChoice.equals("atm1A")) {
            System.out.println("Enter your card");
            String cardNum = in.nextLine();
            String response = atm1A.validateCard(cardNum);
            System.out.println(response);
            String password = in.nextLine();
            atm1A.authenticateCard(cardNum,password);


        }else{
            System.out.println("Invalid ATM choice");
        }


//  Boolean isCardValid = currentAccount.validateCard();
//        if(isCardValid){
//            System.out.println("The card is accepted.Please enter your password.");
//            String password = in.nextLine();
//            Boolean cardAuthenticated = currentAccount.authenticateCard(password);
//        }
////            String expirationDate = "01/17";
////            boolean expired;
////            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/YY");
////            dateFormat.setLenient(false);
////                Date expiry = dateFormat.parse(expirationDate);
////                expired = expiry.before(new Date());
////
////        System.out.println(expired);
}
}
