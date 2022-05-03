package com.cl.badweather.bean;

import java.util.List;

/**
 * 天气预报数据实体
 * @author: cl
 * @date: 2022/3/21
 */
public class DailyResponse {

    /**
     * code : 200
     * updateTime : 2022-03-17T10:35+08:00
     * fxLink : http://hfx.link/3js1
     * daily : [{"fxDate":"2022-03-17","sunrise":"06:34","sunset":"18:36","moonrise":"17:45","moonset":"06:36","moonPhase":"盈凸月","moonPhaseIcon":"803","tempMax":"27","tempMin":"18","iconDay":"104","textDay":"阴","iconNight":"104","textNight":"阴","wind360Day":"0","windDirDay":"北风","windScaleDay":"1-2","windSpeedDay":"3","wind360Night":"0","windDirNight":"北风","windScaleNight":"1-2","windSpeedNight":"3","humidity":"71","precip":"0.0","pressure":"1005","vis":"24","cloud":"25","uvIndex":"5"},{"fxDate":"2022-03-18","sunrise":"06:33","sunset":"18:37","moonrise":"18:41","moonset":"07:12","moonPhase":"满月","moonPhaseIcon":"804","tempMax":"27","tempMin":"20","iconDay":"302","textDay":"雷阵雨","iconNight":"151","textNight":"多云","wind360Day":"0","windDirDay":"北风","windScaleDay":"1-2","windSpeedDay":"3","wind360Night":"0","windDirNight":"北风","windScaleNight":"1-2","windSpeedNight":"3","humidity":"74","precip":"2.5","pressure":"1005","vis":"25","cloud":"60","uvIndex":"2"},{"fxDate":"2022-03-19","sunrise":"06:32","sunset":"18:37","moonrise":"19:39","moonset":"07:48","moonPhase":"亏凸月","moonPhaseIcon":"805","tempMax":"29","tempMin":"22","iconDay":"104","textDay":"阴","iconNight":"104","textNight":"阴","wind360Day":"0","windDirDay":"北风","windScaleDay":"1-2","windSpeedDay":"3","wind360Night":"0","windDirNight":"北风","windScaleNight":"1-2","windSpeedNight":"3","humidity":"72","precip":"0.0","pressure":"1009","vis":"24","cloud":"25","uvIndex":"2"}]
     * refer : {"sources":["QWeather","NMC","ECMWF"],"license":["no commercial use"]}
     */

    private String code;
    private String updateTime;
    private String fxLink;
    private ReferBean refer;
    private List<DailyBean> daily;

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

    public ReferBean getRefer() {
        return refer;
    }

    public void setRefer(ReferBean refer) {
        this.refer = refer;
    }

    public List<DailyBean> getDaily() {
        return daily;
    }

    public void setDaily(List<DailyBean> daily) {
        this.daily = daily;
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

    public static class DailyBean {
        /**
         * fxDate : 2022-03-17
         * sunrise : 06:34
         * sunset : 18:36
         * moonrise : 17:45
         * moonset : 06:36
         * moonPhase : 盈凸月
         * moonPhaseIcon : 803
         * tempMax : 27
         * tempMin : 18
         * iconDay : 104
         * textDay : 阴
         * iconNight : 104
         * textNight : 阴
         * wind360Day : 0
         * windDirDay : 北风
         * windScaleDay : 1-2
         * windSpeedDay : 3
         * wind360Night : 0
         * windDirNight : 北风
         * windScaleNight : 1-2
         * windSpeedNight : 3
         * humidity : 71
         * precip : 0.0
         * pressure : 1005
         * vis : 24
         * cloud : 25
         * uvIndex : 5
         */

        private String fxDate;
        private String sunrise;
        private String sunset;
        private String moonrise;
        private String moonset;
        private String moonPhase;
        private String moonPhaseIcon;
        private String tempMax;
        private String tempMin;
        private String iconDay;
        private String textDay;
        private String iconNight;
        private String textNight;
        private String wind360Day;
        private String windDirDay;
        private String windScaleDay;
        private String windSpeedDay;
        private String wind360Night;
        private String windDirNight;
        private String windScaleNight;
        private String windSpeedNight;
        private String humidity;
        private String precip;
        private String pressure;
        private String vis;
        private String cloud;
        private String uvIndex;

        public String getFxDate() {
            return fxDate;
        }

        public void setFxDate(String fxDate) {
            this.fxDate = fxDate;
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

        public String getMoonPhase() {
            return moonPhase;
        }

        public void setMoonPhase(String moonPhase) {
            this.moonPhase = moonPhase;
        }

        public String getMoonPhaseIcon() {
            return moonPhaseIcon;
        }

        public void setMoonPhaseIcon(String moonPhaseIcon) {
            this.moonPhaseIcon = moonPhaseIcon;
        }

        public String getTempMax() {
            return tempMax;
        }

        public void setTempMax(String tempMax) {
            this.tempMax = tempMax;
        }

        public String getTempMin() {
            return tempMin;
        }

        public void setTempMin(String tempMin) {
            this.tempMin = tempMin;
        }

        public String getIconDay() {
            return iconDay;
        }

        public void setIconDay(String iconDay) {
            this.iconDay = iconDay;
        }

        public String getTextDay() {
            return textDay;
        }

        public void setTextDay(String textDay) {
            this.textDay = textDay;
        }

        public String getIconNight() {
            return iconNight;
        }

        public void setIconNight(String iconNight) {
            this.iconNight = iconNight;
        }

        public String getTextNight() {
            return textNight;
        }

        public void setTextNight(String textNight) {
            this.textNight = textNight;
        }

        public String getWind360Day() {
            return wind360Day;
        }

        public void setWind360Day(String wind360Day) {
            this.wind360Day = wind360Day;
        }

        public String getWindDirDay() {
            return windDirDay;
        }

        public void setWindDirDay(String windDirDay) {
            this.windDirDay = windDirDay;
        }

        public String getWindScaleDay() {
            return windScaleDay;
        }

        public void setWindScaleDay(String windScaleDay) {
            this.windScaleDay = windScaleDay;
        }

        public String getWindSpeedDay() {
            return windSpeedDay;
        }

        public void setWindSpeedDay(String windSpeedDay) {
            this.windSpeedDay = windSpeedDay;
        }
        //夜间风向360角度
        public String getWind360Night() {
            return wind360Night;
        }

        public void setWind360Night(String wind360Night) {
            this.wind360Night = wind360Night;
        }
        //夜间风向
        public String getWindDirNight() {
            return windDirNight;
        }

        public void setWindDirNight(String windDirNight) {
            this.windDirNight = windDirNight;
        }
        //夜间风力
        public String getWindScaleNight() {
            return windScaleNight;
        }

        public void setWindScaleNight(String windScaleNight) {
            this.windScaleNight = windScaleNight;
        }
        //风速夜间
        public String getWindSpeedNight() {
            return windSpeedNight;
        }

        public void setWindSpeedNight(String windSpeedNight) {
            this.windSpeedNight = windSpeedNight;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getPrecip() {
            return precip;
        }

        public void setPrecip(String precip) {
            this.precip = precip;
        }

        public String getPressure() {
            return pressure;
        }

        public void setPressure(String pressure) {
            this.pressure = pressure;
        }

        public String getVis() {
            return vis;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public String getCloud() {
            return cloud;
        }

        public void setCloud(String cloud) {
            this.cloud = cloud;
        }

        public String getUvIndex() {
            return uvIndex;
        }

        public void setUvIndex(String uvIndex) {
            this.uvIndex = uvIndex;
        }
    }
}
