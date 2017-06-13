package egovframework.WASTE.cmmn;

import java.text.SimpleDateFormat;
import java.util.Date;

/**  
 * @Class Name : DateUtil.java
 * @Description : DateUtil Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2017.05.12   미키    최초생성
 * 
 * @author 미키
 * @since 2017.05.12
 * @version 1.0
 * @see
 * 
 * @ Copyright (C) by 미키 All right reserved.
 */
public class DateUtil {
	
	/**
	 * 날짜 두자리수 표현
	 * @param date - 날짜
	 * @return 날짜
	 * @exception Exception
	 */
	public static String formatDate2(String date) {
		
		String str = String.format("%02d", date);
		return str;
	}
	
	/**
	 * 
	 * 오늘날짜
	 * @param date - 날짜
	 * @return 날짜(yyyyMMdd)
	 * @exception Exception
	 */
	public static String today() {
		Date d = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String str = sdf.format(d);
		return str;
	}
	
	/**
	 * 
	 * 오늘날짜
	 * @param date - 날짜
	 * @return 날짜(yyyyMMdd)
	 * @exception Exception
	 */
	public static String today(String format) {
		Date d = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
        String str = sdf.format(d);
		return str;
	}

}
