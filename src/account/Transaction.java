package account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Represents a transaction with a type, amount
 * and a timestamp of the said transaction
 */
public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime time_stamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.time_stamp = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTime_stamp() {
        return time_stamp;
    }

    /** Formats the date to a proper format of year-month-day */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern
        ("yyyy-MM-dd HH:mm");
        return "Transaction [type=" + type + ", amount=" +
        amount + ", time stamp=" + time_stamp.format(formatter)
                + "]";
    }
}