package no.hvl.dat103;

import java.util.Random;

public class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public synchronized void run() {
        String messages[] = {
            "Hei jeg heter Sebastian",
            "Skal vi ta en kaffe i morgen?",
            "Hvordan synes du den nye bilen ser ut?",
            "Hva med i morgen da.."
        };
        Random random = new Random();

        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException) {
    
            }
        }
        message.write("Finished!");
    }
}