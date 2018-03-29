package com.huawei.util;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
public class MysqlJDBCUtiltwo implements JDBCUti {
	private static Logger logger = Logger.getLogger(MysqlJDBCUtiltwo.class);
	private static Connection connection = null;
	public static Connection getConnection() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库加载成功");
			Properties pro = PropertiesUtil.getByName("jdbc2.properties");
			String url = (String) pro.get("url");
			String user = (String) pro.get("user");
			String password = (String) pro.get("password");
			connection = DriverManager.getConnection(url, user, password);
		} 
		catch (ClassNotFoundException e)
		{
			logger.error(e);
		} 
		catch (SQLException e)
		{
			logger.error(e);
		} 
		catch (Exception e) 
		{
			logger.error(e);
		}
		return connection;
	}
	public boolean insert(File f, Object... args)
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(f);
			Element element = document.getDocumentElement();
			element.getElementsByTagName("").item(0).getNodeName();
		}
		catch (ParserConfigurationException | SAXException | IOException e)
		{
			logger.error(e);
		}
		return true;
	}
	public boolean delete(String sql, String... args) 
	{
		connection = getConnection();
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			if (args.length < 0) 
			{
				return false;
			}
			for (int i = 0; i < args.length; i++) 
			{
				preparedStatement.setString(1, args[i]);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (connection != null)
			{
				try 
				{
					connection.close();
				} 
				catch (SQLException e) 
				{
					logger.error("");
				}
			}
		}
		return true;
	}
	public boolean insertBatch(String sql, Object... args) 
	{
		connection = getConnection();
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			if (args.length < 0) 
			{
				return false;
			}
			for (int i = 0; i < args.length; i++) 
			{
				preparedStatement.setString(1, (String) args[i]);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (connection != null) 
			{
				try
				{
					connection.close();
				} 
				catch (SQLException e) 
				{
					logger.error("");
				}
			}
		}
		return true;
	}
	public boolean deleteBatch(String sql, Object... args) 
	{
		connection = getConnection();
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			if (args.length < 0)
			{
				return false;
			}
			for (int i = 0; i < args.length; i++)
			{
				preparedStatement.setString(1, (String) args[i]);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		finally
		{
			if (connection != null) 
			{
				try 
				{
					connection.close();
				} 
				catch (SQLException e)
				{
					logger.error("");
				}
			}
		}
		return true;
	}
	public boolean update(String sql, Object... args) 
	{
		connection = getConnection();
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			if (args.length < 0) 
			{
				return false;
			}
			for (int i = 0; i < args.length; i++) 
			{
				preparedStatement.setString(1, (String) args[i]);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if (connection != null)
			{
				try 
				{
					connection.close();
				} 
				catch (SQLException e)
				{
					logger.error("");
				}
			}
		}
		return true;
	}
	@Override
	public boolean insert(String sql, Object... args)
	{
		connection = getConnection();
		Boolean flag = false;
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			if (args.length < 0)
			{
				return false;
			}
			for (int i = 1; i <= args.length; i++) 
			{
				preparedStatement.setString(i, (String) args[i - 1]);
			}
			flag = preparedStatement.execute();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (connection != null)
			{
				try 
				{
					connection.close();
				} 
				catch (SQLException e) 
				{
					logger.error("");
				}
			}
		}
		return true;
	}

	@Override
	public boolean delete(String sql, Object... args)
	{
		connection = getConnection();
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			if (args.length < 0)
			{
				return false;
			}
			for (int i = 0; i < args.length; i++) 
			{
				preparedStatement.setString(1, (String) args[i]);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (connection != null)
			{
				try 
				{
					connection.close();
				}
				catch (SQLException e)
				{
					logger.error("");
				}
			}
		}
		return true;
	}

	@Override
	public boolean insert(Object... args)
	{
		return false;
	}

	@Override
	public boolean delete(Object... args)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertBatch(Object... args) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBatch(Object... args)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object... args) 
	{
		// TODO Auto-generated method stub
		return false;
	}
}
