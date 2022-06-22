import com.tabwu.qiniuyun.utils.test.ImplUserService;
import com.tabwu.qiniuyun.utils.test.UserServiceImpl;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @ProjectName: qiNiuYun
 * @Author: tabwu
 * @Date: 2022/1/20 12:33
 * @Description:
 */
public class AbstractMethodTest {

    @Test
    public void tets() throws NoSuchMethodException {
        UserServiceImpl userService = (UserServiceImpl) new ImplUserService();

        userService.test();

    }
}
