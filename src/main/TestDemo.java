package main;

import java.io.IOException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import junit.framework.TestCase;
import launcherClick.MetroClick;

public class TestDemo extends UiAutomatorTestCase{
	
	UiDevice uiDevice;
	MetroClick metroClick;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		uiDevice = getUiDevice();
	}
	
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void testClickMetro(){
		try {
		metroClick = new MetroClick(uiDevice);
		//点击观看历史，然后返回
		metroClick.togicClick("观看历史", "影视");
		Thread.sleep(3000);
		uiDevice.pressBack();
		//点击关于我们,然后返回
		metroClick.togicClick("关于我们", "设置");
		Thread.sleep(3000);
		uiDevice.pressBack();
		//延迟3s，结束所有任务
		Thread.sleep(3000);
		metroClick.closeAllActivity();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
