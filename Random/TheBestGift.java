import java.io.*;
import java.util.*;

public class TheBestGift {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

static class TaskA {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n];
		int[] q = new int[m + 1];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			q[a[i]]++;
		}
		int sum = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = i + 1; j <= m; j++) {
				sum += q[i] * q[j];
			}
		}
		out.println(sum);
	}
}

static class InputReader {
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