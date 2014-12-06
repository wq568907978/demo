package jdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.ResultSetExtractor;

import vo.EmpVO;
/**
 * 为了区分merge和rebase
 * 
 * */
public class JdbcTemplate implements JdbcOperations{
	
	private DataSource dataSource;  //DataSource直接加在 JdbcTemplate，为了简单

	public <T> T queryForObject(String sql, Object[] params, RowMapper<T> mapper) {
		return null;
	}

	public <T> List<T> queryForList(String sql, Object[] params,RowMapper<T> rowMapper) {
		return query(sql,params,new RowCallbackResultSetExtractor<T>(rowMapper));
	}
	
	//这里的参数要一定是ResultSetExecutor接口，而非其实现类
	//因为其实现类的返回值可能是T,也可能是List<T>,<T extends EmpVO>
	public <T> T query(String sql,Object[] params,final ResultSetExecutor<T> extractor){
		return execute(sql, params, new PrepareStatementCallBack<T>() {

			public T doInPreparedStatement(PreparedStatement ps)throws SQLException {
				ResultSet rs = ps.executeQuery();
				return extractor.executeData(rs);
			}	
		});
	}
	
	public <T> T execute(String sql, Object[] params,PrepareStatementCallBack<T> callback) {
		T result = null;
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			//可以用类封装一下这个处理过程
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			result = callback.doInPreparedStatement(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 这么实=设计，可以保证，返回的可以使T或者List<T>
	 * 
	 * */
	private class RowCallbackResultSetExtractor<T> implements ResultSetExecutor<List<T>>{
		
		private RowMapper<T> mapper;
		
		public RowCallbackResultSetExtractor(RowMapper<T> mapper) {
			this.mapper = mapper;
		}

		public List<T> executeData(ResultSet rs) throws SQLException {
			List<T> list = new ArrayList<T>();
			while(rs.next()){
				T row = mapper.MapperRow(rs, 0);
				list.add(row);
			}
			return list;
		}
	}
	
}
