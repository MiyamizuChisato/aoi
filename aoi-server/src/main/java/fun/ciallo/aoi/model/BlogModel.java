package fun.ciallo.aoi.model;

import fun.ciallo.aoi.entity.Blog;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogModel extends Blog {
    private Integer comments;
}
