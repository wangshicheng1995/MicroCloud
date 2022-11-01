package com.echo.consumer.action;

import com.echo.common.dto.DeptDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author echo
 * @version 1.0
 * @date 2022/10/26 16:14
 */
@RestController
@RequestMapping("/consumer/dept/*") // 两个不同的服务路径
public class DeptConsumerAction { // 消费端 Action
    // 定义要访问的部门微服务所需要的核心路径前缀，随后在具体请求时添加传递的参数
    public static final String DEPT_ADD_URl =
            "http://localhost:8001/provider/dept/add";
    public static final String DEPT_GET_URl =
            "http://localhost:8001/provider/dept/get/";
    public static final String DEPT_LIST_URl =
            "http://localhost:8001/provider/dept/list";
    public static final String DEPT_PAGE_URl =
            "http://localhost:8001/provider/dept/page";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("add")  // 消费端接口名称
    public Object addDept(DeptDTO dto) {
        // 需要将当前 DTO 对象传递到部门微服务之中，所以此时就要通过 RestTemplate 对象处理
        return restTemplate.postForObject(DEPT_ADD_URl, dto, Boolean.class);
    }

    @GetMapping("get")
    public Object get(Long deptno) {
        return restTemplate.getForObject(DEPT_GET_URl + deptno, DeptDTO.class);
    }

    @GetMapping("list")
    public Object list() {
        return restTemplate.getForObject(DEPT_LIST_URl, List.class);
    }

    @GetMapping("page")
    public Object page(int cp, int ls, String col, String kw) {
        return restTemplate.getForObject(DEPT_PAGE_URl
                + "?cp=" + cp + "&ls=" + ls + "&col=" + col + "&kw=" + kw, Map.class);
    }
}
