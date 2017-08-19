package com.active.util;

/**
 * 图片工具类
 * 
 * @author zhang
 *
 */
public class ImageUrlUtil {

	public static String imageUrl = "";

	static {
		imageUrl = "";
	}

	/**
	 * 获取图片地址
	 * 
	 * @param image
	 * @return
	 */
	public static String getImageUrl(String image) {
		if (image == null) {
			return "";
		} else if (image.startsWith("http")) {
			return image;
		} else {
			return ImageUrlUtil.imageUrl + image;
		}
	}
}
