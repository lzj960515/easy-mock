import com.github.lzj960515.mock.annotation.Age;
import com.github.lzj960515.mock.annotation.Chinese;
import com.github.lzj960515.mock.annotation.Entity;
import com.github.lzj960515.mock.annotation.Gender;
import com.github.lzj960515.mock.annotation.Name;
import com.github.lzj960515.mock.annotation.Number;
import lombok.Data;

import java.util.List;

/**
 * user
 *
 * @author Zijian Liao
 * @since 0.0.1
 */
@Data
public class User {

    @Name
    private String name;
    @Age
    private String age;
    @Chinese
    private String hobby;
    @Gender
    private String gender;
    @Entity
    private Order order;

    private List<Order> orderList;

}
