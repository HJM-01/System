package entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class user implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private String sex;
    private Integer age;
    private String telephone;
    private String Email;
    private String address;
    private String pic;
    private Integer state;

    //注册用
    public user(String userName, String password, String telephone) {
        this.userName = userName;
        this.password = password;
        this.telephone = telephone;
    }
    //显示用
    public user(Integer id,String userName, String sex,Integer age,String telephone,String Email,String address) {
        this.id = id;
        this.userName = userName;
        this.sex=sex;
        this.age=age;
        this.telephone=telephone;
        this.Email=Email;
        this.address=address;
    }
}
