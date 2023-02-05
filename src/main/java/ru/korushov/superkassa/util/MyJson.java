package ru.korushov.superkassa.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author Vitaly Korushov
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyJson implements Serializable {

    private int current;

    public MyJson(int current) {
        this.current = current;
    }

    public MyJson(String string, int current) {
        String s = string;
        this.current = current;
    }



    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }
}
