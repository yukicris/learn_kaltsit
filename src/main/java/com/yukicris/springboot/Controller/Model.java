package com.yukicris.springboot.Controller;

public class Model {
    private String status; //对应那5个功能
    private String peopleId; //对应传的人,可以不传




    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }
}
