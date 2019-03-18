package cn.itcast.gjp.dao;

import java.sql.SQLException;
import java.util.List;

/*
 *  实现对数据表 gjp_zhangwu 数据增删改查操作
 *  dbuils工具类完成,类成员创建QueryRunner对象,指定数据源
 */
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.tools.JDBCUtils;

public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	
	/*
	 * 定义方法,查询数据库,获取所有的账务数据
	 * 方法,由业务层调用
	 * 结果集,将所有的账务数据,存储到Bean对象中,存储到集合中
	 */
	public List<ZhangWu> selectAll(){
		try{
		//查询账务数据的SQL语句
			String sql = "SELECT * FROM gjp_zhangwu";
			//调用qr对象的方法,query方法,结果集BeanListHandler
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
			return list;
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("查询所有账务失败");
		}
	}
	
	
	
	/*
	 * 定义方法,查询数据库,带有条件去查询账务表
	 * 由业务层调用,查询结果集存储到Bean对象,存储到List集合
	 * 调用者传递2个日期字符串
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		try{
			//拼写条件查询的SQL语句
			String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
			//定义对象数组,存储?占位符
			Object[] params = {startDate,endDate};
			//调用qr对象的方法query查询数据表,获取结果集
			return qr.query(sql, new BeanListHandler<>(ZhangWu.class),params);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("条件查询失败");
		}
	}
	
	
}



