package dengzhenzhang.top.unibook_back.service.Imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import dengzhenzhang.top.unibook_back.dao.Book;
import dengzhenzhang.top.unibook_back.mapper.BookMapper;
import dengzhenzhang.top.unibook_back.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public IPage<Book> select(IPage<Book> page) {
        return bookMapper.selectPage(page,null);
    }

    @Override
    public List<Book> search(String key) {
        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>();
        bookQueryWrapper.like("title",key);
        return bookMapper.selectList(bookQueryWrapper);
    }

    @Override
    public Book selectByid(Integer id) {
        return bookMapper.selectById(id);
    }
}
