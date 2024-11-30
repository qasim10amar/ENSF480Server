package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.Cookie;
import edu.ucalgary.ensf480.group18.user.model.RegisteredUser;
import edu.ucalgary.ensf480.group18.user.repository.CookieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;

@Service
public class CookieServImpl implements CookieServ {
    @Autowired
    private CookieRepo cookieRepository;

    public CookieServImpl(CookieRepo cookieRepository) {
        this.cookieRepository = cookieRepository;
    }

    @Override
    public Cookie addRow(RegisteredUser user) {
        String token = generateRandomToken();
        LocalDate currentDate = LocalDate.now();

        Cookie cookie = new Cookie();
//        cookie.setUser(user);
        cookie.setUserToken(token);
        cookie.setAddDate(currentDate);

        return cookieRepository.save(cookie);
    }

    @Override
    public LocalDate getAddDate(String token) {
        return cookieRepository.findByUserToken(token)
                .map(Cookie::getAddDate)
                .orElseThrow(() -> new IllegalArgumentException("Invalid token: " + token));
    }

    @Override
    public String getUserEmail(String token) {
        return cookieRepository.findByUserToken(token)
                .map(cookie -> cookie.getUser().getUsrEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid token: " + token));
    }

    // Private utility to generate a random 16-character token
    private String generateRandomToken() {
        SecureRandom random = new SecureRandom();
        StringBuilder token = new StringBuilder();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 16; i++) {
            token.append(chars.charAt(random.nextInt(chars.length())));
        }
        return token.toString();
    }
}
