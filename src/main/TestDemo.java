package main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import Utils.ImageCompare;
import Utils.Println;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import junit.framework.TestCase;
import launcherClick.AMetroParse;
import launcherClick.MetroClick;
import launcherClick.model.CellInfo;

public class TestDemo extends UiAutomatorTestCase{
	
	UiDevice uiDevice;
	MetroClick metroClick;
	
/*	@Override
	protected void setUp() throws Exception {
		uiDevice = getUiDevice();
		//启动泰捷视频,没有启动就启动
		metroClick = new MetroClick(uiDevice);
		metroClick.startTogic(uiDevice);
	}
	
	@Override
	protected void tearDown() throws Exception {
		// 关闭所有任务
		metroClick.closeAllActivity();
	}*/
	
/*	public void testClickMetro(){
		try {
		//点击观看历史，然后返回
		metroClick.togicClick("观看历史", "影视");
		Thread.sleep(3000);
		uiDevice.pressBack();
		//点击关于我们,然后返回
		metroClick.togicClick("关于我们", "设置");
		Thread.sleep(3000);
		uiDevice.pressBack();
		
		metroClick.togicClick("轮播", "影视");
		Thread.sleep(3000);
		uiDevice.pressBack();
		uiDevice.pressBack();
		uiDevice.pressBack();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}*/
	
	//点击all磁铁
/*	public void testClickAllMetro(){
		List<CellInfo> list = AMetroParse
				.startParse("http://cdn.aiseejapp.atianqi.com//v1/layouts/5654508413eecb802dce1f5a?resolution=1080");
		for(int i=0;i<list.size();i++){
			try {
				Thread.sleep(200);			
				if(list.get(i).getLabel().contains("轮播") || list.get(i).getLabel().contains("随便看看")){
					metroClick.togicClick(list.get(i).getLabel(), list.get(i).getTab());
					Thread.sleep(200);
					uiDevice.pressBack();
					uiDevice.pressBack();
					uiDevice.pressBack();
					uiDevice.pressBack();
					continue;
				}
				metroClick.togicClick(list.get(i).getLabel(), list.get(i).getTab());
				Thread.sleep(1000);
				uiDevice.pressBack();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		metroClick.closeAllActivity();
	}*/
	
	public void testCompare(){
		Bitmap bitmap0 = BitmapFactory.decodeFile("/sdcard/pic/search00.png"); 
		Bitmap bitmap1 = BitmapFactory.decodeFile("/sdcard/pic/search01.png"); 
		Bitmap bitmap2 = BitmapFactory.decodeFile("/sdcard/pic/search02.png"); 
		ImageCompare.ImageCompare(bitmap0, bitmap2);
	}
}
