package vn.edu.hcmuaf.fit.response;

public class DataResponse<T> extends BaseResponse {
    private T data;

    public DataResponse() {
    }

    public DataResponse(boolean success, int statusCode, String message, T data) {
        super(success, statusCode, message);
        this.data = data;
    }

    public boolean isSuccess() {
        return super.isSuccess();
    }

    public void setSuccess(boolean success) {
        super.setSuccess(success);
    }

    public int getStatusCode() {
        return super.getStatusCode();
    }

    public void setstatusCode(int statusCode) {
        super.setStatusCode(statusCode);
    }

    public String getMessage() {
        return super.getMessage();
    }

    public void setMessage(String message) {
        super.setMessage(message);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
