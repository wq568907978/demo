package jdbcTemplate;

import java.sql.ResultSet;

/**
 * ORM 具体映射处理接口 ,由使用者指定
 * 负责处理单行数据 各列 与 vo各属性的对应关系
 * */
public interface RowMapper<T> {
	
	/**
	 * index 表示当前ResultSet行的索引位置，具体用不用，取决于实现类
	 * */
	T MapperRow(ResultSet rs,int index);
}
