import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ping {
    public float findMedianPingTime(int pingCount, String url){
        ArrayList<Float> times = new ArrayList<>();
        int count = pingCount;
        try{
            String command = "ping -c "+pingCount+" "+url;
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String pingStats = null;
            int flag = 0;
            while((pingStats=br.readLine())!=null && (count--)>=0){
                if(pingStats.contains("time=")){
                    int position = pingStats.indexOf("time=");
                    String timeInMs = pingStats.substring(position+5);
                    float time = Float.parseFloat(timeInMs.substring(0,timeInMs.length()-3));
                    times.add(time);
                }
            }
        }
        catch(Exception e){
            System.out.println("Exception occured");
            e.printStackTrace();
        }
        Collections.sort(times);
        if(times.size()>0){
            if(times.size()%2!=0)
                return times.get((times.size()/2)+1);
            else
                return times.get((times.size()+1)/2);
        }
        return (float) 0.00;
    }
}
