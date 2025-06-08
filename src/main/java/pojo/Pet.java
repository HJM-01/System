package pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
public class Pet {
    private Integer id;
    private String petName;
    private String petType;
    private String sex;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String pic;
    private Integer state;
    private String remark;

    @TableField(exist = false)
    private List<AdoptAnimal> adoptAnimalList=new ArrayList<>();
    @TableField(exist = false)
    private List<Comment> commentList= new ArrayList<>().reversed();

}
