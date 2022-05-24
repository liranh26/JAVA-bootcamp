package networking;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetDemo {

	public static void main(String[] args) throws UnknownHostException {
		
		/*
		 * obtain the IP and host name
		 */
		InetAddress myAddress = InetAddress.getLocalHost();
		System.out.println(myAddress);
		

		String myIP = myAddress.getHostAddress();
		String myHostName = myAddress.getHostName();
		
		System.out.println("My IP %s and my name is %s".formatted(myIP, myHostName));
		
		/*
		 * get InetAddres by name
		 */
		InetAddress queryByHostNameAddress = InetAddress.getByName(myHostName);
		System.out.println(queryByHostNameAddress);
		
		/*
		 * get InetAddres by IP
		 */
		InetAddress queryByHostIPAddress = InetAddress.getByName(myIP);
		System.out.println(queryByHostIPAddress);
		
		/*
		 * get InetAddres from webpage name
		 */
		InetAddress queryByWebsiteAddress = InetAddress.getByName("google.com");
		System.out.println(queryByWebsiteAddress);
		
		/*
		 * get all InetAddres of server
		 */
		InetAddress[] addresses = InetAddress.getAllByName("google.com");
		System.out.println( Arrays.toString(addresses) );
		
		
		/*
		 * loopback - what we send 
		 */
		InetAddress myLoop = InetAddress.getLoopbackAddress();
		System.out.println(myLoop);
		
		//
		InetAddress bunGurionWebsiteAddress = InetAddress.getByName("in.bgu.ac.il");
		System.out.println("Ben Gurion : " + bunGurionWebsiteAddress);
		
		InetAddress facebookWebsiteAddress = InetAddress.getByName("facebook.com");
		String facebookHostname = facebookWebsiteAddress.getHostName();
		System.out.println("Facebook : " + facebookWebsiteAddress+", Hostname : " + facebookHostname);
	}
}
