import com.github.lzj960515.mock.util.MockUtil;

/**
 * @author Zijian Liao
 * @since 0.0.1
 */
public class MockTest {

    public static void main(String[] args) {
        User user = MockUtil.mock(User.class);
        System.out.println(user);
    }
}
