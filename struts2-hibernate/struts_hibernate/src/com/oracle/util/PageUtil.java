package com.oracle.util;

public class PageUtil {

	public static int getMaxPage(int maxSize, int pageSize) {
		int maxPage = 1;
		if (maxSize % pageSize == 0)
			maxPage = maxSize / pageSize;
		else
			maxPage = (maxSize / pageSize) + 1;
		if (maxPage == 0)
			maxPage = 1;
		return maxPage;
	}
}
