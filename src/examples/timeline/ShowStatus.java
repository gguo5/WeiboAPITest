package weibo4j.examples.timeline;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Status;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class ShowStatus {

	public static void main(String[] args) {
		String access_token = WeiboConfig.getValue("access_token");//"2.00l7AovCf7hvVE58464c62e08L9iwD";//WeiboConfig.getValue("access_token");
		String id = "3845766697388372";
		Timeline tm = new Timeline(access_token);
		try {
			Status status = tm.showStatus(id);
			Log.logInfo(status.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
