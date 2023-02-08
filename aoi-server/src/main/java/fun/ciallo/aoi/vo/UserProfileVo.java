package fun.ciallo.aoi.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserVo {
    private String nickname;
    private String motto;
    private String website;
    private Integer gender;
    private LocalDateTime birthday;

    public void setGender(String gender) {
        if (gender.equals("男")) {
            this.gender = 1;
        } else if (gender.equals("女")) {
            this.gender = 0;
        } else {
            this.gender = null;
        }
    }
}
