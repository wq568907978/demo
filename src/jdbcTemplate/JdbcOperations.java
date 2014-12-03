package jdbcTemplate;

import java.util.List;

/*
 * 执行jdbc操作的接口
 *  
 * */
public interface JdbcOperations {

	<T> T queryForObject(String sql,Object[] params,RowMapper<T> mapper);
	
	<T> List<T> queryForList(String sql,Object[] params,RowMapper<T> mapper);
	
	/**
	 * 基础的执行方法，其他方法都会调用这个执行方法(根据statment不同)
	 * 
	 * */
	<T> T execute(String sql,Object[] params,PrepareStatementCallBack<T> callback);
	
}
