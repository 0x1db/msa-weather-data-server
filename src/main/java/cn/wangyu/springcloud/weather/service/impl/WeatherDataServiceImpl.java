package cn.wangyu.springcloud.weather.service.impl;

import cn.wangyu.springcloud.weather.model.WeatherResponse;
import cn.wangyu.springcloud.weather.service.WeatherDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * 天气数据服务层实现
 *
 * @Author wangyu
 * @Date 2019/10/9 17:12
 * @Version 1.0
 */
@Service("weatherDataService")
public class WeatherDataServiceImpl implements WeatherDataService {

  /**
   * slf4j
   */
  private Logger LOG = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

  /**
   * 第三方天气API地址
   */
  private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

  @Autowired
  private StringRedisTemplate redisTemplate;

  @Override
  public WeatherResponse getDataByCityId(String cityId) {
    String url = WEATHER_URI + "citykey=" + cityId;
    return doGetWeather(url);
  }

  @Override
  public WeatherResponse getDataByCityName(String cityName) {
    String url = WEATHER_URI + "cityName=" + cityName;
    return this.doGetWeather(url);
  }

  private WeatherResponse doGetWeather(String url) {
    String key = url;
    String strBody = null;
    ObjectMapper mapper = new ObjectMapper();
    WeatherResponse response = null;
    ValueOperations<String, String> ops = redisTemplate.opsForValue();
    if (redisTemplate.hasKey(key)) {
      LOG.info("redis has key");
      strBody = ops.get(key);
    } else {
      LOG.info("redis has not key");
      throw new RuntimeException("has not key");
    }

    try {
      response = mapper.readValue(strBody, WeatherResponse.class);
    } catch (IOException e) {
      LOG.error("Error", e);
    }

    return response;
  }
}
