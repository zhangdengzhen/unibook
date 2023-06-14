package dengzhenzhang.top.unibook_back.service.Imp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import dengzhenzhang.top.unibook_back.dao.Recommend;
import dengzhenzhang.top.unibook_back.mapper.RecommendMapper;
import dengzhenzhang.top.unibook_back.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendServiceImp implements RecommendService {
    @Autowired
    private RecommendMapper recommendMapper;
    @Override
    public IPage<Recommend> select(IPage<Recommend> page) {
        return recommendMapper.selectPage(page,null);
    }

    @Override
    public Recommend selectByid(Integer id) {
        return recommendMapper.selectById(id);
    }

    @Override
    public Integer insert(Recommend recommend) {
        return recommendMapper.insert(recommend);
    }
}
