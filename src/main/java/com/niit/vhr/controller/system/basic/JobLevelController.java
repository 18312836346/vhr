package com.niit.vhr.controller.system.basic;

import com.niit.vhr.model.JobLevel;
import com.niit.vhr.model.RespBean;
import com.niit.vhr.service.system.basic.JobLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/job")
@Api(value = "JobLevelController", tags = {"职称管理"})
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;
    @GetMapping("/")
    @ApiOperation(value = "获取职称",notes = "获取数据库里的所有职称")
    public RespBean getAllJobLevel() {
        List<JobLevel> jobLevels = jobLevelService.getAllJobLevel();
        return RespBean.ok("获取成功", jobLevels);
    }

    @PostMapping("/")
    @ApiOperation(value = "添加职称",notes = "添加用户输入的新的职称")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
        if(jobLevelService.addJobLevel(jobLevel) == 1 ) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    @ApiOperation(value = "修改职称",notes = "根据传入的职称信息修改职位")
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel) {
        if(jobLevelService.updateJobLevel(jobLevel)== 1 ) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除职称",notes = "根据id删除职称")
    public RespBean deleteJobLevel(@PathVariable Integer id) {
        if(jobLevelService.deleteJobLevel(id) == 1 ) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    @ApiOperation(value = "批量删除职称",notes = "根据ids 批量删除职称")
    public RespBean deleteJobLevel(Integer[] ids) {
        if(jobLevelService.deleteJobLevel(ids) == ids.length) {
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }
}
