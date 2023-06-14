package dengzhenzhang.top.unibook_back.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import dengzhenzhang.top.unibook_back.dao.Postread;


public interface PostreadService {
    Integer insert(Postread postread);
    IPage<Postread> select(IPage<Postread>page);
    Postread selectByid(Integer id);
}
