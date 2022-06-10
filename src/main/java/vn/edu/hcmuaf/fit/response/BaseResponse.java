package vn.edu.hcmuaf.fit.response;

public class BaseResponse {
    private boolean success;
    private int statusCode;
    private String message;

    public BaseResponse() {
    }

    public BaseResponse(boolean success, int statusCode, String message) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
    }

    public static BaseResponse GenarateIsSucceed() {
        return new BaseResponse(true, 0, "Succeed!");
    }

    public static BaseResponse GenarateIsFailed(int statusCode, String message) {
        return new BaseResponse(false, statusCode, message);
    }

    public boolean isSuccess() {
        return success;
    }

    protected void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatusCode() {
        return statusCode;
    }

    protected void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    protected void setMessage(String message) {
        this.message = message;
    }
}
