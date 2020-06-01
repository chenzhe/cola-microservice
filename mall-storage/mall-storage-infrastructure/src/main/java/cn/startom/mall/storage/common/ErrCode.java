package cn.startom.mall.storage.common;

/**
 * 错误码
 */
public enum ErrCode {
    NOT_FOUND("NOT_FOUND","%s不存在"),
    PARAM_INVALID("PARAM_INVALID","%s参所无效");


    private String errorCode;
    private String errMessage;

    private ErrCode(String errCode,String errMessage){
        this.errMessage=errMessage;
        this.errorCode=errCode;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public String getErrMessage() {
        return errMessage;
    }
}
