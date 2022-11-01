package com.echo.provider.action;

import com.echo.common.dto.DeptDTO;
import com.echo.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author echo
 * @version 1.0
 * @date 2022/10/26 14:58
 */
@RestController
@RequestMapping("/provider/dept/*") // 微服务提供者父路径
public class DeptAction {
    @Autowired
    private IDeptService deptService;

    @GetMapping("get/{id}")
    public Object get(@PathVariable("id") long id) {
        if (id % 2 == 0) {   // 查询ID为偶数
            throw new RuntimeException("查询iD不能为偶数！");
        }
        return this.deptService.get(id);
    }

    @PostMapping("add")
    public Object add(@RequestBody DeptDTO deptDTO) {    // 后面会修改参数模式为JSON
        return this.deptService.add(deptDTO);
    }

    @GetMapping("list")
    public Object list() {
        return this.deptService.list();
    }

    @GetMapping("page")
    public Object page(int cp, int ls, String col, String kw) {
        return this.deptService.page(cp, ls, col, kw);
    }


}
