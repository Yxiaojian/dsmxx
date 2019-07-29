import
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = .class)
public class ApproveUserLinkServiceTest {

    @Resource
    private ApproveUserLinkService approveUserLinkService;


    @Test
    public void insert() {
        ApproveUserLink approveUserLink = new ApproveUserLink();

        boolean insert = approveUserLinkService.insert(approveUserLink);
        System.out.println(insert);
    }

    @Test
    public void delete() {
//        System.out.println(approveUserLinkService.delete(1));

    }

    @Test
    public void get() {
        ApproveUserLink approveUserLink = approveUserLinkService.get(1);
        System.out.println(approveUserLink);
    }

    @Test
    public void findall() {
        List<ApproveUserLink> all = approveUserLinkService.findAll();
        all.forEach(e -> {
            System.out.println(e);
        });
    }

}
