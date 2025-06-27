package entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admins implements Serializable {
    private Integer id;
    private String adminName;
    private String adminPwd;
    private String realName;
    private String telephone;
    private String Email;
    //主要是后台到前台的时间格式的转换
    //@JsonFormat注解可以在属性的上方，同样可以在属性对应的get方法上，两种方式没有/区别
    @JsonFormat(pattern = "yyyy-MM-dd")
    //主要是前后到后台的时间格式的转换
    private Date birthday;
    private String sex;
    private String pic;
    private String remark;

    public Admins(Integer id, String adminName, String Email,String telephone, String sex) {
        this.id = id;
        this.adminName = adminName;
        this.Email = Email;
        this.telephone = telephone;
        this.sex=sex;
    }

    public Admins(Integer id, String adminName, String adminPwd, String realName,String telephone, String Email,Date birthday, String sex) {
        this.id = id;
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.realName = realName;
        this.telephone = telephone;
        this.Email = Email;
        this.birthday = birthday;
        this.sex=sex;
    }
}
