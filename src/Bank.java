import java.util.ArrayList;

public class Bank {
    private String bankID;
    private ArrayList<ATM> atm = new ArrayList<>();
    private ArrayList<Account> accounts = new ArrayList<>();

    public Bank(String bankID){
        this.bankID = bankID;
    }

    public void addAccount(Account theAccount){
        accounts.add(theAccount);
    }
    public Account findAccount(String cardNumber){
        Account theAccount = null;
        for(Account theAcc: accounts){
            if(theAcc.getCashCardAssociated().getCardNumber().equals(cardNumber))
                theAccount = theAcc;
        }
        return theAccount;
    }
    public String getBankID(){
        return bankID;
    }


}
