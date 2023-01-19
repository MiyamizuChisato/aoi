package fun.ciallo.aoi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserProfileModel {
    private String motto;
    private String avatar;
    private String website;
    private String nickname;
    private String visitPath;
    private LocalDateTime latest;
    private LocalDateTime birthday;
    private String gender;

    public void setGender(Boolean gender) {
        if (Boolean.TRUE.equals(gender)) {
            this.gender = "男";
        } else if (Boolean.FALSE.equals(gender)) {
            this.gender = "女";
        } else {
            this.gender = "未公开";
        }
    }
}
