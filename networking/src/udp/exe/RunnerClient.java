package udp.exe;

public class RunnerClient {

	public static void main(String[] args) {
		
		UdpClient client = new UdpClient(4445);
		client.runClient();

	}

}
