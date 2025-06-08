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
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String sex;
    private String pic;
    private String remark;

}
