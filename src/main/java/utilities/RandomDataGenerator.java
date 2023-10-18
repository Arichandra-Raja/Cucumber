package utilities;

import java.util.UUID;

public class RandomDataGenerator {

    public static String generateRandomString() {
        return UUID.randomUUID().toString();
    }
}
