package czu.qty.bookshop.pojo;

import java.io.Serializable;

/**
 * 本类用来演示: json的响应数据的格式
 *
 * @author: success
 * @date: 2020/12/22 10:18 上午
 */
public class Result implements Serializable {
    private String code;//响应码 - 对应的是http状态码

    private String msg;//响应的备注

    private Object data;//响应的数据

    //空参构造
    public Result(){

    }

    //全参构造

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //getter/setter

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    //toString

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Result{");
        sb.append("code='").append(code).append('\'');
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
