package dengzhenzhang.top.unibook_back.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import dengzhenzhang.top.unibook_back.dao.Book;
import dengzhenzhang.top.unibook_back.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(tags = "图书模块")
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;


    @ApiOperation(value = "分页获取图书")
    @GetMapping("/selectbypage")
    @ResponseBody
    IPage<Book> select(@RequestParam Integer curPage,@RequestParam Integer PageSize){
        return bookService.select(new Page<Book>(curPage, PageSize));
    }

    @ApiOperation(value = "搜索")
    @GetMapping("/searchBytitle")
    @ResponseBody
    List<Book> search(String key){
        return bookService.search(key);
    }

    @ApiOperation(value = "根据id获取图书")
    @GetMapping("/selectByid")
    @ResponseBody
    public Book selectByid(Integer id) {
        return bookService.selectByid(id);
    }
}
