package server;

public class Transaction {
    private String actionDate;
    private String number;
    private TransactionType transactionType;
    private String amount;

    public String getActionDate() {
        return actionDate;
    }

    public Transaction setActionDate(String actionDate) {
        this.actionDate = actionDate;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public Transaction setNumber(String number) {
        this.number = number;
        return this;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Transaction setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public Transaction setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public String toString() {
        return "actionDate=" + actionDate + ", number=" + number + ", transactionType=" + transactionType +
                ", amount=" + amount;
    }
}
