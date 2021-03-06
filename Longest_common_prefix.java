import java.util.*;

public class Longest_common_prefix {
	
	static final int ALPHABET_SIZE = 26;
	static class TrieNode
	{
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		boolean isLeaf;
		public TrieNode() {
			isLeaf = false;
			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
		}
	};
	
	static TrieNode root;
	static int indexs;
	static void insert(String key)
	{
		int length = key.length();
		int index;
	
		TrieNode pCrawl = root;
	
		for (int level = 0; level < length; level++)
		{
			index = key.charAt(level) - 'a';
			if (pCrawl.children[index] == null)
				pCrawl.children[index] = new TrieNode();
	
			pCrawl = pCrawl.children[index];
		}
		pCrawl.isLeaf = true;
	}
	static int countChildren(TrieNode node)
	{
		int count = 0;
		for (int i=0; i<ALPHABET_SIZE; i++)
		{
			if (node.children[i] != null)
			{
				count++;
				indexs = i;
			}
		}
		return (count);
	}
	
	static String walkTrie()
	{
		TrieNode pCrawl = root;
		indexs = 0;
		String prefix = "";
	
		while (countChildren(pCrawl) == 1 &&
				pCrawl.isLeaf == false)
		{
			pCrawl = pCrawl.children[indexs];
			prefix += (char)('a' + indexs);
		}
		return prefix;
	}
	
	static void constructTrie(String arr[], int n)
	{
		for (int i = 0; i < n; i++)
			insert (arr[i]);
		return;
	}
	
	static String commonPrefix(String arr[], int n)
	{
		root = new TrieNode();
		constructTrie(arr, n);
		return walkTrie();
	}
	
	public static void main(String args[])
	{
	    Scanner sc =new Scanner(System.in);
	    int n =sc.nextInt();
		String arr[] = new String[n];
		for(int i=0;i<n;i++){
		    arr[i]=sc.next();
		}
		String ans = commonPrefix(arr, n);
		if (ans.length() != 0)
			System.out.println("The longest common prefix is "+ans);
		else
			System.out.println("There is no common prefix");
	}
}

