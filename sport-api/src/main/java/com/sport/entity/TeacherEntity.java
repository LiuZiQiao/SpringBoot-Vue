package com.sport.entity;

import com.sport.common.entity.BasicEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("")
public class TeacherEntity extends BasicEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", name = "id")
    private Long id;

    @ApiModelProperty(value = "姓名", name = "name")
    private String name;

    @ApiModelProperty(value = "密码MD5加密", name = "password")
    private String password;

    @ApiModelProperty(value = "教师编号", name = "code")
    private String code;

    @ApiModelProperty(value = "出生日期", name = "birthday")
    private String birthday;

    @ApiModelProperty(value = "性别（1：男；2：女）", name = "sex")
    private Byte sex;

    @ApiModelProperty(value = "电话", name = "phone")
    private String phone;

    @ApiModelProperty(value = "身份证", name = "identity")
    private String identity;

    @ApiModelProperty(value = "民族", name = "nation")
    private String nation;

    @ApiModelProperty(value = "国籍", name = "nationality")
    private String nationality;

    @ApiModelProperty(value = "籍贯", name = "nativePlace")
    private String nativePlace;

    @ApiModelProperty(value = "教师科目", name = "major")
    private String major;

    @ApiModelProperty(value = "来校时间", name = "entranceDate")
    private String entranceDate;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(String entranceDate) {
        this.entranceDate = entranceDate;
    }
}