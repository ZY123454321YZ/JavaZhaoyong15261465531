package com.springmvc.util;
public interface JDBCUti <T extends Object>{
	public boolean insert(Object...args);
 	public boolean delete(Object...args);
 	public boolean insertBatch(Object...args);
    public boolean deleteBatch(Object...args);
    public boolean update(Object...args);
	boolean delete(String sql, Object[] args);
	boolean insert(String sql, Object[] args);
}
