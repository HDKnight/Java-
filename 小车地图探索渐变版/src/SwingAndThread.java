import java.awt.*;
import java.net.*;
import javax.swing.*;

public class SwingAndThread extends JFrame {

	private static final long serialVersionUID = 1L;
	private Thread t1;
	private Thread t2;
	private Thread t3;
	private JLabel jl = new JLabel(); // ����JLabel����
	private static Thread t; // �����̶߳���
	public static int x = 0; // ��������x����
	public static int y = 0; // ��������y����
	private Container container = getContentPane(); // ��������

	public SwingAndThread() {
		setBounds(300, 200, 306, 330); // ���Զ�λ�����С��λ��
		container.setLayout(null); // ʹ���岻ʹ���κβ��ֹ�����
		URL url = SwingAndThread.class.getResource("/2.jpg"); // ��ȡͼƬ��URL
		Icon icon = new ImageIcon(url); // ʵ����һ��Icon
		jl.setIcon(icon); // ��ͼ������ڱ�ǩ��
		// ����ͼƬ�ڱ�ǩ������
		jl.setHorizontalAlignment(SwingConstants.LEFT);
		// jl.setBounds(0, 0, 30, 30); // ���ñ�ǩ��λ�����С
		t = new Thread(new Runnable() { // ���������ڲ��࣬����ʵ��Runnable�ӿ�
					public void run() { // ��дrun()����
						for (int i = 1; i < Test.x2.size(); i++) { // ����ѭ������
							// ����ǩ�ĺ������ñ�����ʾ
							jl.setBounds(x, y, 30, 30);
							try {
								Thread.sleep(200); // ʹ�߳�����1000����
							} catch (Exception e) {
								e.printStackTrace();
							}
							y = Test.x2.get(i) * 30; // ʹ������ÿ������30
							x = Test.y2.get(i) * 30; // ʹ������ÿ������30
						}
					}
				});
		t.start(); // �����߳�
		t1 = new Thread(new Runnable() {// ���������̶߳���
					public void run() {// �����߳̽ӿڷ���
						int i = 1;
						try {
							Thread.sleep(300);// �߳�����0.1��
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						while (true) {								
							try {
								Thread.sleep(200);// �߳�����0.1��
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
								for (int k = 1; k <= i; k++) {	
									
									Graphics graphics = getGraphics();
									graphics.setColor(Color.gray);// ���û�ͼ��ɫ
									// ����ֱ�߲�������ֱ����
									graphics.fillRect(Test.y2.get(k) * 30 + 3,
											Test.x2.get(k) * 30 + 26, 30, 30);	
										
								}
								i++;
						}

					}
				});
		t1.start();// �����߳�
		t2 = new Thread(new Runnable() {// ���������̶߳���
					public void run() {// �����߳̽ӿڷ���
						while (true) {
							try {
								Thread.sleep(200);// �߳�����0.1��
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							for (int i = 0; i < Test.v.size(); i++) {// ����ѭ��
								try {
									Thread.sleep(1);// �߳�����0.1��
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								// ��ȡ�����ͼ�����Ķ���
								Graphics graphics = getGraphics();
								graphics.setColor(Color.BLACK);// ���û�ͼ��ɫ
								// ����ֱ�߲�������ֱ����
								graphics.fillRect(Test.v.get(i) * 30 + 3,
										Test.w.get(i) * 30 + 26, 30, 30);
							}
						}
					}
				});
		t2.start();// �����߳�
		container.add(jl); // ����ǩ��ӵ�������
		setVisible(true); // ʹ�������
		setResizable(false);
		// this.getContentPane().setBackground(new Color(200, 200, 200));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);// ���ô���Ĺرշ�ʽ

	}

	public static void main(String[] args) {
		new Test();
		new SwingAndThread(); // ʵ����һ��SwingAndThread����
	}
}
