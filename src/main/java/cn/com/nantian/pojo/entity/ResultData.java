package cn.com.nantian.pojo.entity;

/**
 * Created by ydz on 2019/3/20
 */


public class ResultData<T> {

    private T data;

    private int code =200;

    private String msg;

    private Boolean success = true;
    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public int getCode() {

        return code;
    }
    public void setCode(int code) {
        if(200 != code){
            success = false;
        }
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
