package fun.ciallo.aoi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.ciallo.aoi.entity.Blog;

public interface BlogService extends IService<Blog> {
    String getContentById(int id);
}
