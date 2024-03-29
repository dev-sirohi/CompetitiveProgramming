import java.io.*;
import java.util.*;

public class NearlyShortestRepeatingSubstring {
	final static int N = (int) 2e5 + 20;
	static List<List<Integer>> dv = new ArrayList<>();

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);

		for (int i = 0; i < N; i++) {
			dv.add(new ArrayList<Integer>());
		}

		// this piece of code is used to add all the divisors of a number to it
		// 1 -> 1
		// 2 -> 1 2
		// 3 -> 1 3
		// 4 -> 1 2 4
		for (int i = 1; i < N; i++) {
			for (int j = i; j < N; j += i) { // check with j * j < N
				dv.get(j).add(i);
			}
		}

		TaskA solver = new TaskA();
		int t = in.nextInt();
		while (t-- > 0) {
			solver.solve(t, in, out);
		}
		out.close();
	}
}

class TaskA {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		// the basic logic behind this code is that
		// any number can only have less than equals to cube root of the number divisors
		// (the proof for square root is easy and explicable in simple conversational terms but for cube root it is quite complicated)
		// so the solution is to simply bruteforce through all the possible divisors since they are not that many
		// also, there will be two cases only:
		// 1. (0, x)
		// 2. (x, x)
		// because, if it's not case 1, then there's a different element in 0->x
		// and if it's not case 2 either, then there's a different element in both 0->x and x->x
		// that makes two differences and then the answer will be no.
		// example is: hshahaha
		// we check 0,1 -> hs and it gives us 3 differences
		// then we check 1,1 -> ha and it gives us only 1 difference
		// if the example was hshqhaha, then things would be different because then neither case will work
		// because there are 2 different elements.

		int n = in.nextInt();
		String s = in.next();

		for (int div : NearlyShortestRepeatingSubstring.dv.get(n)) {
			String substr = s.substring(0, div);
			String newStr = "";
			// i < n/div because we want to create the full string
			// n = 8, div = 2
			// then we have to have the substr 4 times
			for (int i = 0; i < (n / div); i++) {
				newStr += substr;
			}


			if (diff(newStr, s, out) <= 1) {
				out.println(div);
				return;
			}

			substr = s.substring(div, 2 * div);
			newStr = "";

			for (int i = 0; i < n / div; i++) {
				newStr += substr;
			}

			if (diff(newStr, s, out) <= 1) {
				out.println(div);
				return;
			}
		}
	}

	private int diff(String a, String b, PrintWriter out) {
		if (a.length() != b.length()) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) count++;
		}

		return count;
	}
}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}
	boolean hasNext() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (Exception e) {
				return false;
				// TODO: handle exception
			}
		}
		return true;
	}
	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}
	public String nextLine() {
		String str = null;
		try {
			str = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	public int nextInt() {
		return Integer.parseInt(next());
	}
	public double nextDouble() {
		return Double.parseDouble(next());
	}
	public long nextLong() {
		return Long.parseLong(next());
	}

}