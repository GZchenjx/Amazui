package BaseService;

import com.jx.bean.User;
import com.jx.common.EncryptUtils;
import com.jx.service.BaseService;
import com.jx.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018/2/2.
 */
public class UserListAllTest extends BaseServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getById() {
       User user = (User) userService.getById(1);
        System.out.println(user.getEmail());
    }
    @Test
    public void update() {
        User user = new User();
        user.setId(1);
        user.setEmail("302936105@qq.com");
        user.setPwd(EncryptUtils.md5("123456"));
        user.setQq("123456789");
        userService.update(user);
        System.out.println(user.getPwd());
    }
}
