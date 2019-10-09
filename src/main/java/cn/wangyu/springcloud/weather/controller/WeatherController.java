package cn.wangyu.springcloud.weather.controller;

import cn.wangyu.springcloud.weather.model.WeatherResponse;
import cn.wangyu.springcloud.weather.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 天气数据控制器
 *
 * @Author wangyu
 * @Date 2019/10/9 17:41
 * @Version 1.0
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

  @Autowired
  private WeatherDataService weatherDataService;

  @GetMapping("/cityId/{cityId}")
  public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId) {
    return weatherDataService.getDataByCityId(cityId);
  }

  @GetMapping("/cityName/{cityName}")
  public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName) {
    return weatherDataService.getDataByCityName(cityName);
  }
}
