package level_02.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StockAgent {

	private List<StockBrokerAgency> stockAgencies;
	private double stockValue;

	public StockAgent(){
		this.stockAgencies = new ArrayList<StockBrokerAgency>();
		this.stockValue = 147.00F;
	}
	public void addObserver(StockBrokerAgency stockBrokerAgencyName){
		stockBrokerAgencyName.setStockValue(this.stockValue);
		this.stockAgencies.add(stockBrokerAgencyName);
	}
	public List<StockBrokerAgency> getStockAgenciesList(){
		return this.stockAgencies;
	}
	public void removeObserver(StockBrokerAgency stockBrokerAgencyName){
		this.stockAgencies.remove(stockBrokerAgencyName);
	}
	public void stockMarketUp(double newValue){
		this.stockValue = newValue;
		notifyObservers("Stock market went UP to " + String.format(Locale.US,"%.2f",this.stockValue));
	}
	public void stockMarketDown(double newValue){
		this.stockValue = newValue;
		notifyObservers("Stock market went DOWN to " + String.format(Locale.US,"%.2f",this.stockValue));
	}
	public void notifyObservers(String message){
		stockAgencies.forEach(agency -> {
			agency.update(this.stockValue);
			System.out.println(agency.getAgentName()
					+ " received notification: " + message);
		});
	}
}
