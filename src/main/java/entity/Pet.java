package entity;

public class Pet {
    private int id;
    private String petname;
    private String petType;
    private String sex;
    private int birthday;
    private int state;
    private String remark;

    public String getRemark(String remark) {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getState(int state) {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getBirthday(int birthday) {
        return this.birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getSex(String sex) {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPetType(String petType) {
        return this.petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetname(String petname) {
        return this.petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
