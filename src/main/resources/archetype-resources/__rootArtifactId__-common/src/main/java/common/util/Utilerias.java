package ${groupId}.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ${groupId}.common.constants.Constantes;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Utilerias {

	/**
	 * Format Date
	 *
	 * @param Date date
	 * @return: String - formatter "dd-MM-yyyy"
	 */
	public static String formatDate(Date date) {
		String fechaFormat = null;
		SimpleDateFormat dateFormat;

		if (date != null) {
			dateFormat = new SimpleDateFormat(Constantes.FORMAT_DD_MM_YYYY);
			fechaFormat = dateFormat.format(date);
		}
		return fechaFormat;
	}

	/**
	 * Format date from dd/MM/yy to dd/MM/yyyy
	 * 
	 * @param fecha
	 * @return string
	 */
	public static String formatDate(String fecha) {
		SimpleDateFormat fromFormat = new SimpleDateFormat("dd/MM/yy");
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fechaFormat = "";
		try {
			fechaFormat = myFormat.format(fromFormat.parse(fecha.trim())).trim();
		} catch (ParseException e) {
		}

		return fechaFormat;
	}
}
