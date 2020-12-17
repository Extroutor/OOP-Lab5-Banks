package Account;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class CreditAccount implements Account {

    private final HashMap<Long, Double> _commissionsList = new HashMap<>();
    public boolean CanWithdrawOrTransfer;

    //public AccountType _accountType;
    public UUID _accountID;
    public double _percentage;
    public double _commission;
    public double _accountBalance;
    private final double _upperLimit;
    private final double _lowerLimit;


    public CreditAccount(double upperLimit, double lowerLimit, double commissionRate) {
        //_accountType = AccountType.Credit;
        _accountID = UUID.randomUUID();
        _percentage = 0;
        _commission = commissionRate;
        _accountBalance = upperLimit;
        CanWithdrawOrTransfer = true;
        _upperLimit = upperLimit;
        _lowerLimit = lowerLimit;
    }

    @Override
    public void Withdraw(Double amountToWithdraw) throws Exception {
        if (!(_accountBalance - amountToWithdraw <= _lowerLimit)) {
            _accountBalance -= amountToWithdraw;
            if (_accountBalance < 0 && _accountBalance - amountToWithdraw * _commission <= _lowerLimit) {
                Date date = new Date();
                _commissionsList.put(date.getTime(), amountToWithdraw * _commission);
            } else {
                throw new Exception("Cannot withdraw the corresponding amount");
            }
        } else {
            throw new Exception("Cannot withdraw beyond the account limit");
        }
    }

    @Override
    public void Deposit(Double amountToDeposit) throws Exception {
        throw new Exception("Credit account cannot accept deposits.");
    }

    @Override
    public void CalculateDailyProfit(Long day) throws Exception {
        throw new Exception("Credit account doesn't have profit.");
    }

    @Override
    public Double CalculateMonthlyProfit() throws Exception {
        throw new Exception("Credit account doesn't have profit.");
    }
}
