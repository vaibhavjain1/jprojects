package main.java.com.erstudio.tsversionchange.model;

public class VersionFormat {

    String format;
    String majorVersion;
    String minorVersion;
    String revisionNumber;
    String buildNumber;

    public VersionFormat(String majorVersion, String minorVersion, String revisionNumber, String buildNumber) {
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.revisionNumber = revisionNumber;
        this.buildNumber = buildNumber;
    }

    public VersionFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(String majorVersion) {
        this.majorVersion = majorVersion;
    }

    public String getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(String minorVersion) {
        this.minorVersion = minorVersion;
    }

    public String getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(String revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }
}
