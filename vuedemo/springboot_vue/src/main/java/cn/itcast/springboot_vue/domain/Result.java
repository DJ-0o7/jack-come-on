package cn.itcast.springboot_vue.domain;

public class Result {
    //响应码
    private Integer code;

    public Result(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
