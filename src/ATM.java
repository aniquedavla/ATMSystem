import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Exchanger;

/**
 * Created by aniquedavla on 2/25/17.
 */
public class ATM {
    private int maxWithdraw;
    private Bank associatedBank;

    public ATM(Bank associatedBank,int maxWithdraw){
        this.associatedBank = associatedBank;
        this.maxWithdraw = maxWithdraw;
    }
    public Bank getAssociatedBank(){
        return associatedBank;
    }
    public String validateCard(String cardNumber){
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
//    public boolean authenticateCard(String password){
//        associatedBank.checkPassword(password);
//    }
//
//    public void returnCard(){
//        System.out.println("Card Returned");
//    }
//
//    public boolean checkPassword(String password){
//        associatedBank.checkPassword(password, cardInProcess.getCardNumber());
//        return false;
//    }

    public String findBankID(String cardNumber){
     return cardNumber.substring(0,1);
    }
    public boolean isExpired(String expirationDate){
        boolean expired;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/YY");
        dateFormat.setLenient(false);
        try {
            Date expiry = dateFormat.parse(expirationDate);
            expired = expiry.before(new Date());
        }catch (ParseException e){
            //try again, could be expired in ATM System
            expired = true;
        }
        return expired;
    }
}
