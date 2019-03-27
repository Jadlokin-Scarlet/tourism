package com.tourism.util;

import java.util.List;

public class MathUtil {

	public static boolean isInRange(int min,int a,int max){
		return a>=min&&a<=max;
	}

	public static boolean isMoreThanZero(int a){
		return MathUtil.isInRange(0,a,999999999);
	}

}
