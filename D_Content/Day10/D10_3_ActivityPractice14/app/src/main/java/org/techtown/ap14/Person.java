package org.techtown.ap14;

public class Person {
    String index;
    String name;
    String mobile;

    public Person(String index, String name, String mobile) {
        this.index = index;
        this.name = name;
        this.mobile = mobile;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
