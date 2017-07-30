package cn.kenenjoy.util;

import java.util.UUID;

/**
 * Created by hefa on 2017/7/28.
 */
public class UUIDTool {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
