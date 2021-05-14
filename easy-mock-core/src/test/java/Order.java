import com.github.lzj960515.mock.annotation.Number;
import com.github.lzj960515.mock.annotation.Price;
import lombok.Data;

/**
 * @author Zijian Liao
 * @since 0.0.1
 */
@Data
public class Order {

    @Number
    private String number;

    @Price
    private String price;
}
