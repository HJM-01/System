package entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
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
//    @TableField(exist = false)
//    List<Comment> commentList;
//    @TableField(exist = false)
//    List<AdoptAnimal> animalList;
    public user(String userName, String password, String telephone){
        this.userName=userName;
        this.password=password;
        this.telephone=telephone;
    }
}
