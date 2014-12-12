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

import service.EmpService;
import vo.EmpVO;

@Controller  //娉ㄨВ EmpController 鏄竴涓�controller(handler)
@RequestMapping("/emp")  
public class EmpController {
	
	//@Resource(name="jdbcTemplate")
	/*@Autowired
	@Qualifier(value="jdbcTemplate")		
	private JdbcTemplate jdbcTemplate;*/
	//jdbcTemplate移到service层
		
	@Autowired
	@Qualifier(value="empService")
	private EmpService empService;
	
	/**
	 * 鑾峰彇鍛樺伐淇℃伅
	 * */
	@RequestMapping(method=RequestMethod.GET)
	//model:springmvc鍦ㄨ皟鐢ㄦ柟娉曞墠锛屼細鍒涘缓涓�釜闅愬惈鐨勬ā鍨嬪璞★紝鐢ㄤ簬瀛樺偍鏁版嵁锛屼緵view鍜宑ontroller浜や簰鏁版嵁
	//鐩稿綋浜巗truts2鐨勫�鏍�
	public String list(Model model){
		List<EmpVO> list = empService.list();
		model.addAttribute("empList", list);
		return "empList";
	}
	
	/**
	 * 鍛樺伐淇℃伅缂栬緫椤甸潰
	 * */
	//{emp}閫氶厤绗�閰嶅悎@PathVariable浼犲弬
	/*@RequestMapping(value="/{empno}/edit",method=RequestMethod.GET)
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
	}*/
	
	/**
	 * 鏇存柊鍛樺伐淇℃伅
	 * */
	/*@RequestMapping(value="/{empno}",method=RequestMethod.PUT)
	public String update(@PathVariable Integer empno,@RequestParam String xiao, EmpVO vo, Model model){
		String updateSql = "update emp set ename=?,job=?,sal=? where empno = ? ";
		jdbcTemplate.update(updateSql, new Object[]{vo.getEname(),vo.getJob(),vo.getSal(),vo.getEmpno()});
		//璺宠浆鍒發ist鏂规硶
		return "redirect:/emp/";
	}*/
}
