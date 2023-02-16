package praktikum.generator;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static String getRandomEmail() {
        String email = RandomStringUtils.randomAlphabetic(12) + "@yandex.ru";
        return email;
    }

    public static String getRandomPassword() {
        String password = RandomStringUtils.randomAlphabetic(10);
        return password;
    }

    public static String getRandomName() {
        String name = RandomStringUtils.randomAlphabetic(10);
        return name;
    }
}
