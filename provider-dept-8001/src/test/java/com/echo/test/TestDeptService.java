package com.echo.test;

import com.echo.common.dto.DeptDTO;
import com.echo.provider.StartProviderDept8001Application;
import com.echo.service.IDeptService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Map;

/**
 * @author echo
 * @version 1.0
 * @date 2022/10/25 22:31
 */
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartProviderDept8001Application.class)
public class TestDeptService {

    @Autowired
    private IDeptService deptService;

    @Test
    public void testGet() {
        System.out.println(deptService.get(1));
    }

    @Test
    public void testList() {
        System.out.println(deptService.list());
    }

    @Test
    public void testAdd() {
        DeptDTO deptDTO = new DeptDTO("公益部", "洛阳");
        System.out.println(deptService.add(deptDTO));
    }

    @Test
    public void testPage() {
        Map<String, Object> map = deptService.page(1, 2, "DNAME", "");
        System.out.println(map);
    }
}
