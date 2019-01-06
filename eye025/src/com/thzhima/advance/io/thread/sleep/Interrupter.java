package com.thzhima.advance.io.thread.sleep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Interrupter  extends JFrame{
		public Interrupter() {
			this.setTitle("线程打断示例");
			this.setSize(800, 600);//宽度和高度
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭，程序结束
			this.setResizable(false);//生成的窗口可以自由改变大小
			
			JPanel panel = new JPanel(null);
			// panel.setBackground(Color.blue);
			this.setContentPane(panel);//替换JFrame的容器
			
			// 开始按钮
			JButton btnStart = new JButton("开始");
			btnStart.setSize(70, 30);
			btnStart.setLocation(10, 10);//范围x轴和y轴
			panel.add(btnStart);//add是添加到JFrame的容器里面
			
			// 取消按钮
			JButton btnCancel = new JButton("取消");
			btnCancel.setSize(70, 30);
			btnCancel.setLocation(100, 10);
			panel.add(btnCancel);
			

			// 进度条
			JProgressBar bar = new JProgressBar(0, Integer.MAX_VALUE);//JProgressBar进度条
			bar.setSize(700, 30);
			bar.setLocation(30, 200);
			panel.add(bar);
			bar.setValue(0);//设置默认值
			
			Thread t = new Thread() {
				public void run() {
//					try {
						for (int i = 1; i <= Integer.MAX_VALUE; i++) {
							bar.setValue(i);
							
							
//							if(Thread.interrupted()) {//用静态方法判断,清除中断标记，重置为false
//								System.out.println("-------设置了中断标识-------");
//							System.out.println("再一次判断中断标记: "+Thread.interrupted());
//								break;
//							}
							if(this.isInterrupted()) {//实例方法，不清处中断标记,为true
								System.out.println("-------设置了中断标识-------");
								System.out.println("再一次判断中断标记: "+this.isInterrupted());
								break;
							}
							
							//Thread.sleep(300);
						}
//					} catch (InterruptedException e1) {
//						e1.printStackTrace();
//					}
				}
			};

			btnStart.addActionListener(new ActionListener() {//添加指定的动作侦听器
				@Override
				public void actionPerformed(ActionEvent e) {//用于接收操作事件的侦听器接口
					t.start();
				}
			});

			btnCancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					t.interrupt();

				}
			});

			this.setVisible(true);//数据模型已经构造好
		}

		public static void main(String[] args) {
			Interrupter i = new Interrupter();
	
		}	
	
}
