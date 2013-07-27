package uk.co.hydodev.analysis.components;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import uk.co.hydodev.analysis.components.areas.AggregateAreaTest;
import uk.co.hydodev.analysis.components.areas.AnalysisAreaTest;
import uk.co.hydodev.analysis.components.leakage.TestLeakage;
import uk.co.hydodev.analysis.components.losses.AbstractLossComponent;
import uk.co.hydodev.analysis.components.losses.AbstractLossComponentTest;
import uk.co.hydodev.analysis.components.losses.FixedComponentTest;
import uk.co.hydodev.analysis.components.nets.NetFlowTest;

@RunWith(Suite.class)
@SuiteClasses({ AggregateAreaTest.class,
	            AnalysisAreaTest.class,
	            TestLeakage.class,
	            AbstractLossComponentTest.class,
	            FixedComponentTest.class,
	            NetFlowTest.class })
public class AllTests {

}
