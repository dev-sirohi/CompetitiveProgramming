import java.io.*;
import java.util.*;

public class Upscaling {
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
		int n = in.nextInt();
		int m = n;

		for (int i = 0; i < n; i++) {
			printRow(i, m, out);
			out.println();
			printRow(i, m, out);
			out.println();
		}
	}

	private void printRow(int row, int col, PrintWriter out) {
		if (row % 2 == 0) {
			boolean toSwitch = false;
			for (int i = 0; i < col; i++) {
				if (toSwitch) {
					out.print("..");
				} else {
					out.print("##");
				}
				toSwitch = !toSwitch;
			}
		} else {
			boolean toSwitch = false;
			for (int i = 0; i < col; i++) {
				if (toSwitch) {
					out.print("##");
				} else {
					out.print("..");
				}
				toSwitch = !toSwitch;
			}
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