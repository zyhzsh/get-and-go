package nl.getandgo.application.service;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.model.ConfirmationToken;
import nl.getandgo.application.repository.ConfirmationTokenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }

    public ConfirmationToken findToken(String token) {
        return confirmationTokenRepository.findByToken(token).orElse(null);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
