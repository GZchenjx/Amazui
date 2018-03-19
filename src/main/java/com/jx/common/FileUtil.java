package com.jx.common;

import org.springframework.web.context.ContextLoader;

import java.io.File;

/**
 * Created by LQF on 2018/3/8.
 */
public class FileUtil {

    public static String updateImg() {
        String path = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/static/uploads/");
        File file = new File(path,"img");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

}
