package jdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 入参为结果集
 * 通过结果集  执行sql  得到结果集rs
 * 再操作rs，rs的操作类一般为外部类的变量;
 * */
public interface PrepareStatementCallBack<T>{

	T doInPreparedStatement(PreparedStatement ps) throws SQLException;
}
