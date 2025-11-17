package level_02;

import level_02.model.StockBrokerAgency;
import level_02.model.StockAgent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Observer_UnitaryTest {
	StockAgent agent;
	StockBrokerAgency alphaBrokers;
	StockBrokerAgency zenithInvestments;
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private PrintStream originalOutContent = System.out;

	@BeforeEach
	public void testSetUp(){
		agent = new StockAgent();
		alphaBrokers = new StockBrokerAgency("Alpha Brokers");
		zenithInvestments = new StockBrokerAgency("Zenith Investments");
		agent.addObserver(alphaBrokers);
		agent.addObserver(zenithInvestments);
		System.setOut(new PrintStream(outContent));
	}
	@AfterEach
	public void resetStreams(){
		System.setOut(originalOutContent);
	}

	@Test
	public void observerAddTest(){
		Assertions.assertEquals(alphaBrokers.getAgentName(),agent.getStockAgenciesList().stream()
				.filter(stockBrokerAgency -> stockBrokerAgency.getAgentName().equalsIgnoreCase("Alpha Brokers"))
				.findFirst()
				.map(StockBrokerAgency::getAgentName)
				.orElse("Agency not found")
		);
		Assertions.assertEquals(zenithInvestments.getAgentName(),agent.getStockAgenciesList().stream()
				.filter(stockBrokerAgency -> stockBrokerAgency.getAgentName().equalsIgnoreCase("Zenith Investments"))
				.findFirst()
				.map(StockBrokerAgency::getAgentName)
				.orElse("Agency not found")
		);
	}
	@Test
	public void observerRemoveTest(){
		agent.removeObserver(zenithInvestments);
		Assertions.assertNull(agent.getStockAgenciesList().stream()
				.filter(stockBrokerAgency -> stockBrokerAgency.getAgentName().equalsIgnoreCase("Zenith Investments"))
				.findFirst()
				.orElse(null)
		);
	}

	@Test
	public void testStockAgentUpNotifications() {
		agent.stockMarketUp(150.75);
		String printed = outContent.toString();
		Assertions.assertTrue(printed.contains("Alpha Brokers received notification: Stock market went UP to 150.75"));
		Assertions.assertTrue(printed.contains("Zenith Investments received notification: Stock market went UP to 150.75"));
	}
	@Test
	public void testStockAgentDownNotifications() {
		agent.stockMarketDown(145.50);
		String printed = outContent.toString();
		Assertions.assertTrue(printed.contains("Alpha Brokers received notification: Stock market went DOWN to 145.50"));
		Assertions.assertTrue(printed.contains("Zenith Investments received notification: Stock market went DOWN to 145.50"));
	}

}
