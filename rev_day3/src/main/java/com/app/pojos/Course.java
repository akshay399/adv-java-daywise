package com.app.pojos;


public enum Course {
	JAVA(70), MERN(76), DBT(72), ANGULAR(76), ADVJAVA(35);
	private int minScore;
	
	private Course(int minScore) {
		this.minScore = minScore;
	}
	
	public int getMinScore() {
		return minScore;
	}
}
