package czu.qty.bookshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @create 2020-12-25-12:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * u_id         int 用户id
 * u_name       varchar 用户name
 * u_password   varchar 密码
 * email        varchar 邮箱
 * power        int 用户权限
 */
public class User {

    private Integer u_id;
    private String u_name;
    private String u_password;
    private String email;
    private Integer power;

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}
