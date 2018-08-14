package cn.hacz.edu.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/8/14 时间:21:09
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
@ConfigurationProperties(prefix = "pathconfig")
@EnableConfigurationProperties({FtpConfig.class})
public class FtpConfig {
    private String ftpHost;
    private int ftpPort;
    private String ftpUserName;
    private String ftpPassWord;
    private String ftpOperativePath;
    private String ftpCloudPath;
    private String ftpPortalPath;
    private String ftpMobilePath;
    private String ftpPropertyPath;

    public String getFtpHost() {
        return ftpHost;
    }

    public void setFtpHost(String ftpHost) {
        this.ftpHost = ftpHost;
    }

    public int getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(int ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getFtpUserName() {
        return ftpUserName;
    }

    public void setFtpUserName(String ftpUserName) {
        this.ftpUserName = ftpUserName;
    }

    public String getFtpPassWord() {
        return ftpPassWord;
    }

    public void setFtpPassWord(String ftpPassWord) {
        this.ftpPassWord = ftpPassWord;
    }

    public String getFtpOperativePath() {
        return ftpOperativePath;
    }

    public void setFtpOperativePath(String ftpOperativePath) {
        this.ftpOperativePath = ftpOperativePath;
    }

    public String getFtpCloudPath() {
        return ftpCloudPath;
    }

    public void setFtpCloudPath(String ftpCloudPath) {
        this.ftpCloudPath = ftpCloudPath;
    }

    public String getFtpPortalPath() {
        return ftpPortalPath;
    }

    public void setFtpPortalPath(String ftpPortalPath) {
        this.ftpPortalPath = ftpPortalPath;
    }

    public String getFtpMobilePath() {
        return ftpMobilePath;
    }

    public void setFtpMobilePath(String ftpMobilePath) {
        this.ftpMobilePath = ftpMobilePath;
    }

    public String getFtpPropertyPath() {
        return ftpPropertyPath;
    }

    public void setFtpPropertyPath(String ftpPropertyPath) {
        this.ftpPropertyPath = ftpPropertyPath;
    }
}
