package pl.cloud.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private final MyRepository myRepository;
    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    public Receiver(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public void receiveMessage(Integer message) {
        Integer prime = calculatePrimeNumber(2, 0, message);
        Result result = new Result();
        result.setResult(prime);
        myRepository.save(result);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }


    private static int calculatePrimeNumber(int number, int i, int n) {
        while (true) {
            number++;
            if (isPrime(number)) ++i;
            if (i > n && isPrime(number)) break;
        }
        return number;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

}
