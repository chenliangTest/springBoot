package com.springboot.annotation.demo_1;

/**
 * Created by Administrator on 2017/9/3 0003.
 */
@Table("user")
public class Filter {

    @Column("id")
    private int id;

    @Column("userNmae")
    private String userNmae;

    @Column("address")
    private String address;

    @Column("email")
    private String email;

    @Column("age")
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserNmae() {
        return userNmae;
    }

    public void setUserNmae(String userNmae) {
        this.userNmae = userNmae;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
