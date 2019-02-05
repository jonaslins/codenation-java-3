package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static Date stringToDate(String strToDate) throws ParseException{
		Date dataConvertida = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		dataConvertida = format.parse(strToDate);

		return dataConvertida;
	}

}
