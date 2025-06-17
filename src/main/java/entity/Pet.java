package entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serializable;
import java.util.Date;


@Date
@NoArgsConstructor
@AllArgsConstructor
public class Pet implements Serializable {
    private Integer id;
    private String petName;
    private String petType;
    private String sex;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String pic;
    private Integer state;
    private String remark;


    public Pet(Integer id, String petName, String petType, String sex, Date birthday, String pic, Integer state, String remark) {
        this.id = id;
        this.petName = petName;
        this.petType = petType;
        this.sex = sex;
        this.birthday = birthday;
        this.pic = pic;
        this.state = state;
        this.remark = remark;
    }


}
