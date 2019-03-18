package cn.itcast.gjp.controller;

import java.util.List;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.service.ZhangWuService;

/*
 *  控制器层
 *  接收试图层的数据,数据传递给service层
 *  成员位置,创建service对象
 */
public class ZhangWuController {
	private ZhangWuService service = new ZhangWuService();
	
	
	/*
	 * 控制层类定义方法,实现查询所有的账务数据
	 * 方法由试图层调用,方法调用service层
	 */
	public List<ZhangWu> selectAll(){
		return service.selectAll();
	}

	
	
	/*
	 * 定义方法,实现条件查询账务
	 * 方法由试图层调用,传递两个日期的字符串
	 * 调用service层的方法,传递两个日期字符串,获取结果集
	 * 结果集返回给试图
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		return service.select(startDate, endDate);
	}
	
}
