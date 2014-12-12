package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import vo.EmpVO;

//annocation 表明 这个类会切入事务 (只是public方法)
//指定有异常就rollback，默认是RuntimeException会提交,checked Exception会回滚
//@Transactional(rollbackFor=Exception.class) 
//Empservice 由Spring托管
@Service(value="empService")
public class EmpService {
	
	//@Resource(name="jdbcTemplate")
	@Autowired
	@Qualifier(value="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
		
	public List<EmpVO> list(){
		System.out.println("开始执行service方法");
		List<EmpVO> list = jdbcTemplate.query("select * from emp", new RowMapper<EmpVO>(){
			public EmpVO mapRow(ResultSet rs, int index) throws SQLException {
				EmpVO emp = new EmpVO();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setSal(rs.getDouble("sal"));
				return emp;
			}
		});
		return list;
	}

}
