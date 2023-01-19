package fun.ciallo.aoi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.ciallo.aoi.entity.Blog;
import fun.ciallo.aoi.mapper.BlogMapper;
import fun.ciallo.aoi.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
    @Resource
    private BlogMapper blogMapper;

    @Override
    public String getContentById(int id) {
        LambdaQueryWrapper<Blog> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(Blog::getContent);
        lambdaQueryWrapper.eq(Blog::getId, id);
        Blog blog = baseMapper.selectOne(lambdaQueryWrapper);
        return blog.getContent();
    }
}
