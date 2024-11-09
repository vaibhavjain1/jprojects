package main.java.com.erstudio.tsversionchange.model;

/**
 * @author rajat.batra
 * @description contains data of excel file
 */
public class ExcelModel {
    String filepath;
    String fullVersion;
    String patchVersion;
    VersionFormat versionFormat;
    String customData;
    String operationType;

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFullVersion() {
        return fullVersion;
    }

    public void setFullVersion(String fullVersion) {
        this.fullVersion = fullVersion;
    }

    public String getPatchVersion() {
        return patchVersion;
    }

    public void setPatchVersion(String patchVersion) {
        this.patchVersion = patchVersion;
    }

    public VersionFormat getVersionFormat() {
        return versionFormat;
    }

    public void setVersionFormat(VersionFormat versionFormat) {
        this.versionFormat = versionFormat;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
