package uk.co.hydodev.analysis.components.leakage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.joda.time.DateMidnight;
import org.junit.Before;
import org.junit.Test;

public class TestLeakage {

	private Leakage leakage;

	@Before
	public void setUp() throws Exception {
		leakage = new Leakage();
	}

	@Test
	public void testLeakageOnMay5th() {

		final DateMidnight dt = new DateMidnight(2013,5,5);
		assertThat(leakage.getLeakage(dt), equalTo(20.5d));
	}

	@Test
	public void testLeakageOnMay6th() {
		final DateMidnight dt = new DateMidnight(2013,5,6);
		assertThat(leakage.getLeakage(dt), equalTo(20.5d));
	}

}
