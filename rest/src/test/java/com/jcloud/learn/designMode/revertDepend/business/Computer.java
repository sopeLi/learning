package com.jcloud.learn.designMode.revertDepend.business;

import com.jcloud.learn.designMode.revertDepend.abstractDefine.MainBoard;
import com.jcloud.learn.designMode.revertDepend.abstractDefine.Memory;
import com.jcloud.learn.designMode.revertDepend.abstractDefine.HardDisk;
import lombok.Data;

/*
 * 电脑
 */
@Data
public class Computer {
	private MainBoard mainBoard;
	private Memory memory;
	private HardDisk harddisk;

	public void display() {
		mainBoard.doSomething();
		memory.doSomething();
		harddisk.doSomething();
	}
}
