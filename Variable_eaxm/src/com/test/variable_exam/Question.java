package com.test.variable_exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question {
	int index;
	List<String> list;
	
	List<String> shuffle(String[] question){
		list = Arrays.asList(question);
		Collections.shuffle(list);
		return list;
	}
	
	int pick(){
		index = (int) (Math.random()*4);
		return index;
	}
	
	
	
}
