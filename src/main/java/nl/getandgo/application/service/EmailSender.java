package nl.getandgo.application.service;

public interface EmailSender {
    /**
     * @param to target email address
     * @param email the email you want to send
    * */
    void send(String to, String email);
}
