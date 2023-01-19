package fun.ciallo.aoi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@TableName
public class UserProfile {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String motto;
    private String avatar;
    private String website;
    private String nickname;
    private String visitPath;
    private Boolean status;
    private Boolean gender;
    private LocalDateTime latest;
    private LocalDateTime birthday;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    @TableLogic
    private Boolean deleted;
}
