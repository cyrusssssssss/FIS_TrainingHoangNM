package apache.poi.tryit;


public class Transaction {
    private String type;
    private String bankAcount;
    private double amount;
    private String message;
    private String dateTime;

    public Transaction() {
    }

    public Transaction(String type, String bankAcount, double amount, String message, String dateTime) {
        this.type = type;
        this.bankAcount = bankAcount;
        this.amount = amount;
        this.message = message;
        this.dateTime = dateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBankAcount() {
        return bankAcount;
    }

    public void setBankAcount(String bankAcount) {
        this.bankAcount = bankAcount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", bankAcount='" + bankAcount + '\'' +
                ", amount=" + amount +
                ", message='" + message + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
