package web.emp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vo.EmpVO;

@Controller  //注解 EmpController 是一个 controller(handler)
@RequestMapping("/emp")  
public class EmpController {
	
	//@Resource(name="jdbcTemplate")
	@Autowired
	@Qualifier(value="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 获取员工信息
	 * */
	@RequestMapping(method=RequestMethod.GET)
	//model:springmvc在调用方法前，会创建一个隐含的模型对象，用于存储数据，供view和controller交互数据
	//相当于struts2的值栈
	public String list(Model model){
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
		model.addAttribute("empList", list);
		return "empList";
	}
	
	/**
	 * 员工信息编辑页面
	 * */
	//{emp}通配符,配合@PathVariable传参
	@RequestMapping(value="/{empno}/edit",method=RequestMethod.GET)
	public String edit(@PathVariable Integer empno,Model model){
		String selSql =  "select * from emp where empno = " + empno ;
		EmpVO vo = jdbcTemplate.queryForObject(selSql, new RowMapper<EmpVO>(){
			public EmpVO mapRow(ResultSet rs, int arg1) throws SQLException {
				EmpVO emp = new EmpVO();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setSal(rs.getDouble("sal"));
				return emp;
			}
		});
		model.addAttribute("emp", vo);
		return "empEdit";
	}
	
	/**
	 * 更新员工信息
	 * */
	@RequestMapping(value="/{empno}",method=RequestMethod.PUT)
	public String update(@PathVariable Integer empno,@RequestParam String xiao, EmpVO vo, Model model){
		String updateSql = "update emp set ename=?,job=?,sal=? where empno = ? ";
		jdbcTemplate.update(updateSql, new Object[]{vo.getEname(),vo.getJob(),vo.getSal(),vo.getEmpno()});
		//跳转到list方法
		return "redirect:/emp/";
	}
}
