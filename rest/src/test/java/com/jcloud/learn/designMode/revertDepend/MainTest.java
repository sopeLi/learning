package com.jcloud.learn.designMode.revertDepend;

import com.jcloud.learn.designMode.revertDepend.defineImpl.HuaSuoMainBoard;
import com.jcloud.learn.designMode.revertDepend.defineImpl.JinShiDunMemory;
import com.jcloud.learn.designMode.revertDepend.business.Computer;
import com.jcloud.learn.designMode.revertDepend.defineImpl.WeiXingMainBoard;
import com.jcloud.learn.designMode.revertDepend.defineImpl.XiJieHardDisk;

public class MainTest {
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.setMainBoard(new HuaSuoMainBoard());
		computer.setMemory(new JinShiDunMemory());
		computer.setHarddisk(new XiJieHardDisk());
		
		computer.display();
		
		System.out.println("-------------");
		
		computer.setMainBoard(new WeiXingMainBoard());
		computer.display();
	}
}
