import java.io.*;
import java.util.*;

public class ArrayColoring {
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
		// adding numbers of same parity creates sums of same parity (sum(odds) + sum(even) -> even)
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		// this worked but there is a better way

		// we don't need to do all that, we just need to check if the number of odd elements in the set is even or odd
		// because only odd elements can change parity, the existence of even elements have no impace.

		int oddCount = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] % 2 != 0) {
				oddCount++;
			}
		}

		if (oddCount % 2 == 0) {
			out.println("YES");
		} else {
			out.println("NO");
		}

		// int sumEven = 0;
		// int sumOdd = 0;

		// for (int i = 0; i < n; i++) {
		// 	if (arr[i] % 2 == 0) {
		// 		sumEven += arr[i];
		// 	} else {
		// 		sumOdd += arr[i];
		// 	}
		// }

		// if (sumEven == 0) {
		// 	if (sumOdd % 2 == 0) {
		// 		out.println("YES");
		// 	} else {
		// 		out.println("NO");
		// 	}
		// } else if (sumOdd == 0) {
		// 	out.println("YES");
		// } else if (sumOdd % 2 == 0) {
		// 	out.println("YES");
		// } else if (sumOdd % 2 != 0) {
		// 	out.println("NO");
		// }
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