package udp.exe;

public class RunnerServer {

	public static void main(String[] args) {

		UdpServer server = new UdpServer(4444);
		server.runServer();

	}

}
