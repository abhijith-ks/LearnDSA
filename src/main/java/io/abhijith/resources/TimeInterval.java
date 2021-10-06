package io.abhijith.resources;

public class TimeInterval {

	int beginTime;
	int endTime;
	
	public TimeInterval(int beginTime, int endTime) {
		this.beginTime = beginTime;
		this.endTime = endTime;
	}

	public int getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(int beginTime) {
		this.beginTime = beginTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	
	
}
