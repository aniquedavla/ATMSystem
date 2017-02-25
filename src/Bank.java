import java.util.ArrayList;

/**
 * Created by aniquedavla on 2/25/17.
 */
public class Bank {
    private String bankID;
    private ArrayList<ATM> atm;
    private ArrayList<Account> accounts;

    public Bank(String bankID){
        this.bankID = bankID;
    }

    public void addAccount(Account theAccount){
        accounts.add(theAccount);
    }
    public


}
