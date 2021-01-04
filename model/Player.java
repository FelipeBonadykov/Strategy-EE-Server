package com.bonadykov.serverstrategy.model;

public class Player {
	
	private final String ipaddress;
	private final int port;
	
	public Player(String ipaddress, int port) {
		this.ipaddress = ipaddress;
		this.port = port;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public int getPort() {
		return port;
	}

}
