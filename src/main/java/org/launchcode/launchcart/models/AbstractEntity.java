package org.launchcode.launchcart.models;


import java.util.Random;

/**
 * Created by LaunchCode
 */
public class AbstractEntity {

    private int uid;

    public int getUid() {
        return uid;
    }

    AbstractEntity() {
        this.uid = new Random().nextInt();
    }
}
