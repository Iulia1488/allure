package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy",
                new Locale("ru")));
    }

    public static String generateCity() {
        String[] cities = new String[]{"Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Нижний Новгород", "Хабаровск"};
        int item = (int) (Math.random() * cities.length);
        return cities[item];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String clientName = faker.name().lastName() + " " + faker.name().firstName();
        return clientName;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String clientPhone = faker.phoneNumber().phoneNumber();
        return clientPhone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}