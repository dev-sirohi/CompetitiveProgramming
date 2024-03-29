import java.io.*;
import java.util.*;

public class CoverInWater {
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
		// if there exists a series of 3 or more empty cells, then the ans is 2, otherwise the number of empty cells

		int n = in.nextInt();
		String s = in.next();

		Boolean stretch = false;
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '.') {
				count++;
				if (count >= 3) {
					stretch = true;
					break;
				}
			} else count = 0;
		}

		if (stretch) out.println(2);
		else {
			count = 0;
			for (int i = 0; i < n; i++) {
				if (s.charAt(i) == '.') {
					count++;
				}
			}
			out.println(count);
		}
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