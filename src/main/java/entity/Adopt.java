package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Adopt implements Serializable {
    private int id;
    private String userName;
    private String petName;
    private String sex;
    private String telephone;
    private String email;
    private String address;
    private String status;
}