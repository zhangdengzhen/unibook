package dengzhenzhang.top.unibook_back.service.Imp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import dengzhenzhang.top.unibook_back.dao.Postread;
import dengzhenzhang.top.unibook_back.mapper.PostreadMapper;
import dengzhenzhang.top.unibook_back.service.PostreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostreadServiceImp implements PostreadService {
    @Autowired
    private PostreadMapper postreadMapper;
    @Override
    public Integer insert(Postread postread) {
        return postreadMapper.insert(postread);
    }

    @Override
    public IPage<Postread> select(IPage<Postread> page) {
        return postreadMapper.selectPage(page,null);
    }

    @Override
    public Postread selectByid(Integer id) {
        return postreadMapper.selectById(id);
    }
}
