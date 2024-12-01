package edu.ucalgary.ensf480.group18.user.service;

public interface MembershipServ {
    boolean processMembershipPayment(String email, double paymentAmount);

    boolean isMembershipActive(String email);
}
