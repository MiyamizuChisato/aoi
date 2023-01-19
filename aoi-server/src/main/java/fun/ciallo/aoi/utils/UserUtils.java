package fun.ciallo.aoi.utils;

import javax.servlet.http.HttpServletRequest;

public class UserUtils {
    public static int getIdByRequest(HttpServletRequest request) {
        return (int) request.getAttribute("id");
    }
}
