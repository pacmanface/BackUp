package com.pacmanface.weatherstation;

interface Storage {
	void put(WeatherData wd);
	WeatherData get();
}
