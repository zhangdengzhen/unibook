package dengzhenzhang.top.unibook_back.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import dengzhenzhang.top.unibook_back.dao.Book;
import dengzhenzhang.top.unibook_back.dao.Recommend;

public interface RecommendService {
    IPage<Recommend> select(IPage<Recommend> page);
    Recommend selectByid(Integer id);
    Integer insert(Recommend recommend);
}
