package UnitTests.Serivices;
import com.github.javafaker.Faker;
import nl.getandgo.application.model.ConfirmationToken;
import nl.getandgo.application.repository.ConfirmationTokenRepository;
import nl.getandgo.application.service.ConfirmationTokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfirmationTokenServiceTest {

    private Faker faker;

    @InjectMocks
    private ConfirmationTokenService confirmationTokenService;

    @Mock
    private ConfirmationTokenRepository confirmationTokenRepository;

    @BeforeEach
    public void Setup(){
        faker=new Faker();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void Save_Token_Test(){
        //Arrange
        ConfirmationToken token=new ConfirmationToken(faker.crypto().toString(), LocalDateTime.now(),LocalDateTime.now().plusMinutes(15),null);
        //Act
        Mockito.when(confirmationTokenRepository.findByToken(token.getToken())).thenReturn(Optional.of(token));
        confirmationTokenService.saveConfirmationToken(token);
        //Assert
        ConfirmationToken actual = confirmationTokenService.findToken(token.getToken());
        assertEquals(actual.getToken(),token.getToken());
    }

}
