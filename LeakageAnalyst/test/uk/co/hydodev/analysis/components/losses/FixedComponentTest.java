package uk.co.hydodev.analysis.components.losses;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class FixedComponentTest {

	private static final double ERROR = 0.0000001;
	FixedComponent fc;


	@Before
	public void setUp() throws Exception {
		fc = new FixedComponent();
	}

	@Test
	public void testValue() {
		final Double testValue = 14.45;
		fc.setValue(testValue);
		assertThat(fc.getValue(), is(closeTo(testValue,allowingForAn(ERROR))));
	}

	@Test
	public void testValueAfterCreationIsZero() {
		assertThat(fc.getValue(), is(closeTo(0,allowingForAn(ERROR))));
	}


	@Test(expected=IllegalArgumentException.class)
	public void testWithANegativeValue() {
		final Double testValue = -12.23;
		fc.setValue(testValue);
		fail("Should have an error by now");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testWithANullValue() {
		final Double testValue = null;
		fc.setValue(testValue);
		fail("Should have an error by now");
	}

	private static double allowingForAn(final double margin)
	{
		return margin;
	}


}
