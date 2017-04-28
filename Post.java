import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Post
{
	public static void main(String[] args) throws IOException
	{
		URL url = new URL("http://localhost:3000/");
		Scanner scan = new Scanner(System.in);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod("POST");
		OutputStreamWriter out = new OutputStreamWriter(
		  httpCon.getOutputStream());
		System.out.print("Enter data to send to server: ");
		out.write("data=" + scan.nextLine());
		out.flush();
		System.out.println(httpCon.getResponseCode());
		System.out.println(httpCon.getResponseMessage());
		out.close();
	}
}