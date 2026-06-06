package ir.ac.kntu.lms.financial;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionInfo {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
    private static int numberOfTransaction = 1;
    private final double transcationValue;
    private final Type type;
    private final LocalDateTime date;
    private final int id;

    public TransactionInfo(double transcationValue, Type type, LocalDateTime date) {
        this.transcationValue = transcationValue;
        this.type = type;
        this.date = date.withNano(0);
        id = numberOfTransaction;
        numberOfTransaction ++;
    }
    
    @Override
    public String toString() {
        return "-TransactionInfo: " + "Id = " + id + ", Value = " + transcationValue + ", Type = " + type + ", Date = " + date.format(formatter);
    }

    public LocalDateTime getDateTime() {
        return date;
    }
}


