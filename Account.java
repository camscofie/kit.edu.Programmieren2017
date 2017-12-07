public class Account {

    int bankCode;
    int balance;
    int accountNumber;

    public Account(int bankCode, int accountNumber) {
        this.bankCode = bankCode;
        this.accountNumber = accountNumber;
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance = balance - amount;
            return true;
        }
        return false;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    ///////////////////////////////
    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public int getBalance() {
        return balance;
    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
