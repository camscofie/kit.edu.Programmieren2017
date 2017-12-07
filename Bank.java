public class Bank {

    int bankCode;
    Account[] accounts = new Account[8];

    static Account fromAccount;
    static Account toAccount;


    public Bank(int bankCode) {
        this.bankCode = bankCode;
    }

    public int createAccount(int accountNumber) {
        Account account = new Account(bankCode, accountNumber);

        // it iterated the accounts, if it has null, if so, register the place with account
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return i;
            }
        }

        //  if the pointer is here, it means that the old array has no "null"
        // space, so it will create a new array with twice as its length.
        Account[] newAccounts = new Account[this.accounts.length * 2];
        for (int j = 0; j < accounts.length; j++) {
            newAccounts[j] = accounts[j];
        }
        newAccounts[this.accounts.length] = account;
        return this.accounts.length;

    }

    public boolean removeAccount(int accountNumber) {

        int place = 0;
        int counter = 0;
        if (this.containsAccount(accountNumber)) {
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i].getAccountNumber() == accountNumber) {
                    place = i;
                }
            }
            for (int i = place; i < accounts.length - 1; i++) {
                accounts[i] = accounts[i + 1];
            }


            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i] == null) {
                    counter++;
                }
            }

            if (counter < 0.125 * accounts.length) {
                Account[] newAccounts = new Account[accounts.length / 2];
                for (int i = 0; i < newAccounts.length; i++) {
                    newAccounts[i] = accounts[i];
                }

            }

            return true;

        }

        return false;
    }


    public boolean containsAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.accountNumber == accountNumber) {
                return true;
            }
        }
        return false;
    }


    public boolean internalBankTransfer(int fromAccountNumber, int toAccountNumber, int amount) {


        for (int i = 0; i < accounts.length; i++) {

            if (accounts[i].accountNumber == fromAccountNumber) {
                fromAccount = accounts[i];
            }

            if (accounts[i].accountNumber == toAccountNumber) {
                toAccount = accounts[i];
            }

        }


        if (fromAccount.getBalance() >= amount) {
            fromAccount.balance -= amount;
            toAccount.balance += amount;
            return true;
        }
        return false;
    }

    public int length() {
        return accounts.length;
    }

    public int size() {
        int counter = 0;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                counter++;
            }
        }

        return counter;

    }

    public Account getAccout(int index) {
        if (accounts[index] == null) {
            return null;
        }

        return accounts[index];
    }
}
