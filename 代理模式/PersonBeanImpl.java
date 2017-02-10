package com.designPattern.proxy;

/**
 * 每个人都可以维护自己的信息 但是评分不能自己维护 需要别人维护
 * @author ysj
 *
 */
public class PersonBeanImpl implements PersonBean{

	private String name;
	private String gender;
	private String interests;
	private int rating;
	private int ratingCount = 0;
	
	@Override
	public String getName() {
		return name;	
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public String getInterests() {
		return interests;
	}

	@Override
	public int getHotOrNotRating() {
		if (ratingCount == 0) return 0;
		return (rating/ratingCount);
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public void setInterests(String interests) {
		this.interests = interests;
	}

	// 只有外人可以对自己评价，自己不能对自己评价
	@Override
	public void setHotOrNotRating(int rating) {
		this.rating += rating;	
		ratingCount++;
	}

}
