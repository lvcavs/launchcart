package org.launchcode.launchcart.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by LaunchCode
 */
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue
    private int uid;

    public int getUid() {
        return uid;
    }
}
