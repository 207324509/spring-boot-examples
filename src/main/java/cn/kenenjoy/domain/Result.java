package cn.kenenjoy.domain;

import java.io.Serializable;

/**
 * Created by hefa on 2017/7/28.
 */
public class Result implements Serializable {

    private static final long serialVersionUID = 8562350122605879504L;

    private String success;
    private String errorMsg;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
