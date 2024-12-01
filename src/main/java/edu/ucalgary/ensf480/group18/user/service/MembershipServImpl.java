package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.RegisteredUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MembershipServImpl implements MembershipServ {

    @Autowired
    private RegisteredUserServ registeredUserService;

    @Autowired
    private EmailNotificationServ emailService;

    public boolean processMembershipPayment(String email, double paymentAmount) {
        RegisteredUser user = registeredUserService.getUserByEmailAddress(email);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        if (paymentAmount < RegisteredUser.getAnnualFee()) {
            throw new IllegalArgumentException("Insufficient payment amount. Annual fee is " + RegisteredUser.getAnnualFee());
        }

        user.renewMembership(); // Renew membership
        registeredUserService.createUser(user); // Save updated user to the database
        return true;
    }

    public boolean isMembershipActive(String email) {
        RegisteredUser user = registeredUserService.getUserByEmailAddress(email);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return user.isMembershipActive();
    }

    @Scheduled(cron = "0 0 12 * * ?") // Runs daily at noon
    public void sendRenewalReminders() {
        List<RegisteredUser> users = registeredUserService.getAllRegisteredUsers();

        for (RegisteredUser user : users) {
            if (user.getMembershipExpiry() != null &&
                    user.getMembershipExpiry().isBefore(LocalDate.now().plusWeeks(2))) {

                emailService.sendMembershipRenewalEmail(user.getUsrEmail(), user.getMembershipExpiry());
            }
        }
    }
}
