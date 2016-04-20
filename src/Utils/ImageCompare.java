package Utils;

import android.graphics.Bitmap;

public class ImageCompare {

	public static int ImageCompare(Bitmap bitmap0, Bitmap bitmap1) {
		/**
		 * 返回-1代表对比失败 相似度为1~100 结果输出是四舍五入
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
