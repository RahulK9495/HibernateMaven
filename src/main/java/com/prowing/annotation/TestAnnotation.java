package com.prowing.annotation;

import java.lang.reflect.Method;

public class TestAnnotation {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {

		
		Method method= UseOfAnnotation.class.getMethod("myMethod");
		
		if(method.isAnnotationPresent(MyAnnotation.class))
		{
			MyAnnotation annotation=method.getAnnotation(MyAnnotation.class);
			System.out.println("Annotation value: "+ annotation.value());
		}
		else
		{
			System.out.println("Annoatation is not present");
		}
	}

}
