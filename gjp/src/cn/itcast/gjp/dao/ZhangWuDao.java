package cn.itcast.gjp.dao;

/*
 *  实现对数据表 gjp_zhangwu 数据增删改查操作
 *  dbuils工具类完成,类成员创建QueryRunner对象,指定数据源
 */
import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.gjp.tools.JDBCUtils;

public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

}
