package cn.wangyu.springcloud.weather.service;

import cn.wangyu.springcloud.weather.model.WeatherResponse;

/**
 * 天气数据服务层
 *
 * @Author wangyu
 * @Date 2019/10/9 16:38
 * @Version 1.0
 */
public interface WeatherDataService {

  /**
   * @Desc 根据城市名称查询天气数据
   * @Author wangyu
   * @CreateDate 2019/10/9 17:11
   */
  WeatherResponse getDataByCityId(String cityId);

  /**
   * @Desc 根据城市名称查询天气数据
   * @Author wangyu
   * @CreateDate 2019/10/9 17:11
   */
  WeatherResponse getDataByCityName(String cityName);
}
