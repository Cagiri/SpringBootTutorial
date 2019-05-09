package com.payconiq.assignment.stock.util;

import java.sql.Timestamp;

public class StockUtil {

	
	public static long createRandomTimestamp () {
		long offset = Timestamp.valueOf("2019-01-01 00:00:00").getTime();
		long end = Timestamp.valueOf("2019-09-05 00:00:00").getTime();
		long diff = end - offset + 1;
		Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
		
		return rand.getTime();
	}
}
