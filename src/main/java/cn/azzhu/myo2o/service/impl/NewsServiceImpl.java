package cn.azzhu.myo2o.service.impl;

import cn.azzhu.myo2o.entity.LogInfo;
import cn.azzhu.myo2o.entity.News;
import cn.azzhu.myo2o.mapper.sys.NewsMapper;
import cn.azzhu.myo2o.service.NewsService;
import cn.azzhu.myo2o.utils.DataGridView;
import cn.azzhu.myo2o.vo.NewsVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author azzhu
 * @create 2019-09-03 22:34:56
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public DataGridView queryAllNews(NewsVo newsVo) {
        PageHelper.startPage(newsVo.getPage(),newsVo.getLimit());
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        List<News> news = newsMapper.selectList(queryWrapper);
        PageInfo<LogInfo> pageInfo = new PageInfo<>();
        DataGridView<News> dataGridView = new DataGridView<>();
        dataGridView.setCount(pageInfo.getTotal());
        dataGridView.setData(news);
        return dataGridView;
    }

    @Override
    public void addNews(NewsVo newsVo) {
        newsMapper.insert(newsVo);
    }

    @Override
    public void updateNews(NewsVo newsVo) {
        newsMapper.update(newsVo,null);
    }

    @Override
    public void deleteNews(Integer newsid) {
        newsMapper.deleteById(newsid);
    }

    @Override
    public void deleteBatchNews(Integer[] ids) {
        newsMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public News queryNewsById(Integer id) {
        return newsMapper.selectById(id);
    }
}
