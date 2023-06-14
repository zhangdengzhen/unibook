package dengzhenzhang.top.unibook_back.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import dengzhenzhang.top.unibook_back.dao.Postread;
import dengzhenzhang.top.unibook_back.service.PostreadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "读后感")
@RequestMapping("read")
public class PostreadController {

    @Autowired

    private PostreadService postreadService;

    @ApiOperation(value = "插入读后感")
    @PostMapping("/insert")
    @ResponseBody
    Integer insert(Postread postread){
        postread.setTime(DateUtil.now());
     return postreadService.insert(postread);
    }

    @ApiOperation(value = "分页获读后感")
    @GetMapping("/selectbypage")
    @ResponseBody
    IPage<Postread> select(@RequestParam Integer curPage, @RequestParam Integer PageSize){
        return postreadService.select(new Page<>(curPage,PageSize));
    }

    @ApiOperation(value = "根据id获读后感")
    @GetMapping("/selectbyid")
    @ResponseBody
    public Postread selectByid(Integer id) {

        return postreadService.selectByid(id);
    }
}
