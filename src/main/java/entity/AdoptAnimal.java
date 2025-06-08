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
public class AdoptAnimal implements Serializable {
    private Integer id;
    private Integer userId;
    private Integer petId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date adoptTime;
    private Integer state;
//    @TableField(exist = false) 注解通常用于MyBatis-Plus框架，用来指定某个字段不对应数据库表中的列
//    @TableField(exist = false)
//    private Pet pet;
//    @TableField(exist = false)
//    private User user;

}
