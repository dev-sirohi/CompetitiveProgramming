import java.io.*;
import java.util.*;

public class TwinPermutations {
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
		// 1 5 6 2 3 4
		// 1 3 2 6 5 4
		// for each sorted num from beginning, print same
		// for rest, make pairs

		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		int i = 0;
		for (i = 0; i < n; i++) {
			if (arr[i] != i + 1) {
				break;
			} else {
				out.print(arr[i] + " ");
			}
		}

		/*
			1 5 6 2 3 4
			1
			now n = 6
			and we are at index 2
			so we no longer have access to [1]
			the smallest is 2
			the largest is 6
			so if we encounter 6 (largest), we give 2 (smallest)
			if we encounter 5 (largest - 1), we give 3 (smallest + 1)
		*/

		int smallest = i + 1;
		int largest = n;

		for (; i < n; i++) {
			int diff = largest - arr[i];
			out.print((smallest + diff) + " ");
		}

		out.println();
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