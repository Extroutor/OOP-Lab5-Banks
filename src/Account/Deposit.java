package Account;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class Deposit implements Account {

    public HashMap<Long, Double> _dailyPercentageList = new HashMap<>();
    public boolean CanWithdrawOrTransfer;

//    public AccountType _accountType;
    public UUID _accountID;
    public Double _percentage;
    public Double _commission;
    public Double _accountBalance;
    private final Long _dueDate;

    public Deposit(Double initialDepositAmount, Long dueDate) {
        //_accountType = AccountType.Deposit;
        _accountID = UUID.randomUUID();
        _percentage = GetProfitRate(initialDepositAmount);
        _commission = 0.;
        _accountBalance = initialDepositAmount;
        CanWithdrawOrTransfer = false;
        _dueDate = dueDate;
    }

    public double GetProfitRate(double initialDepositAmount) {
        if (initialDepositAmount >= 1 && initialDepositAmount <= 50000)
            return 0.03;
        else if (initialDepositAmount >= 50001 && initialDepositAmount <= 100000)
            return 0.035;
        else if (initialDepositAmount >= 100001)
            return 0.04;
        return -1;
    }

    @Override
    public void Withdraw(Double amountToWithdraw) throws Exception {
        Date dateNow = new Date();

        if (dateNow.getTime() >= _dueDate) {
            _accountBalance -= amountToWithdraw;
        } else {
            throw new Exception("Cannot withdraw until the due date!");
        }
    }

    @Override
    public void Deposit(Double amountToDeposit) {
        _accountBalance += amountToDeposit;
    }

    @Override
    public void CalculateDailyProfit(Long day) {
        double dailyProfitRate = _percentage / 365;
        Double todaysProfit = dailyProfitRate * _accountBalance;
        _dailyPercentageList.put(day, todaysProfit);
    }

    @Override
    public Double CalculateMonthlyProfit() {
        Double monthlyProfit = null;
        for (var day : _dailyPercentageList.keySet()) {
            monthlyProfit += _dailyPercentageList.get(day);
        }
        _accountBalance += monthlyProfit;
        System.out.println("This months Profit : " + monthlyProfit);
        _dailyPercentageList.clear();
        return monthlyProfit;
    }
}
