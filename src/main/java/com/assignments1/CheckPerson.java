package com.assignments1;

public class CheckPerson {

	int minAge;
	int maxAge;

	public CheckPerson() {
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public CheckPerson(int minAge, int maxAge) {
		super();
		this.minAge = minAge;
		this.maxAge = maxAge;
	}

	@Override
	public String toString() {
		return "CheckPerson [minAge=" + minAge + ", maxAge=" + maxAge + "]";
	}
}
