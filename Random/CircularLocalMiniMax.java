import java.io.*;
import java.util.*;

public class CircularLocalMiniMax {
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
		// edit as per needed
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		if (n % 2 != 0) {
			out.println("NO");
			return;
		}

		Arrays.sort(arr);

		int[] res = new int[n];

		int i = 0, j = 2;
		int k = 0;

		while (j < n && k < n && i < n) {
			res[k++] = arr[i++];
			while (j < n && arr[j] <= arr[i - 1]) {
				j++;
			}
			if (j >= n || k >= n) break;
			res[k++] = arr[j++];
		}

		if (k != j) out.println("NO");
		else {
			out.println("YES");
			for (i = 0; i < n; i++) {
				out.print(res[i] + " ");
			}
		}

		out.println();
	}
}


/*

ROUGH WORK

1 1 1 11 111 1111

1 11 1 111 1 1111

1 1 2

1 2 1

1 4 8 9

1 

*/


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