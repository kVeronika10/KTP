import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.SocketTimeoutException;


public class Crawler 
{

	public URLPool urlPool;



	static final String CONST1 = "(href=\").*?\"";

	static final String CONST2 = "(<a).*?>";

	private static final Pattern TAG_A_PATTEN_COMPILE = Pattern.compile(CONST2);

	private static final Pattern CONST1_COMPILE = Pattern.compile(CONST1);

	private int maxDepth;


	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, SQLException, InterruptedException 
	{
		if (args.length != 2) {
			System.out.println("Bad format\nYou should start app like this:\njava Crawler <URL> <MAX_DEPTH>");
			return;
		}
		String url = args[0];
		Integer depth = Integer.parseInt(args[1]);
		Crawler crawl = new Crawler(url, depth);
		crawl.startCrawl();
		crawl.met8(10);
 	}


	public Crawler(String url, int maxDepth) throws UnknownHostException, IOException, ClassNotFoundException, SQLException
	{
		URLDepthPair urlpair = new URLDepthPair(url,0);
		urlPool = new URLPool();
		urlPool.addURL(urlpair);
		this.maxDepth = maxDepth;

	}

	public class CrawlerTask implements Runnable {


	    public void run()
	    {
	    	while(true)
	    	{
	    		try {
					startCrawl();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    }

	}

	public void met8(int n) throws ClassNotFoundException
	{

		for(int i = 0;i<n;i++)
		{
			CrawlerTask run = new CrawlerTask();
			Thread myThread = new Thread(run,"Thread" + i);
			myThread.start();
		}
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (urlPool.COUNT == n)
			{
				System.exit(0);
			}
		}
	}

	private void startCrawl() throws IOException, InterruptedException
	{
		
		URLDepthPair urlpair = urlPool.getURL();
		if (urlpair.depth <= maxDepth) 
		{
			if(readURL(urlpair)) urlPool.addCheckedURL(urlpair);
			//System.out.println(urlpair.url);
		}
		else urlPool.addNoneCheckedURL(urlpair);
	}

	@SuppressWarnings("finally")
	private boolean readURL(URLDepthPair urlpair) throws IOException, SocketTimeoutException
	{
		SocketConnection conn = new SocketConnection(urlpair);
		try {
			if (!conn.connect()) return false;
			conn.sendGET();
			if (conn.checkConnection())
			{
				String line;
				BufferedReader br = conn.br;
				while ((line = br.readLine()) != null)
				{
					ParseNewURL(line,urlpair);
				}
				System.out.printf("New website found! %s\n", urlpair.url);
				return true;
			}
			else return false;
		}
		catch (SocketTimeoutException exception) {
			return false;
		}
		finally {
			conn.close();
		}
	}

	private boolean ParseNewURL(String line, URLDepthPair url)
	{
		try
		{

			Matcher m = TAG_A_PATTEN_COMPILE.matcher(line);
			m.find();
			String tagA = line.substring(m.start(),m.end());
			Matcher m2 = CONST1_COMPILE.matcher(tagA);
			m2.find();
			String href = tagA.substring(m2.start(),m2.end());
			URLDepthPair newURL = new URLDepthPair(href,url.depth+1,url.domain);
			urlPool.addURL(newURL);
			return true;
			
		}
		catch (Exception e) {
			return false;
		}
	}

}
