package uk.co.hydodev.analysis.components.areas;

import static junitparams.JUnitParamsRunner.$;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.joda.time.DateMidnight;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import uk.co.hydodev.analysis.components.losses.LossComponent;
import uk.co.hydodev.analysis.components.nets.NetFlow;

@RunWith(JUnitParamsRunner.class)
public class AnalysisAreaTest {

	private static final double ERROR = 0.0000001;
	private Area area;

	@Before
	public void setUp() throws Exception {
		area = new AnalysisArea();

	}


	private static final Object[] getMNF(){
		return $( $(new DateMidnight(2013,5,5),23.56),
				$(new DateMidnight(2013,5,6),25.22),
				$(new DateMidnight(2013,5,7),19.34));
	}

	@Test //Leakage will be mnf when there is no other data
	@Parameters(method="getMNF")
	public void testCalculateLeakage(final DateMidnight analysisDate, final Double mnf) {
		final NetFlow nf = mock(NetFlow.class);
		when(nf.getMNF(analysisDate)).thenReturn(mnf);
		area.setNetFlow(nf);
		assertThat(area.getLeakage(analysisDate), equalTo(mnf));
	}


	private static final Object[] getMNFAndComponents(){
		return $( $(new DateMidnight(2013,5,5),23.56, 3.78, 6.67 ),
				$(new DateMidnight(2013,5,6),25.22, 3.78, 6.67),
				$(new DateMidnight(2013,5,7),19.34, 3.78, 6.67));
	}


	@Test //Leakage will be mnf when there is an additional component
	@Parameters(method="getMNFAndComponents")
	public void testCalculateWtihComponentLeakage(final DateMidnight analysisDate, final Double mnf, final Double fc1, final Double fc2) {
		final NetFlow nf = mock(NetFlow.class);
		when(nf.getMNF(analysisDate)).thenReturn(mnf);
		area.setNetFlow(nf);
		double totalFixed = 0;

		final LossComponent fixedComponent1 = mock(LossComponent.class);
		when(fixedComponent1.getValue()).thenReturn(fc1);
		totalFixed += fixedComponent1.getValue();
		area.addComponent(fixedComponent1);

		final LossComponent fixedComponent2 = mock(LossComponent.class);
		when(fixedComponent2.getValue()).thenReturn(fc2);
		totalFixed += fixedComponent2.getValue();
		area.addComponent(fixedComponent2);

		assertThat(area.getLeakage(analysisDate), is(closeTo(mnf - totalFixed , allowingForAn(ERROR))));
	}

	private static double allowingForAn(final double margin)
	{
		return margin;
	}

	@Test
	public void testNetFlow() {
		final NetFlow nf = mock(NetFlow.class);
		area.setNetFlow(nf);
		assertThat(area.getNetFlow(), is(equalTo(nf)));
	}

	@Test
	public void testGetName() {
		area.setName("testArea");
		assertThat(area.getName(), is(equalTo("testArea")));
	}

	@Test
	public void testGetReferance1() {
		area.setReferance1("testRef1");
		assertThat(area.getReferance1(), is(equalTo("testRef1")));
	}

	@Test
	public void testGetReferance2() {
		area.setReferance2("testRef2");
		assertThat(area.getReferance2(), is(equalTo("testRef2")));
	}




}
