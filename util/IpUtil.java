
public class IpUtil {

	public static String getIpAddress(String ip) {
		try {
			System.out.println("進到IpUtil");
			return IPSeeker.getInstance().getAddress(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "未知區域";
	}

}
