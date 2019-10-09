package cn.wangyu.springcloud.weather.model;

import java.io.Serializable;
import java.util.List;

/**
 * 天气
 *
 * @Author wangyu
 * @Date 2019/10/9 16:40
 * @Version 1.0
 */
public class Weather implements Serializable {

  private static final long serialVersionUID = 4334675782637335860L;

  //城市
  private String city;

  private String aqi;
  //感冒
  private String ganmao;
  //温度
  private String wendu;
  //昨日天气
  private Yesterday yesterday;
  //预告
  private List<Forecast> forecast;

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getAqi() {
    return aqi;
  }

  public void setAqi(String aqi) {
    this.aqi = aqi;
  }

  public String getGanmao() {
    return ganmao;
  }

  public void setGanmao(String ganmao) {
    this.ganmao = ganmao;
  }

  public String getWendu() {
    return wendu;
  }

  public void setWendu(String wendu) {
    this.wendu = wendu;
  }

  public Yesterday getYesterday() {
    return yesterday;
  }

  public void setYesterday(Yesterday yesterday) {
    this.yesterday = yesterday;
  }

  public List<Forecast> getForecast() {
    return forecast;
  }

  public void setForecast(List<Forecast> forecast) {
    this.forecast = forecast;
  }
}
