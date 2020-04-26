package com.niit.vhr.controller.system.basic;

import com.niit.vhr.model.JobLevel;
import com.niit.vhr.model.RespBean;
import com.niit.vhr.service.system.basic.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/job")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;
    @GetMapping("/")
    public RespBean getAllJobLevel() {
        List<JobLevel> jobLevels = jobLevelService.getAllJobLevel();
        return RespBean.ok("获取成功", jobLevels);
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
        if(jobLevelService.addJobLevel(jobLevel) == 1 ) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel) {
        if(jobLevelService.updateJobLevel(jobLevel)== 1 ) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevel(@PathVariable Integer id) {
        if(jobLevelService.deleteJobLevel(id) == 1 ) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevel(Integer[] ids) {
        if(jobLevelService.deleteJobLevel(ids) == ids.length) {
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }
}
