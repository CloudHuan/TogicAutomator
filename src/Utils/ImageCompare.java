package Utils;

import junit.framework.Assert;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageCompare {

	public  static void AssertBitmapEqual(Bitmap bitmap0, Bitmap bitmap1){
		/**
		 * 百分百图片相同断言-.-
		 */
		Assert.assertEquals(100, ImageCompare(bitmap0,bitmap1));
	}
	
	public  static void AssertBitmapNotEqual(Bitmap bitmap0, Bitmap bitmap1){
		/**
		 * 百分之零图片相同断言
		 */
		Assert.assertEquals(0, ImageCompare(bitmap0,bitmap1));
	}
	
	public static int ImageCompare(String path0,String path1) {
		/**
		 * 提供根据路径直接比较
		 */
		Bitmap bitmap0 = BitmapFactory.decodeFile(path0); 
		Bitmap bitmap1 = BitmapFactory.decodeFile(path1); 
		return ImageCompare(bitmap0,bitmap1);
	}
	
	public static int ImageCompareChild(Bitmap bitmap0, Bitmap bitmap1,int x,int y,int width,int height) {
		/**
		 * 裁剪子图并比较，主要是为了解决拉取动态数据不同，但是局部提示不变的比较场景。
		 */
		Bitmap bitmap00 = bitmap0.createBitmap(bitmap0, x, y, width, height);
		Bitmap bitmap01 = bitmap1.createBitmap(bitmap1, x, y, width, height);
		return ImageCompare(bitmap00,bitmap01);
	}
	
	public static int ImageCompare(Bitmap bitmap0, Bitmap bitmap1) {
		/**
		 * 比较的主函数
		 * 只能比较相同长宽的图片，不相等返回-1失败
		 * 相似度为1~100
		 * 原理是提取每一个像素点比较，整张图相似度取决于像素点相同个数，所以还是比较准确的
		 */
		int picPct = 0;
		int picCount = 0;
		int picCountAll = 0;
		new Println("begin to compare");
		if (bitmap0 == null || bitmap1 == null) {
			new Println("null bitmap");
			return -1;
		}
		if (bitmap0.getWidth() != bitmap1.getWidth()
				|| bitmap0.getHeight() != bitmap1.getHeight()) {
			return -1;
		}
		new Println("宽度为:" + bitmap1.getWidth() + "高度为:" + bitmap1.getHeight());
		for (int j = 0; j < bitmap1.getWidth(); j++) {
			for (int i = 0; i < bitmap0.getHeight(); i++) {
				if (bitmap0.getPixel(j, i) == bitmap1.getPixel(j, i)) {
					picCount++;
				}
				picCountAll++;
			}
		}
		int result = (int) (((float) picCount) / picCountAll * 100);
		new Println(picCount + "/" + picCountAll);
		new Println("相似度为:" + result);
		return result;
	}
}
