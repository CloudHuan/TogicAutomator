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
		uiDevice = getUiDevice();
		//启动泰捷视频
		metroClick = new MetroClick(uiDevice);
		metroClick.startTogic(uiDevice);
	}
	
	@Override
	protected void tearDown() throws Exception {
		// 关闭所有任务
		metroClick.closeAllActivity();
	}
	
	public void testClickMetro(){
		try {
		//点击观看历史，然后返回
		metroClick.togicClick("观看历史", "影视");
		Thread.sleep(3000);
		uiDevice.pressBack();
		//点击关于我们,然后返回
		metroClick.togicClick("关于我们", "设置");
		Thread.sleep(3000);
		uiDevice.pressBack();
		
		metroClick.togicClick("排行榜", "热门");
		Thread.sleep(3000);
		uiDevice.pressBack();
		
		Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
