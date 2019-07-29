import org.junit.Test;

import java.util.List;

public class ApproveUserLinkDomainTest {

    private ApproveUserLinkDomain domain;

    private ApproveUserLinkDomain getDomain() {
        if (domain != null) {
            return domain;
        }
        return RemoteFactory.getRemote(ApproveUserLinkDomain.class);
    }

    @Test
    public void insert() {
        ApproveUserLinkBo approveUserLinkBo = new ApproveUserLinkBo();

        boolean insert = getDomain().insert(approveUserLinkBo);
        System.out.println(insert);
    }

    @Test
    public void delete() {
//        System.out.println(getDomain().delete(1));

    }

    @Test
    public void get() {
        ApproveUserLinkBo approveUserLinkBo = getDomain().get(1);
        System.out.println(approveUserLinkBo);
    }

    @Test
    public void findall() {
        List<ApproveUserLinkBo> all = getDomain().findAll();
        all.forEach(e -> {
            System.out.println(e);
        });
    }


}
