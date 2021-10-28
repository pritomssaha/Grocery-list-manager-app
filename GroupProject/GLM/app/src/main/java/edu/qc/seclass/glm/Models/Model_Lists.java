package edu.qc.seclass.glm.Models;

public class Model_Lists {
    public String userList,id;

    public Model_Lists(String userList, String id) {

        this.userList = userList;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserList() {
        return userList;
    }

    public void setUserList(String userList) {
        this.userList = userList;
    }
}

