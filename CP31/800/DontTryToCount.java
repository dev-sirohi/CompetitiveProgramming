import java.io.*;
import java.util.*;

public class DontTryToCount {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
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
		// basically, the ans can never be greater than 5 under the given constraints

		int n = in.nextInt();
		int m = in.nextInt();
		String x = in.next();
		String s = in.next();

		for (int i = 0; i < 6; i++) {
			if (substring(x, s, out)) {
				out.println(i);
				return;
			}

			x += x;
		}

		out.println(-1);
	}

	private boolean substring(String a, String b, PrintWriter out) {
		// out.println("Comparing: " + a + " with " + b);
		if (a.length() < b.length()) return false;
		for (int i = 0; i < a.length(); i++) {
			if (b.charAt(0) == a.charAt(i)) {
				int up = i;
				int down = 0;
				int count = 0;
				while (down < b.length() && up < a.length() && a.charAt(up) == b.charAt(down)) {
					count++;
					up++;
					down++;
				}

				if (count == b.length()) return true;
			}
		}

		return false;
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