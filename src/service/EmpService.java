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

//annocation ���� �������������� (ֻ��public����)
//ָ�����쳣��rollback��Ĭ����RuntimeException���ύ,checked Exception��ع�
//@Transactional(rollbackFor=Exception.class) 
//Empservice ��Spring�й�
@Service(value="empService")
public class EmpService {
	
	//@Resource(name="jdbcTemplate")
	@Autowired
	@Qualifier(value="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
		
	public List<EmpVO> list(){
		System.out.println("��ʼִ��service����");
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
