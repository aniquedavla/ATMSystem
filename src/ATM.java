import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Exchanger;

/**
 * Created by aniquedavla on 2/25/17.
 */
public class ATM {
    private int maxWithdrawAmt ;
    private Bank associatedBank;

    public ATM(Bank associatedBank,int maxWithdraw){
        this.associatedBank = associatedBank;
        this.maxWithdrawAmt = maxWithdraw;
    }
    public Bank getAssociatedBank(){
        return associatedBank;
    }
    public String validateCard(String cardNumber)throws ParseException{
        if(findBankID(cardNumber).equals(associatedBank.getBankID())){
            String cardExpirationDate = associatedBank.findAccount(cardNumber).getCashCardAssociated().getExpirationDate();
            if(isExpired(cardExpirationDate)){
                return "This card is expired and returned to you.";
            } else{
                return "The card is accepted. Please enter your password.";
            }
        } else{
            return "This card is not supported by this ATM";
        }
    }
    public void authenticateCard(String cardNumb,String password){
        if(associatedBank.checkCardPassword(cardNumb,password)){
            System.out.println("Authorization is accepted. Start your transaction by entering the amount to withdraw.");
        } else{
            System.out.println("This is a wrong password. Enter your password again.");
        }
    }

    public void returnCard(){
        System.out.println("Card Returned");
    }

    public String findBankID(String cardNumber){
     return cardNumber.substring(0,1);
    }
    public boolean isExpired(String expirationDate)throws ParseException{
        boolean expired;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
        dateFormat.setLenient(false);
        Date formatedExpiryDate = dateFormat.parse(expirationDate);
        expired = formatedExpiryDate.before(new Date());
        return expired;
    }
    public String withdraw(String cardNumb, double transactionAmount){
        if(transactionAmount <= maxWithdrawAmt){
           return associatedBank.withdraw(cardNumb, transactionAmount);
        } else{
            return "This amount exceeds the maximum amount you can withdraw per transaction. Please enter the amount or quit.";
        }
    }
}
