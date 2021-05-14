import com.github.javafaker.Faker;

import javax.swing.text.DateFormatter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

/**
 * 测试faker中支持的mock
 *
 * @author Zijian Liao
 * @since 0.0.1
 */
public class FakerTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Faker faker = Faker.instance(Locale.CHINA);
        System.out.println(faker.address().cityName() + faker.address().streetAddress());
        System.out.println(faker.avatar().image());
        System.out.println(faker.name().fullName());
        System.out.println(faker.name().firstName());
        System.out.println(faker.funnyName().name());
        System.out.println(faker.number().numberBetween(0, 100));
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.commerce().price());
        System.out.println(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(faker.university().name());
        System.out.println(faker.medical().diseaseName());
        System.out.println(faker.medical().hospitalName());
        System.out.println(faker.medical().medicineName());
        System.out.println(faker.medical().symptoms());
        System.out.println(faker.stock().nsdqSymbol());
        System.out.println(faker.stock().nyseSymbol());
        System.out.println(faker.number().randomNumber());
    }

}
