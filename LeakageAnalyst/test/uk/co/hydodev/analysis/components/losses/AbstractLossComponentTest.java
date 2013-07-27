package uk.co.hydodev.analysis.components.losses;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AbstractLossComponentTest {

	AbstractLossComponent alc;

	@Before
	public void setUp() throws Exception {
		alc = mock(AbstractLossComponent.class, Mockito.CALLS_REAL_METHODS);
	}

	@Test
	public void testDescription() {
		alc.setDescription("Description for this class");
		assertThat(alc.getDescription(), is(equalTo("Description for this class")));
	}

	@Test
	public void testType() {
		alc.setType("Loss Type");
		assertThat(alc.getType(), is(equalTo("Loss Type")));
	}



}
