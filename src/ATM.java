/**
 * Created by aniquedavla on 2/25/17.
 */
public class ATM {
    private int maxWithdraw;
    private Bank associatedBankID;

    public ATM(Bank associatedBankID,int maxWithdraw){
        this.associatedBankID = associatedBankID;
        this.maxWithdraw = maxWithdraw;
    }
}
