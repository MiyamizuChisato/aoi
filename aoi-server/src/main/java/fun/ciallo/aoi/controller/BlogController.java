package fun.ciallo.aoi.controller;

import fun.ciallo.aoi.entity.Blog;
import fun.ciallo.aoi.model.BlogModel;
import fun.ciallo.aoi.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Resource
    private BlogService blogService;

    @GetMapping("/get/{id}")
    public BlogModel getBlogById(@PathVariable int id) {
        Blog blog = blogService.getById(id);
        BlogModel model = new BlogModel();
        model.setComments(100);
        BeanUtils.copyProperties(blog, model);
        return model;
    }

    @GetMapping("/get/content/{id}")
    public String getContentById(@PathVariable int id) {
        return blogService.getContentById(id);
    }
}
