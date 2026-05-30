package ir.ac.kntu;

import java.util.Date;

public class RentAgreement {
    private final Date startDate; 
    private Date endDate;
    private double price;

    public RentAgreement(Date startDate, Date endDate, double price) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public boolean extendAgreement(Date newEndDate, double additionalPrice) {
        if(!newEndDate.after(endDate)) {
            return false;
        }
        endDate = newEndDate;
        price += additionalPrice;
        return true;
    }

    public double getPrice() {
        return price;
    }

    public Date getStartDate() {
        return startDate;
    }
}
