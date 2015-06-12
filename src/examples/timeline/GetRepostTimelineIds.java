package weibo4j.examples.timeline;

import java.util.ArrayList;
import java.util.List;
import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.RepostTimelineIds;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class GetRepostTimelineIds {

    public static void main(String[] args) {
        String access_token = WeiboConfig.getValue("access_token");//"2.00l7AovCf7hvVE58464c62e08L9iwD";//WeiboConfig.getValue("access_token");
        String id = "3845766697388372";
        Timeline tm = new Timeline(access_token);
        int count = 0;
        long nextCursor = 0;
        long total = 0;

        try {
            RepostTimelineIds ids = tm.getRepostTimelineIds(id);
            nextCursor = ids.getNextCursor();//
            total = ids.getTotalNumber();
            count += ids.getStatusesIds().size();
            List<String> totalList = new ArrayList<String>();
            totalList.addAll(ids.getStatusesIds());
            Log.logInfo(ids.toString());
            Log.logInfo("Total count: " + total + ". This batch count: " + String.valueOf(ids.getStatusesIds().size()) + " up to date count: " + totalList.size());

            while (count < total){
                RepostTimelineIds nextIds = tm.getRepostTimelineIdsWithCursor(id, String.valueOf(nextCursor));
                count += nextIds.getStatusesIds().size();
                totalList.addAll(nextIds.getStatusesIds());
                Log.logInfo(nextIds.toString());
                Log.logInfo("NextCursor run, This batch count: " + String.valueOf(nextIds.getStatusesIds().size()) + " up to date count: " + totalList.size());
            } 
            Log.logInfo("Final count should be 344: actual value is: "+ count);
        } catch (WeiboException e) {
            e.printStackTrace();
        }
    }
}
