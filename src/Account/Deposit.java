package Account;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class Deposit implements IAccount {

    public HashMap<Long, Double> _dailyPercentageList = new HashMap<>();
    public boolean _canWithdrawOrTransfer;

    public UUID _accountID;
    public Double _percentage;
    public Double _commission;
    public Double _accountBalance;
    private final Long _dueDate;

    public Deposit(Double initialDepositAmount, Long dueDate) {
        _accountID = UUID.randomUUID();
        _percentage = getPercentRate(initialDepositAmount);
        _commission = 0.;
        _accountBalance = initialDepositAmount;
        _canWithdrawOrTransfer = false;
        _dueDate = dueDate;
    }

    public double getPercentRate(double initialDepositAmount) {
        if (initialDepositAmount >= 1 && initialDepositAmount <= 50000)
            return 0.03;
        else if (initialDepositAmount >= 50001 && initialDepositAmount <= 100000)
            return 0.035;
        else if (initialDepositAmount >= 100001)
            return 0.04;
        return -1;
    }

    @Override
    public void withdraw(Double amountToWithdraw) throws Exception {
        Date dateNow = new Date();

        if (dateNow.getTime() >= _dueDate) {
            _accountBalance -= amountToWithdraw;
        } else {
            throw new Exception("Cannot withdraw until the due date!");
        }
    }

    @Override
    public void deposit(Double amountToDeposit) {
        _accountBalance += amountToDeposit;
    }

    @Override
    public void calculateDailyPercent(Long day) {
        double dailyProfitRate = _percentage / 365;
        Double todaysProfit = dailyProfitRate * _accountBalance;
        _dailyPercentageList.put(day, todaysProfit);
    }

    @Override
    public Double calculateMonthlyPercent() {
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
