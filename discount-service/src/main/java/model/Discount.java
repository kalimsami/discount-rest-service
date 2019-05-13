package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Discount {
    private UserType userType;
    private int yearOfAssociation;
    private BillType billType;

    public Discount(UserType userType, int yearOfAssociation, BillType billType) {
        this.userType = userType;
        this.yearOfAssociation = yearOfAssociation;
        this.billType = billType;
    }

    public double calculateNetPayableAmount(double billAmount) {
        double netPayableAmount = billAmount;

        if (this.billType.equals(BillType.GROSSORY)) {
            return getNetPayableAmount(netPayableAmount, billAmount);
        }

        if (isEmployee()) {
            netPayableAmount = getBillAmountAfterPercentageDiscount(billAmount, 0.3);
        } else if (isAffiliate()) {
            netPayableAmount = getBillAmountAfterPercentageDiscount(billAmount, 0.1);
        } else if (isOldCustomer()) {
            netPayableAmount = getBillAmountAfterPercentageDiscount(billAmount, 0.05);
        }

        netPayableAmount = getNetPayableAmount(netPayableAmount, billAmount);

        return netPayableAmount;
    }

    private double getBillAmountAfterPercentageDiscount(double billAmount, double percentageDiscount) {
        return billAmount - billAmount * percentageDiscount;
    }

    private double getNetPayableAmount(double netPayableAmount, double billAmount) {
        return netPayableAmount - getFlatDiscount(billAmount);
    }

    private double getFlatDiscount(double billAmount) {
        return Math.floor(billAmount / 100) * 5;
    }

    private boolean isEmployee() {
        return this.userType.equals(UserType.EMPLOYEE);
    }

    private boolean isAffiliate() {
        return this.userType.equals(UserType.AFFILIATE);
    }

    private boolean isOldCustomer() {
        return this.userType.equals(UserType.CUSTOMER) && this.yearOfAssociation > 2;
    }

}