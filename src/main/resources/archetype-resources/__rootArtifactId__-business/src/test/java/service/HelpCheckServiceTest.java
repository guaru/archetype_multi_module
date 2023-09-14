package ${groupId}.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HelpCheckServiceTest {
	
	private HelpCheckService helpCheckServiceSpy;

	@Before
	public void setUp() {
		this.helpCheckServiceSpy = spy(HelpCheckService.class);
	}
	
	@Test
	public void whenHelpCheckThenTrue() {
		assertEquals(true, this.helpCheckServiceSpy.helpCheck());
	}
}
