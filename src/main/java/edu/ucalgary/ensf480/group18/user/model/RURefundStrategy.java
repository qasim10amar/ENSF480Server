package edu.ucalgary.ensf480.group18.user.model;

public class RURefundStrategy implements RefundStrategy {
    @Override
    public double calculateRefund(double price) {
        // Full refund for registered users
        return price;
    }
}
