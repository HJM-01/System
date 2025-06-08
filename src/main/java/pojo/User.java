package pojo;
import lombok.Data;

import java.util.List;

@Data
public class User {
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
//    @TableField(exist = false)
//    List<Comment> commentList;
//    @TableField(exist = false)
//    List<AdoptAnimal> animalList;

}
