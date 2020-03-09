import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataHelper {
    private static Faker faker;

    public static String getFormattedRandomDate() {
        LocalDate returnedDate = LocalDate.now();

        returnedDate = returnedDate.plusDays(new Random().nextInt((30 - 3) + 1) + 3);
        return returnedDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


    public static String getNewCity() {
        return new Faker(new Locale("ru")).address().cityName();
    }

    public static String getNewName() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String getNewPhone() {
        return new Faker(new Locale("ru")).phoneNumber().cellPhone();
    }

}
