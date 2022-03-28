package ada.wm2.helper;

public class Counter{
	private static int count;

	public static synchronized int getCount(){
		return ++count;
	}
}