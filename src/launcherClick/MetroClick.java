package launcherClick;

import java.io.IOException;
import java.util.List;

import com.android.uiautomator.core.UiDevice;

import Utils.Println;
import launcherClick.model.CellInfo;

public class MetroClick {

	UiDevice uiDevice;

	public MetroClick(UiDevice uiDevice) {
		this.uiDevice = uiDevice;
		//startTogic(uiDevice);
	}

	private void checkCurrentActivity(UiDevice uiDevice){
		new Println("检查前台程序");
		if(!uiDevice.getCurrentPackageName().contains("com.togic.livevideo")){
			new Println("泰捷视频未启动，尝试启动泰捷视频中...");
		}else{
			return;
		}
		try {
			Runtime.getRuntime().exec("am force-stop com.togic.livevideo");
			Runtime.getRuntime().exec("am start -n com.togic.livevideo/.MainActivity");
			Thread.sleep(2000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkCurrentActivity(uiDevice);
	}
	
	public void togicClick(String label, String tab) {
		initPosition();
		List<CellInfo> list = AMetroParse
				.startParse("http://cdn.aiseejapp.atianqi.com//v1/layouts/5654508413eecb802dce1f5a?resolution=1080");
		if(list == null){
			new Println("list is null!!!");
			return;
		}
		int _offset = 0;
		if (tab.equals("影视")) {

		} else if (tab.equals("热门")) {
			_offset = togicOffset("影视");
		} else if (tab.equals("会员")) {
			_offset = togicOffset("影视") + togicOffset("热门");
		} else if (tab.equals("设置")) {
			_offset = togicOffset("影视") + togicOffset("热门") + togicOffset("会员") - 1;
		}
		new Println("begin to move focus to "+label);
		for (CellInfo cellInfo : list) {
			if (cellInfo.getLabel().contains(label) && cellInfo.getTab().contains(tab)) {
				int x = cellInfo.getX();
				int y = cellInfo.getY();
				new Println("x:" + x + "  " + "y:" + y + "  " + "偏移量" + _offset);
				// x方向
				for (int i = x + _offset; i > 1; i--) {
					new Println("→" + " count is " + (x + _offset));
					keyRight();

				}
				// y方向
				for (int i = y; i > 1; i--) {
					new Println("↓");
					keyDown();
				}
			}
		}
		keyEnter();
	}

	public void keyEnter() {
		try {
			// Runtime.getRuntime().exec("adb shell input keyevent 22");
			uiDevice.pressEnter();
			Thread.sleep(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void keyRight() {
		try {
			// Runtime.getRuntime().exec("adb shell input keyevent 22");
			uiDevice.pressDPadRight();
			Thread.sleep(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void keyDown() {
		try {
			// Runtime.getRuntime().exec("adb shell input keyevent 20");
			uiDevice.pressDPadDown();
			Thread.sleep(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int togicOffset(String tab) {
		int lineLenth = 0;
		List<CellInfo> list = AMetroParse
				.startParse("http://cdn.aiseejapp.atianqi.com/v1/layouts/568b9df95b58aab70f44e5ff");
		for (CellInfo cellInfo : list) {
			if (cellInfo.getTab().contains(tab)) {
				int x = cellInfo.getX();
				lineLenth = lineLenth >= x ? lineLenth : x;
			}
		}
		return lineLenth;
	}

	public void initPosition() {
		new Println("init the position");
		for (int i = 0; i < 20; i++) {
			try {
				// Runtime.getRuntime().exec("adb shell input keyevent 19");
				uiDevice.pressDPadUp();
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 5; i++) {
			try {
				// Runtime.getRuntime().exec("adb shell input keyevent 21");
				uiDevice.pressDPadLeft();
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(200);
			// Runtime.getRuntime().exec("adb shell input keyevent 20");
			uiDevice.pressDPadDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void startTogic(UiDevice uiDevice){
		checkCurrentActivity(uiDevice);
	}
	
	public void closeAllActivity() {
		// TODO Auto-generated method stub
		new Println("关闭所有任务中");
		try {
			Runtime.getRuntime().exec("am force-stop com.togic.livevideo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
