package fun.ciallo.aoi.controller;

import com.xkcoding.justauth.AuthRequestFactory;
import fun.ciallo.aoi.common.ApiStatus;
import fun.ciallo.aoi.entity.UserOauth;
import fun.ciallo.aoi.entity.UserProfile;
import fun.ciallo.aoi.service.UserOauthService;
import fun.ciallo.aoi.service.UserProfileService;
import fun.ciallo.aoi.utils.AssertUtils;
import fun.ciallo.aoi.utils.TokenUtils;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/oauth")
public class OAuthController {
    @Resource
    private AuthRequestFactory authRequestFactory;
    @Resource
    private UserOauthService userOauthService;
    @Resource
    private UserProfileService userProfileService;

    @GetMapping("/get/path/{type}")
    public String getPath(@PathVariable String type) {
        AuthRequest authRequest = authRequestFactory.get(type);
        return authRequest.authorize(AuthStateUtils.createState());
    }

    @GetMapping("/post/{type}/login")
    public Object oauth(AuthCallback callback, @PathVariable String type) {
        AuthRequest authRequest = authRequestFactory.get(type);
        AuthResponse<AuthUser> authResponse = authRequest.login(callback);
        AuthUser authUser = authResponse.getData();
        AssertUtils.notNull(authUser, ApiStatus.OAUTH_TIME_OUT);
        UserOauth userOauth = githubOauth(authUser);
        UserOauth user = userOauthService.registered(userOauth);
        UserProfile userProfile = new UserProfile();
        if (null == user) {
            userProfile.setNickname(authUser.getUsername());
            userProfile.setAvatar(authUser.getAvatar());
            userProfile.setVisitPath(authUser.getRawUserInfo().getString("html_url"));
            userProfileService.save(userProfile);
            userOauth.setUserProfileId(userProfile.getId());
            userOauthService.save(userOauth);
            return TokenUtils.tokenGenerator(userOauth.getUserProfileId());
        } else {
            return TokenUtils.tokenGenerator(user.getUserProfileId());
        }
    }

    public UserOauth githubOauth(AuthUser authUser) {
        UserOauth userOauth = new UserOauth();
        userOauth.setType("github");
        userOauth.setUuid(authUser.getUuid());
        userOauth.setAccessToken(authUser.getToken().getAccessToken());
        return userOauth;
    }

    public String tokenGenerate(int id) {
        return id + "";
    }
}
