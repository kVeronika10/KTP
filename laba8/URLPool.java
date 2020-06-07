import java.util.HashSet;
import java.util.LinkedList;

public class URLPool {


	public int COUNT = 0;
	public HashSet<String> allURL = new HashSet<String>();
	public HashSet<String> allDomain = new HashSet<String>();
	public LinkedList <URLDepthPair> unCheckedList = new LinkedList <URLDepthPair>();
	public LinkedList <URLDepthPair> checkedList = new LinkedList <URLDepthPair>();
	LinkedList <URLDepthPair> noneCheckedList = new LinkedList <URLDepthPair>();


	public void addNoneCheckedURL (URLDepthPair urlpair)
	{
		noneCheckedList.addLast(urlpair);
	}

	public void addCheckedURL(URLDepthPair urlpair)
	{
		checkedList.addLast(urlpair);
	}

	public synchronized  boolean addURL(URLDepthPair urlpair)
	{
		if (allURL.contains(urlpair.url)) return false;
		else {
			allURL.add(urlpair.url);
			if (allDomain.contains(urlpair.domain)) unCheckedList.addLast(urlpair);
			else {
				unCheckedList.addFirst(urlpair);
				allDomain.add(urlpair.domain);
			}
			this.notify();
			return true;
		}
	}


	public synchronized URLDepthPair getURL() throws InterruptedException
	{
		if (unCheckedList.isEmpty())
		{
			COUNT++;
			this.wait();
			COUNT--;
			return unCheckedList.pollFirst();
		}
		return unCheckedList.pollFirst();
	}


	
	
	
	
}
