package jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 结果集处理者
 * 处理ResultSet 与 返回 相应结果
 * 方法入参rowMapper,处理具体的ORM映射
 * */
public interface ResultSetExecutor<T> {
	
	T executeData(ResultSet rs) throws SQLException;
}
