package org.launchcode.launchcart.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by LaunchCode
 */
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int uid;

    public int getUid() {
        return uid;
    }
}
