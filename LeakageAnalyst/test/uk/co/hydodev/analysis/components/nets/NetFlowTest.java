package uk.co.hydodev.analysis.components.nets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.joda.time.DateMidnight;
import org.junit.Before;
import org.junit.Test;

public class NetFlowTest {

	DefaultNetFlow nf;

	@Before
	public void setUp() throws Exception {
		nf = new DefaultNetFlow();
	}

	@Test
	public void testMNFOnTwoDays() {
		final double mnf0 = 23.89;
		final DateMidnight dt0 = new DateMidnight(2013,5,5);
		nf.setMNF(dt0, mnf0);
		final double mnf1 = 98.32;
		final DateMidnight dt1 = new DateMidnight(2013,5,6);
		nf.setMNF(dt1, mnf1);
		assertThat(nf.getMNF(dt0), equalTo(mnf0));
		assertThat(nf.getMNF(dt1), equalTo(mnf1));
	}
}
