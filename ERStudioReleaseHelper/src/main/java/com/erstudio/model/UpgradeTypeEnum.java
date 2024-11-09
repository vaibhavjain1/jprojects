package main.java.com.erstudio.model;

import main.java.com.erstudio.constants.Constants;

/**
 * @author akshit.arora
 * for upgrade type Enum
 */
public enum UpgradeTypeEnum {

    MAJOR_OR_MINOR_UPGRADE(Constants.MAJOR_OR_MINOR_UPGRADE),
    PATCH_UPGRADE(Constants.PATCH_UPGRADE);

    // declaring private variable for getting values
    private String action;

    // getter method
    public String getAction() {
        return this.action;
    }

    // enum constructor
    private UpgradeTypeEnum(String action) {
        this.action = action;
    }
}