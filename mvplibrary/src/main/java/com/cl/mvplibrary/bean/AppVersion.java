package com.cl.mvplibrary.bean;

import org.litepal.crud.LitePalSupport;

/**
 * @author: cl
 * @date: 2022/4/30
 */
public class AppVersion  extends LitePalSupport {

    /**
     * name : 坏天气
     * version : 1
     * changelog : 天气APP测试版本
     * updated_at : 1651313699
     * versionShort : 1.0
     * build : 1
     * installUrl : https://download.bq04.com/apps/626d0bf4f945484e5998ad9d/install?download_token=06f34cdba01e368b2a5fbcd6abf054dc&source=update
     * install_url : https://download.bq04.com/apps/626d0bf4f945484e5998ad9d/install?download_token=06f34cdba01e368b2a5fbcd6abf054dc&source=update
     * direct_install_url : https://download.bq04.com/apps/626d0bf4f945484e5998ad9d/install?download_token=06f34cdba01e368b2a5fbcd6abf054dc&source=update
     * update_url : https://d.6short.com/badweather
     * binary : {"fsize":1439631}
     */

    private String name;
    private String version;
    private String changelog;
    private int updated_at;
    private String versionShort;
    private String build;
    private String installUrl;
    private String install_url;
    private String direct_install_url;
    private String update_url;
    private BinaryBean binary;

    public String getAppSize() {
        return appSize;
    }

    public void setAppSize(String appSize) {
        this.appSize = appSize;
    }

    private String appSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getChangelog() {
        return changelog;
    }

    public void setChangelog(String changelog) {
        this.changelog = changelog;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }

    public String getVersionShort() {
        return versionShort;
    }

    public void setVersionShort(String versionShort) {
        this.versionShort = versionShort;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getInstallUrl() {
        return installUrl;
    }

    public void setInstallUrl(String installUrl) {
        this.installUrl = installUrl;
    }

    public String getInstall_url() {
        return install_url;
    }

    public void setInstall_url(String install_url) {
        this.install_url = install_url;
    }

    public String getDirect_install_url() {
        return direct_install_url;
    }

    public void setDirect_install_url(String direct_install_url) {
        this.direct_install_url = direct_install_url;
    }

    public String getUpdate_url() {
        return update_url;
    }

    public void setUpdate_url(String update_url) {
        this.update_url = update_url;
    }

    public BinaryBean getBinary() {
        return binary;
    }

    public void setBinary(BinaryBean binary) {
        this.binary = binary;
    }

    public static class BinaryBean {
        /**
         * fsize : 1439631
         */

        private int fsize;

        public int getFsize() {
            return fsize;
        }

        public void setFsize(int fsize) {
            this.fsize = fsize;
        }
    }
}
