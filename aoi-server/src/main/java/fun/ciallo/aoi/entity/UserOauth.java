package fun.ciallo.aoi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName
public class UserOauth {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userProfileId;
    private String type;
    private String uuid;
    private String accessToken;
}