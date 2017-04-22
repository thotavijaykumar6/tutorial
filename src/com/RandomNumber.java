package com;

import java.sql.Timestamp;
import java.util.UUID;

public class RandomNumber {

	public static void main(String[] args) {
		
		//return number of milliseconds since January 1, 1970, 00:00:00 GMT
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println((long)(timestamp.getTime()/1000)-(long)(1492630000));
	}

}
