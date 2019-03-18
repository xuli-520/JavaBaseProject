package cn.itcast.gjp.view;

import java.util.List;
import java.util.Scanner;

import cn.itcast.gjp.controller.ZhangWuController;
import cn.itcast.gjp.domain.ZhangWu;

/*
 *  试图层,用户看到和操作的界面
 *  数据传递给controller层实现
 *  成员位置,创建controller对象
 */
public class MainView {
	private ZhangWuController controller = new ZhangWuController();
	/*
	 *  实现界面效果
	 *  接收用户的输入
	 *  根据数据,调用不同的功能方法
	 */
	public void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("---------------管家婆家庭记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");
			//接收用户的菜单选择
			int choose = sc.nextInt();
			//对选择的菜单判断,调用不同的功能
			switch(choose){
			case 1:
			   // 选择添加账务,调用添加账务的方法
				//addZhangWu();
				break;
			case 2:
				// 选择的编辑账务,调用编辑账务方法
				//editZhangWu();
				break;
			case 3:
				// 选择的删除账务,调用删除账务方法
				//deleteZhangWu();
				break;
			case 4:
				// 选择的是查询账务,调用查询方法
				selectZhangWu();
				break;
			case 5:
				//System.exit(0);
				break;
			}
		
	}}
	
	
	/*
	 * 定义方法 selectZhangWu()
	 * 显示查询的方式 1 所有查询   2 条件查询
	 * 接收用户的选择
	 */
	 public void selectZhangWu(){
		 System.out.println("1. 查询所有    2. 条件查询");
		 Scanner sc = new Scanner(System.in);
		 int selectChooser = sc.nextInt();
		 //判断根据用户的选择,调用不同的功能
		 switch(selectChooser){
		 case 1:
			 //选择的查询所有,调用查询所有的方法
			 selectAll();
			 break;
		 case 2:
			 //选的条件查询,调用带有查询条件的方法
			 select();
			 break;
		 }
	 }
	 
	 
	 
	 /*
	  * 定义方法,实现查询所有的账务数据
	  */
	 public void selectAll(){
		 //调用控制层中的方法,查询所有的账务数据
		 List<ZhangWu> list = controller.selectAll();
		 System.out.println("ID\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
			for (ZhangWu zw : list) {
				System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t\t"
						+ zw.getZhanghu() + "\t\t" + zw.getMoney() + "\t\t"
						+ zw.getCreatetime() + "\t" + zw.getDescription());
			}

	 }
	 
	 
	 
	 /*
	  * 定义方法,实现条件查询账务数据
	  * 提供用户的输入日期,开始日期结束日期
	  * 就2个日期,传递到controller层
	  * 调用controller的方法,传递2个日期参数
	  * 获取到controller查询的结果集,打印出来
	  */
	 
	 public void select(){
		 System.out.println("选择条件查询,输入日期格式XXXX-XX-XX");
		 Scanner sc = new Scanner(System.in);
		 System.out.print("请输入开始日期:");
		 String startDate = sc.nextLine();
		 System.out.print("请输入结果日期:");
		 String endDate = sc.nextLine();
		 //调用controller层的方法,传递日期,获取查询结果集
		 List<ZhangWu> list = controller.select(startDate, endDate);
		 if(list.size()!=0)
			 for (ZhangWu zw : list) {
					System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t\t"
							+ zw.getZhanghu() + "\t\t" + zw.getMoney() + "\t\t"
							+ zw.getCreatetime() + "\t" + zw.getDescription());
				}
		 else
			 System.out.println("没有查询到数据");
		 
	 }
	 
	 

}
	
