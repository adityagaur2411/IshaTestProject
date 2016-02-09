package com.test;


public class StartServer {
	
	public void startServer(String strFilePath) throws Exception {
		Runtime rtServer = Runtime.getRuntime();
		rtServer.exec("cmd /C start /min "+ strFilePath);
		Thread.sleep(5000);
	}

}
