package level_02.model;

import level_02.interfaces.Observer;

public class StockBrokerAgency implements Observer {
	private String agentName;
	private double stockValue;

	public StockBrokerAgency(String name){
		this.agentName = name;
	}
	public void setStockValue(double value){
		this.stockValue = value;
	}
	public String getAgentName() {
		return this.agentName;
	}

	@Override
	public void update(double newValue){
		this.stockValue = newValue;
	}
}
