package weibo4j.examples.timeline;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

public class QueryId {

	public static void main(String[] args) {
		String access_token = WeiboConfig.getValue("access_token");//"2.00l7AovCf7hvVE58464c62e08L9iwD";//WeiboConfig.getValue("access_token");
		String mid = "CjcBfv03i";
		Timeline tm = new Timeline(access_token);
		try {
			JSONObject id = tm.queryId( mid, 1,1);
			Log.logInfo(id.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
