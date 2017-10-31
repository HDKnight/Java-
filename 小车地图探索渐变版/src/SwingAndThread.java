import java.awt.*;
import java.net.*;
import javax.swing.*;

public class SwingAndThread extends JFrame {

	private static final long serialVersionUID = 1L;
	private Thread t1;
	private Thread t2;
	private Thread t3;
	private JLabel jl = new JLabel(); // 声明JLabel对象
	private static Thread t; // 声明线程对象
	public static int x = 0; // 声明计数x变量
	public static int y = 0; // 声明计数y变量
	private Container container = getContentPane(); // 声明容器

	public SwingAndThread() {
		setBounds(300, 200, 306, 330); // 绝对定位窗体大小与位置
		container.setLayout(null); // 使窗体不使用任何布局管理器
		URL url = SwingAndThread.class.getResource("/2.jpg"); // 获取图片的URL
		Icon icon = new ImageIcon(url); // 实例化一个Icon
		jl.setIcon(icon); // 将图标放置在标签中
		// 设置图片在标签的最左方
		jl.setHorizontalAlignment(SwingConstants.LEFT);
		// jl.setBounds(0, 0, 30, 30); // 设置标签的位置与大小
		t = new Thread(new Runnable() { // 定义匿名内部类，该类实现Runnable接口
					public void run() { // 重写run()方法
						for (int i = 1; i < Test.x2.size(); i++) { // 设置循环条件
							// 将标签的横坐标用变量表示
							jl.setBounds(x, y, 30, 30);
							try {
								Thread.sleep(200); // 使线程休眠1000毫秒
							} catch (Exception e) {
								e.printStackTrace();
							}
							y = Test.x2.get(i) * 30; // 使横坐标每次增加30
							x = Test.y2.get(i) * 30; // 使横坐标每次增加30
						}
					}
				});
		t.start(); // 启动线程
		t1 = new Thread(new Runnable() {// 创建匿名线程对象
					public void run() {// 覆盖线程接口方法
						int i = 1;
						try {
							Thread.sleep(300);// 线程休眠0.1秒
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						while (true) {								
							try {
								Thread.sleep(200);// 线程休眠0.1秒
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
								for (int k = 1; k <= i; k++) {	
									
									Graphics graphics = getGraphics();
									graphics.setColor(Color.gray);// 设置绘图颜色
									// 绘制直线并递增垂直坐标
									graphics.fillRect(Test.y2.get(k) * 30 + 3,
											Test.x2.get(k) * 30 + 26, 30, 30);	
										
								}
								i++;
						}

					}
				});
		t1.start();// 启动线程
		t2 = new Thread(new Runnable() {// 创建匿名线程对象
					public void run() {// 覆盖线程接口方法
						while (true) {
							try {
								Thread.sleep(200);// 线程休眠0.1秒
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							for (int i = 0; i < Test.v.size(); i++) {// 无限循环
								try {
									Thread.sleep(1);// 线程休眠0.1秒
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								// 获取组件绘图上下文对象
								Graphics graphics = getGraphics();
								graphics.setColor(Color.BLACK);// 设置绘图颜色
								// 绘制直线并递增垂直坐标
								graphics.fillRect(Test.v.get(i) * 30 + 3,
										Test.w.get(i) * 30 + 26, 30, 30);
							}
						}
					}
				});
		t2.start();// 启动线程
		container.add(jl); // 将标签添加到容器中
		setVisible(true); // 使窗体可视
		setResizable(false);
		// this.getContentPane().setBackground(new Color(200, 200, 200));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);// 设置窗体的关闭方式

	}

	public static void main(String[] args) {
		new Test();
		new SwingAndThread(); // 实例化一个SwingAndThread对象
	}
}
