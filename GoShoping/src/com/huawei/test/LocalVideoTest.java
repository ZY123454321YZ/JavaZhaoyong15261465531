package com.huawei.test;

public class LocalVideoTest {

	public LocalVideoTest()
	{
		CamDataSource dataSource = new CamDataSource(null);

		dataSource.setMainSource();

		dataSource.makeDataSourceCloneable();

		dataSource.startProcessing();

		MainFrame frame = new MainFrame(dataSource);

		frame.setSize(400, 400);

		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

	}

	public static void main(String[] args) 
	{
		try
		{
			LocalVideoTest Lvt = new LocalVideoTest();
			System.out.println("Lvt==" + Lvt);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
