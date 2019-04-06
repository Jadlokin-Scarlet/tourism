package com.tourism.util;

import com.tourism.exception.ServletRequestOutOfBoundsException;

public class ExceptionUtil {

	public static void isInRange(int min,int a,int max,String name) throws ServletRequestOutOfBoundsException {
		if(!MyUtil.isInRange(min,a,max)){
			throw new ServletRequestOutOfBoundsException("参数越界,"+name+"应该在["+min+","+max+"]之间");
		}
	}

	public static void isMoreThanZero(int a,String name) throws ServletRequestOutOfBoundsException {
		if(!MyUtil.isInRange(0,a,999999999)){
			throw new ServletRequestOutOfBoundsException("参数越界,"+name+"应该大于0");
		}
	}

	public static void isMaxAreMax(int min,int max,String name) throws ServletRequestOutOfBoundsException {
		if(Math.max(min,max)!=max){
			throw new ServletRequestOutOfBoundsException(name+"的最小值应大于最大值");
		}
	}

}
