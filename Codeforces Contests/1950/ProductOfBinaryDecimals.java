import java.io.*;
import java.util.*;

public class ProductOfBinaryDecimals {
	final static int N = (int) 20;
	private static boolean[] dp = new boolean[N];
	private static ArrayList<Integer> binaryDecimals = new ArrayList<>();

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		// TaskA solver = new TaskA();

		binaryDecimals.add(1);
		for (int i = 0; i < binaryDecimals.size(); i++) {
			if (10 * binaryDecimals.get(i) >= N) continue; // why this
			binaryDecimals.add(binaryDecimals.get(i) * 10);
			binaryDecimals.add((binaryDecimals.get(i) * 10) + 1);
		}

		dp[1] = true;
		for (int i = 2; i < N; i++) {
			// out.println("i is: " + i);
			for (int bd : binaryDecimals) {
				// out.println("bd is: " + bd);
				if (i % bd == 0) {
					// SO THE NUMBER IS DIVISIBLE BY THIS PARTICULAR BD
					// out.println("i is % 0 by bd");
					// dp[i] = dp[i] || dp[i / bd];
					// AND THE OTHER NUMBER IS ALSO A BD, HENCE PRODUCT OF BD
					dp[i] = dp[i / bd];
					// out.println("dp[i] is: " + dp[i] + " and dp[i / bd] is: " + dp[i / bd]);
					if (dp[i]) break;
				}
			}
		}

		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		out.println(totalTime);

		// int t = in.nextInt();
		// while (t-- > 0) {
		// 	// solver.solve(t, in, out);
		// 	int n = in.nextInt();
		// 	if (dp[n]) out.println("YES");
		// 	else out.println("NO");
		// }
		out.close();
	}
}

// class TaskA {
// 	public void solve(int testNumber, InputReader in, PrintWriter out) {
// 		int n = in.nextInt();

// 	}
// }

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