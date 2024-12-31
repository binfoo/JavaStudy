package binfoo;


import lombok.Data;
import lombok.ToString;


@ToString
public class UserVO {
    private Integer id;
    private String username;

    public Integer getId() {
        return id;
    }

    public UserVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserVO setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserVO(){

    }
    public UserVO UserVO(Integer id){
        this.id = id;
        return this;
    }
}
