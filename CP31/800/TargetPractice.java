import java.io.*;
import java.util.*;

public class TargetPractice {
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
		char[][] grid = new char[10][10];
		for (int i = 0; i < 10; i++) {
			String row = in.next();
			grid[i] = row.toCharArray();
		}

		int score = 0;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (grid[i][j] == 'X') {
					score += findScore(i, j, out);
				}
			}
		}

		out.println(score);
	}

	private int findScore(int x, int y, PrintWriter out) {
		if ((x == 0) || (y == 0) || (x == 9) || (y == 9)) return 1;
		if ((x == 1) || (y == 1) || (x == 8) || (y == 8)) return 2;
		if ((x == 2) || (y == 2) || (x == 7) || (y == 7)) return 3;
		if ((x == 3) || (y == 3) || (x == 6) || (y == 6)) return 4;
		if ((x == 4) || (y == 4) || (x == 5) || (y == 5)) return 5;

		return 0;
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