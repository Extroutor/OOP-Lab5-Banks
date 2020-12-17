package Bank;

import java.util.UUID;

public class BankBuilder {

    private UUID _bankID;
    private double _percentage;
    private double _commission;
    private double _limitOnTransferForSuspiciousAccount;
    private double _limitOnWithdrawingForSuspiciousAccount;

    public BankBuilder bankID() {
        _bankID = UUID.randomUUID();
        return this;
    }
    public BankBuilder percentage(final double percentage) {
        _percentage = percentage;
        return this;
    }
    public BankBuilder commission(final double commission) {
        _commission = commission;
        return this;
    }
    public BankBuilder limitOnTransferForSuspiciousAccount(final double limitOnTransferForSuspiciousAccount) {
        _limitOnTransferForSuspiciousAccount = limitOnTransferForSuspiciousAccount;
        return this;
    }
    public BankBuilder limitOnWithdrawingForSuspiciousAccount(final double limitOnWithdrawingForSuspiciousAccount) {
        _limitOnWithdrawingForSuspiciousAccount = limitOnWithdrawingForSuspiciousAccount;
        return this;
    }

    public double getPercentage() { return _percentage; }

    public double getCommission() { return _commission; }

    public double getLimitOnTransferForSuspiciousAccount() { return _limitOnTransferForSuspiciousAccount; }

    public double getLimitOnWithdrawingForSuspiciousAccount() { return _limitOnWithdrawingForSuspiciousAccount; }

    public UUID getBankID() { return _bankID; }

    public Bank build() { return new Bank(this); }

}
