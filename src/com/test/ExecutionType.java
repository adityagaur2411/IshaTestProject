package com.test;

public class ExecutionType {
	
	public void setExecutionType(String strRemote) throws Exception {
		
		switch (strRemote.toLowerCase()) {
		
		case "yes":
			StartServer strServer = new StartServer();
			strServer.startServer("E:/isha_selenium/hub.bat");
			strServer.startServer("E:/isha_selenium/node.bat");
			break;
			
		default:
			break;
		}
	}

}
