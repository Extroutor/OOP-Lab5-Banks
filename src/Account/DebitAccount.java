package Account;

import java.util.HashMap;
import java.util.UUID;

public class DebitAccount implements IAccount {

    public HashMap<Long, Double> _dailyPercentageList = new HashMap<>();

    public UUID accountID;
    public Double percentage;
    public Double commission;
    public Double accountBalance;

    public DebitAccount(Double percent) {
        accountID = UUID.randomUUID();
        percentage = percent;
        commission = 0.;
        accountBalance = 0.;
    }

    @Override
    public void withdraw(Double amountToWithdraw) throws Exception {
        if (amountToWithdraw > accountBalance) {
            throw new Exception("Not enough balance in the account!");
        } else {
            accountBalance -= amountToWithdraw;
        }
    }

    @Override
    public void deposit(Double amountToDeposit) {
        accountBalance += amountToDeposit;
    }

    @Override
    public void calculateDailyProfit(Long day) {
        var dailyPercentRate = percentage / 365; //округлить
        var todaysPercent = dailyPercentRate * accountBalance;
        _dailyPercentageList.put(day, todaysPercent);
    }

    @Override
    public Double calculateMonthlyProfit() {
        Double monthlyPercent = null;
        for (var day : _dailyPercentageList.keySet()) {
            monthlyPercent += _dailyPercentageList.get(day);
        }
        accountBalance += monthlyPercent;
        System.out.println("This months Profit : " + monthlyPercent);
        _dailyPercentageList.clear();
        return monthlyPercent;
    }
}
