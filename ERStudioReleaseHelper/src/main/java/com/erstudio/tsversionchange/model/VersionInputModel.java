package main.java.com.erstudio.tsversionchange.model;

import main.java.com.erstudio.model.UpgradeTypeEnum;

/**
 * @author shrey.pasari
 * @description User Input Model
 */
public class VersionInputModel {
    String filePath;
    String oldVersion;
    String newVersion;
    String GUID;
    UpgradeTypeEnum upgradeType;
    String productName;


	public VersionInputModel(String filePath, String oldVersion, String newVersion, String GUID, UpgradeTypeEnum upgradeType, String productName) {
        this.filePath = filePath;
        this.oldVersion = oldVersion;
        this.newVersion = newVersion;
        this.GUID = GUID;
        this.upgradeType = upgradeType;
        this.productName = productName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getOldVersion() {
        return oldVersion;
    }

    public void setOldVersion(String oldVersion) {
        this.oldVersion = oldVersion;
    }

    public String getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(String newVersion) {
        this.newVersion = newVersion;
    }

    public String getGUID() {
        return GUID;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public UpgradeTypeEnum getUpgradeType() {
        return upgradeType;
    }

    public void setUpgradeType(UpgradeTypeEnum upgradeType) {
        this.upgradeType = upgradeType;
    }
    
    public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
