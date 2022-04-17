package com.cl.badweather.bean;

import java.util.List;

/**
 * 世界城市返回实体
 * @author: cl
 * @date: 2022/4/10
 */
public class WorldCityResponse {

    /**
     * code : 200
     * topCityList : [{"name":"莫斯科","id":"554F","lat":"55.75583","lon":"37.61777","adm2":"Moscow Oblast","adm1":"莫斯科","country":"俄罗斯","tz":"Europe/Moscow","utcOffset":"+03:00","isDst":"0","type":"city","rank":"10","fxLink":"http://hfx.link/1zgq1"},{"name":"Eastern Administrative Okrug","id":"FF15","lat":"55.78333","lon":"37.76666","adm2":"Moscow Oblast","adm1":"莫斯科","country":"俄罗斯","tz":"Europe/Moscow","utcOffset":"+03:00","isDst":"0","type":"city","rank":"45","fxLink":"http://hfx.link/24xs1"},{"name":"North-Eastern Administrative Okrug","id":"75FF","lat":"55.83333","lon":"37.61666","adm2":"Moscow Oblast","adm1":"莫斯科","country":"俄罗斯","tz":"Europe/Moscow","utcOffset":"+03:00","isDst":"0","type":"city","rank":"55","fxLink":"http://hfx.link/24yq1"},{"name":"圣彼得堡","id":"95376","lat":"59.93899","lon":"30.31500","adm2":"圣彼得堡","adm1":"圣彼得堡","country":"俄罗斯","tz":"Europe/Moscow","utcOffset":"+03:00","isDst":"0","type":"city","rank":"11","fxLink":"http://hfx.link/1zce1"},{"name":"South-Eastern Administrative Okrug","id":"CBAF0","lat":"55.66666","lon":"37.61666","adm2":"Moscow Oblast","adm1":"莫斯科","country":"俄罗斯","tz":"Europe/Moscow","utcOffset":"+03:00","isDst":"0","type":"city","rank":"55","fxLink":"http://hfx.link/250i1"}]
     * refer : {"sources":["QWeather"],"license":["commercial license"]}
     */

    private String code;
    private ReferBean refer;
    private List<TopCityListBean> topCityList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ReferBean getRefer() {
        return refer;
    }

    public void setRefer(ReferBean refer) {
        this.refer = refer;
    }

    public List<TopCityListBean> getTopCityList() {
        return topCityList;
    }

    public void setTopCityList(List<TopCityListBean> topCityList) {
        this.topCityList = topCityList;
    }

    public static class ReferBean {
        private List<String> sources;
        private List<String> license;

        public List<String> getSources() {
            return sources;
        }

        public void setSources(List<String> sources) {
            this.sources = sources;
        }

        public List<String> getLicense() {
            return license;
        }

        public void setLicense(List<String> license) {
            this.license = license;
        }
    }

    public static class TopCityListBean {
        /**
         * name : 莫斯科
         * id : 554F
         * lat : 55.75583
         * lon : 37.61777
         * adm2 : Moscow Oblast
         * adm1 : 莫斯科
         * country : 俄罗斯
         * tz : Europe/Moscow
         * utcOffset : +03:00
         * isDst : 0
         * type : city
         * rank : 10
         * fxLink : http://hfx.link/1zgq1
         */

        private String name;
        private String id;
        private String lat;
        private String lon;
        private String adm2;
        private String adm1;
        private String country;
        private String tz;
        private String utcOffset;
        private String isDst;
        private String type;
        private String rank;
        private String fxLink;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getAdm2() {
            return adm2;
        }

        public void setAdm2(String adm2) {
            this.adm2 = adm2;
        }

        public String getAdm1() {
            return adm1;
        }

        public void setAdm1(String adm1) {
            this.adm1 = adm1;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getTz() {
            return tz;
        }

        public void setTz(String tz) {
            this.tz = tz;
        }

        public String getUtcOffset() {
            return utcOffset;
        }

        public void setUtcOffset(String utcOffset) {
            this.utcOffset = utcOffset;
        }

        public String getIsDst() {
            return isDst;
        }

        public void setIsDst(String isDst) {
            this.isDst = isDst;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getFxLink() {
            return fxLink;
        }

        public void setFxLink(String fxLink) {
            this.fxLink = fxLink;
        }
    }
}
