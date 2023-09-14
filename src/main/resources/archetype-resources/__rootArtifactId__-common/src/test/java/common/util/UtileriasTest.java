package ${groupId}.common.util;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UtileriasTest {

	private Utilerias utileriasMock;

	@Before
	public void setUp() {
		utileriasMock = mock(Utilerias.class);
	}

	@SuppressWarnings("static-access")
	@Test
	public void whenObtenerFechaConFormatoThenReturnDate() {
		ZoneId systemTimeZone = ZoneId.systemDefault();
		LocalDate localDate = LocalDate.parse("2023-01-19");
		ZonedDateTime zonedDateTime = localDate.atStartOfDay(systemTimeZone);
		Date date = Date.from(zonedDateTime.toInstant());

		String dateFormatted = utileriasMock.formatDate(date);
		assertEquals("19-01-2023", dateFormatted);
	}

	@SuppressWarnings("static-access")
	@Test
	public void whenObtenerFechaConFormatoThenReturnNull() {
		Date date = null;
		assertNull(utileriasMock.formatDate(date));
	}

	@SuppressWarnings("static-access")
	@Test
	public void whenFormatDateddMMyyToddMMyyyy() {
		assertEquals(utileriasMock.formatDate("12/05/23"), "12/05/2023");
	}

	@SuppressWarnings("static-access")
	@Test
	public void whenFormatDateddMMyyToddMMyyyyException() {
		assertEquals(utileriasMock.formatDate(""), "");
	}

	
}
