package com.iu.s1.location;

import java.util.Scanner;

public class LocationController {
	LocationDAO locationDAO;
	LocationView locationView;
	Scanner sc;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		locationView = new LocationView();
		sc = new  Scanner(System.in);
		
	}
}
