import java.io.*;
import java.util.*;

public class MinimizePermutationSubarrays {
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
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		int idxn = -1, idx1 = -1, idx2 = -1;

		for (int i = 0; i < n; i++) {
			if (arr[i] == n) {
				idxn = i;
			} else if (arr[i] == 1) {
				idx1 = i;
			} else if (arr[i] == 2) {
				idx2 = i;
			}
		}

		if (idxn < idx1 && idxn < idx2) {
			out.println((idxn + 1) + " " + (Math.min(idx1, idx2) + 1));
		} else if ((idxn > idx1 && idxn < idx2) || (idxn < idx1 && idxn > idx2)) {
			out.println((idx1 + 1) + " " + (idx2 + 1));
		} else if (idxn > idx1 && idxn > idx2) {
			out.println((idxn + 1) + " " + (Math.max(idx1, idx2) + 1));
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