package com.designPattern.observer;

public class ObserverTest {

	public static void main(String[] args) {
		// 订阅者
		WeatherData weatherData = new WeatherData();
		// 发布者
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		
		weatherData.setMeasurementsAndPull(80, 65, 30.4f);
		weatherData.setMeasurementsAndPull(82, 70, 29.2f);
		weatherData.setMeasurementsAndPull(78, 90, 29.2f);
		
		/*weatherData.setMeasurementsAndPush(80, 65, 30.4f);
		weatherData.setMeasurementsAndPush(82, 70, 29.2f);
		weatherData.setMeasurementsAndPush(78, 90, 29.2f);*/
	}
	
}
