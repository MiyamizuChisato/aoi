package fun.ciallo.aoi.controller;

import fun.ciallo.aoi.common.Token;
import fun.ciallo.aoi.entity.UserProfile;
import fun.ciallo.aoi.model.UserProfileModel;
import fun.ciallo.aoi.service.UserProfileService;
import fun.ciallo.aoi.utils.UserUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserProfileController {
    @Resource
    private UserProfileService userProfileService;

    @Token
    @GetMapping("/get/profile")
    public UserProfileModel getProfile(HttpServletRequest request) {
        int id = UserUtils.getIdByRequest(request);
        UserProfile userProfile = userProfileService.getById(id);
        UserProfileModel model = new UserProfileModel();
        BeanUtils.copyProperties(userProfile, model);
        return model;
    }
}
