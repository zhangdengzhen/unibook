package dengzhenzhang.top.unibook_back.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import dengzhenzhang.top.unibook_back.dao.Recommend;
import dengzhenzhang.top.unibook_back.service.RecommendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "首页推荐")
@RequestMapping("recommend")
public class RecommendController {

    @Autowired
    private RecommendService recommendService;


    @ApiOperation(value = "分页获取推荐")
    @GetMapping("/selectbypage")
    @ResponseBody
    IPage<Recommend> select(@RequestParam Integer curPage, @RequestParam Integer PageSize){
        return recommendService.select(new Page<Recommend>(curPage,curPage));
    }

    @ApiOperation(value = "根据id获取")
    @GetMapping("/selectByid")
    @ResponseBody
    public Recommend selectByid(Integer id) {
    return recommendService.selectByid(id);
    }

    @ApiOperation(value = "插入")
    @PostMapping("/insert")
    @ResponseBody
    public Integer insert(Recommend recommend) {
        recommend.setTime(DateUtil.now());
        return recommendService.insert(recommend);
    }
}
