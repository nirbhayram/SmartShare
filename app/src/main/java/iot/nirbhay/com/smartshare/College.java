package iot.nirbhay.com.smartshare;

/**
 * Created by Nirbhay on 12-04-2018.
 */

public class College {

    private String id;
    private String name;

    public College(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
