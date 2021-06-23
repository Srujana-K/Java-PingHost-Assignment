import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int pingCount = 5;
        Ping p = new Ping();
        System.out.println("Enter url/ipaddress to ping: ");
        String url = sc.next();
        System.out.print(p.findMedianPingTime(pingCount,url)+" ms");
    }
}
