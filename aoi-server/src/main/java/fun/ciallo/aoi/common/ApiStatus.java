package fun.ciallo.aoi.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiStatus {
    SUCCESS(0, ""),
    FAILED(-1, ""),
    OAUTH_TIME_OUT(-2, "认证超时，请稍后重试"),
    TOKEN_ERROR(-3, "无法请求这个资源");

    private final int code;
    private final String message;
}
