package dengzhenzhang.top.unibook_back.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import dengzhenzhang.top.unibook_back.dao.Book;


import java.util.List;

public interface BookService {
  IPage<Book> select(IPage<Book> page);
  List<Book> search(String key);
  Book selectByid(Integer id);
}
