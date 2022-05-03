package com.cl.badweather.bean;

import java.util.List;

/**
 * 太阳和月亮数据实体
 * @author: cl
 * @date: 2022/5/1
 */
public class SunMoonResponse {


    /**
     * code : 200
     * updateTime : 2022-05-01T21:00+08:00
     * fxLink : http://hfx.link/2ax1
     * sunrise : 2022-05-01T05:13+08:00
     * sunset : 2022-05-01T19:09+08:00
     * moonrise : 2022-05-01T05:27+08:00
     * moonset : 2022-05-01T19:38+08:00
     * moonPhase : [{"fxTime":"2022-05-01T00:00+08:00","value":"1.00","name":"残月","illumination":"0","icon":"807"},{"fxTime":"2022-05-01T01:00+08:00","value":"0.00","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T02:00+08:00","value":"0.00","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T03:00+08:00","value":"0.00","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T04:00+08:00","value":"0.01","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T05:00+08:00","value":"0.01","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T06:00+08:00","value":"0.01","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T07:00+08:00","value":"0.01","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T08:00+08:00","value":"0.01","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T09:00+08:00","value":"0.01","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T10:00+08:00","value":"0.01","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T11:00+08:00","value":"0.01","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T12:00+08:00","value":"0.01","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T13:00+08:00","value":"0.02","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T14:00+08:00","value":"0.02","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T15:00+08:00","value":"0.02","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T16:00+08:00","value":"0.02","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T17:00+08:00","value":"0.02","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T18:00+08:00","value":"0.02","name":"峨眉月","illumination":"0","icon":"801"},{"fxTime":"2022-05-01T19:00+08:00","value":"0.02","name":"峨眉月","illumination":"1","icon":"801"},{"fxTime":"2022-05-01T20:00+08:00","value":"0.02","name":"峨眉月","illumination":"1","icon":"801"},{"fxTime":"2022-05-01T21:00+08:00","value":"0.03","name":"峨眉月","illumination":"1","icon":"801"},{"fxTime":"2022-05-01T22:00+08:00","value":"0.03","name":"峨眉月","illumination":"1","icon":"801"},{"fxTime":"2022-05-01T23:00+08:00","value":"0.03","name":"峨眉月","illumination":"1","icon":"801"}]
     * refer : {"sources":["QWeather"],"license":["no commercial use"]}
     */

    private String code;
    private String updateTime;
    private String fxLink;
    private String sunrise;
    private String sunset;
    private String moonrise;
    private String moonset;
    private ReferBean refer;
    private List<MoonPhaseBean> moonPhase;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getFxLink() {
        return fxLink;
    }

    public void setFxLink(String fxLink) {
        this.fxLink = fxLink;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    public String getMoonset() {
        return moonset;
    }

    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    public ReferBean getRefer() {
        return refer;
    }

    public void setRefer(ReferBean refer) {
        this.refer = refer;
    }

    public List<MoonPhaseBean> getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(List<MoonPhaseBean> moonPhase) {
        this.moonPhase = moonPhase;
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

    public static class MoonPhaseBean {
        /**
         * fxTime : 2022-05-01T00:00+08:00
         * value : 1.00
         * name : 残月
         * illumination : 0
         * icon : 807
         */

        private String fxTime;
        private String value;
        private String name;
        private String illumination;
        private String icon;

        public String getFxTime() {
            return fxTime;
        }

        public void setFxTime(String fxTime) {
            this.fxTime = fxTime;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIllumination() {
            return illumination;
        }

        public void setIllumination(String illumination) {
            this.illumination = illumination;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
