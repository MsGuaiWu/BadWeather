package com.cl.badweather.bean;

import java.util.List;

/**
 * 逐小时天气数据实体
 * @author: cl
 * @date: 2022/4/1
 */
public class HourlyResponse {

    /**
     * code : 200
     * updateTime : 2022-03-17T12:35+08:00
     * fxLink : http://hfx.link/3js1
     * hourly : [{"fxTime":"2022-03-17T14:00+08:00","temp":"27","icon":"101","text":"多云","wind360":"179","windDir":"南风","windScale":"1-2","windSpeed":"11","humidity":"57","pop":"7","precip":"0.0","pressure":"1007","cloud":"93","dew":"17"},{"fxTime":"2022-03-17T15:00+08:00","temp":"26","icon":"101","text":"多云","wind360":"183","windDir":"南风","windScale":"3-4","windSpeed":"13","humidity":"58","pop":"7","precip":"0.0","pressure":"1006","cloud":"89","dew":"17"},{"fxTime":"2022-03-17T16:00+08:00","temp":"25","icon":"101","text":"多云","wind360":"187","windDir":"南风","windScale":"3-4","windSpeed":"13","humidity":"61","pop":"7","precip":"0.0","pressure":"1006","cloud":"85","dew":"17"},{"fxTime":"2022-03-17T17:00+08:00","temp":"25","icon":"101","text":"多云","wind360":"191","windDir":"西南风","windScale":"3-4","windSpeed":"13","humidity":"65","pop":"7","precip":"0.0","pressure":"1006","cloud":"82","dew":"18"},{"fxTime":"2022-03-17T18:00+08:00","temp":"24","icon":"101","text":"多云","wind360":"186","windDir":"南风","windScale":"3-4","windSpeed":"13","humidity":"73","pop":"7","precip":"0.0","pressure":"1005","cloud":"62","dew":"19"},{"fxTime":"2022-03-17T19:00+08:00","temp":"23","icon":"151","text":"多云","wind360":"174","windDir":"南风","windScale":"3-4","windSpeed":"13","humidity":"81","pop":"7","precip":"0.0","pressure":"1005","cloud":"42","dew":"20"},{"fxTime":"2022-03-17T20:00+08:00","temp":"22","icon":"150","text":"晴","wind360":"168","windDir":"东南风","windScale":"1-2","windSpeed":"11","humidity":"93","pop":"7","precip":"0.0","pressure":"1005","cloud":"22","dew":"20"},{"fxTime":"2022-03-17T21:00+08:00","temp":"21","icon":"150","text":"晴","wind360":"172","windDir":"南风","windScale":"1-2","windSpeed":"11","humidity":"96","pop":"7","precip":"0.0","pressure":"1005","cloud":"25","dew":"21"},{"fxTime":"2022-03-17T22:00+08:00","temp":"21","icon":"150","text":"晴","wind360":"177","windDir":"南风","windScale":"1-2","windSpeed":"9","humidity":"94","pop":"7","precip":"0.0","pressure":"1006","cloud":"28","dew":"20"},{"fxTime":"2022-03-17T23:00+08:00","temp":"20","icon":"151","text":"多云","wind360":"183","windDir":"南风","windScale":"1-2","windSpeed":"9","humidity":"96","pop":"7","precip":"0.0","pressure":"1006","cloud":"31","dew":"20"},{"fxTime":"2022-03-18T00:00+08:00","temp":"19","icon":"151","text":"多云","wind360":"190","windDir":"南风","windScale":"1-2","windSpeed":"7","humidity":"100","pop":"6","precip":"0.0","pressure":"1007","cloud":"37","dew":"19"},{"fxTime":"2022-03-18T01:00+08:00","temp":"19","icon":"151","text":"多云","wind360":"200","windDir":"西南风","windScale":"1-2","windSpeed":"7","humidity":"100","pop":"5","precip":"0.0","pressure":"1008","cloud":"43","dew":"19"},{"fxTime":"2022-03-18T02:00+08:00","temp":"19","icon":"151","text":"多云","wind360":"215","windDir":"西南风","windScale":"1-2","windSpeed":"5","humidity":"100","pop":"5","precip":"0.0","pressure":"1008","cloud":"48","dew":"19"},{"fxTime":"2022-03-18T03:00+08:00","temp":"18","icon":"151","text":"多云","wind360":"227","windDir":"西南风","windScale":"1-2","windSpeed":"5","humidity":"100","pop":"6","precip":"0.0","pressure":"1008","cloud":"55","dew":"18"},{"fxTime":"2022-03-18T04:00+08:00","temp":"18","icon":"151","text":"多云","wind360":"231","windDir":"西南风","windScale":"1-2","windSpeed":"5","humidity":"100","pop":"7","precip":"0.0","pressure":"1007","cloud":"70","dew":"18"},{"fxTime":"2022-03-18T05:00+08:00","temp":"18","icon":"151","text":"多云","wind360":"236","windDir":"西南风","windScale":"1-2","windSpeed":"5","humidity":"100","pop":"7","precip":"0.0","pressure":"1007","cloud":"68","dew":"18"},{"fxTime":"2022-03-18T06:00+08:00","temp":"18","icon":"151","text":"多云","wind360":"243","windDir":"西南风","windScale":"1-2","windSpeed":"5","humidity":"100","pop":"10","precip":"0.0","pressure":"1006","cloud":"78","dew":"18"},{"fxTime":"2022-03-18T07:00+08:00","temp":"19","icon":"101","text":"多云","wind360":"270","windDir":"西风","windScale":"1-2","windSpeed":"5","humidity":"98","pop":"16","precip":"0.0","pressure":"1005","cloud":"89","dew":"19"},{"fxTime":"2022-03-18T08:00+08:00","temp":"20","icon":"101","text":"多云","wind360":"297","windDir":"西北风","windScale":"1-2","windSpeed":"5","humidity":"89","pop":"16","precip":"0.0","pressure":"1005","cloud":"100","dew":"18"},{"fxTime":"2022-03-18T09:00+08:00","temp":"21","icon":"101","text":"多云","wind360":"358","windDir":"北风","windScale":"1-2","windSpeed":"7","humidity":"84","pop":"20","precip":"0.0","pressure":"1005","cloud":"100","dew":"18"},{"fxTime":"2022-03-18T10:00+08:00","temp":"22","icon":"302","text":"雷阵雨","wind360":"356","windDir":"北风","windScale":"1-2","windSpeed":"11","humidity":"80","pop":"60","precip":"1.3","pressure":"1004","cloud":"100","dew":"18"},{"fxTime":"2022-03-18T11:00+08:00","temp":"22","icon":"302","text":"雷阵雨","wind360":"355","windDir":"北风","windScale":"3-4","windSpeed":"13","humidity":"77","pop":"60","precip":"1.3","pressure":"1005","cloud":"100","dew":"18"},{"fxTime":"2022-03-18T12:00+08:00","temp":"23","icon":"101","text":"多云","wind360":"352","windDir":"北风","windScale":"3-4","windSpeed":"13","humidity":"71","pop":"49","precip":"0.0","pressure":"1006","cloud":"99","dew":"17"},{"fxTime":"2022-03-18T13:00+08:00","temp":"24","icon":"101","text":"多云","wind360":"349","windDir":"西北风","windScale":"1-2","windSpeed":"11","humidity":"64","pop":"20","precip":"0.0","pressure":"1006","cloud":"99","dew":"17"}]
     * refer : {"sources":["QWeather","NMC","ECMWF"],"license":["no commercial use"]}
     */

    private String code;
    private String updateTime;
    private String fxLink;
    private ReferBean refer;
    private List<HourlyBean> hourly;

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

    public List<HourlyBean> getHourly() {
        return hourly;
    }

    public void setHourly(List<HourlyBean> hourly) {
        this.hourly = hourly;
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

    public static class HourlyBean {
        /**
         * fxTime : 2022-03-17T14:00+08:00
         * temp : 27
         * icon : 101
         * text : 多云
         * wind360 : 179
         * windDir : 南风
         * windScale : 1-2
         * windSpeed : 11
         * humidity : 57
         * pop : 7
         * precip : 0.0
         * pressure : 1007
         * cloud : 93
         * dew : 17
         */

        private String fxTime;
        private String temp;
        private String icon;
        private String text;
        private String wind360;
        private String windDir;
        private String windScale;
        private String windSpeed;
        private String humidity;
        private String pop;
        private String precip;
        private String pressure;
        private String cloud;
        private String dew;

        public String getFxTime() {
            return fxTime;
        }

        public void setFxTime(String fxTime) {
            this.fxTime = fxTime;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getWind360() {
            return wind360;
        }

        public void setWind360(String wind360) {
            this.wind360 = wind360;
        }

        public String getWindDir() {
            return windDir;
        }

        public void setWindDir(String windDir) {
            this.windDir = windDir;
        }

        public String getWindScale() {
            return windScale;
        }

        public void setWindScale(String windScale) {
            this.windScale = windScale;
        }

        public String getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(String windSpeed) {
            this.windSpeed = windSpeed;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getPop() {
            return pop;
        }

        public void setPop(String pop) {
            this.pop = pop;
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

        public String getCloud() {
            return cloud;
        }

        public void setCloud(String cloud) {
            this.cloud = cloud;
        }

        public String getDew() {
            return dew;
        }

        public void setDew(String dew) {
            this.dew = dew;
        }
    }
}
