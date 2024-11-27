package edu.ucalgary.ensf480.group18.user.model;

public class RegularRefundStrategy implements RefundStrategy {

    @Override
    public double calculateRefund(double price) {
        // 15% Admin fee for refund
        return price - price * 0.15;
    }
}
