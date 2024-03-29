import java.io.*;
import java.util.*;

public class MakeItBeautiful {
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

		int sum = arr[0];
		for (int i = 1; i < n; i++) {
			out.println("The sum is - " + sum + " and the current elem is - " + arr[i]);
			if (sum == arr[i]) {
				out.println("We found our ugly element");
				int j = 0;
				while (arr[j] == arr[i] || i == j) {
					j++;
					if (j == n) break;
				}

				if (j == n) {
					out.println("NO");
					return;
				}

				out.print("Now we add our new to-be swapped element into the sum - ");

				sum += arr[i];

				out.println(arr[i]);

				out.println("The j element, which is supposed to be something other than our ugly element, is - " + arr[j] + " at index " + j);

				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
			sum += arr[i];

		}

		out.println("YES");
		for (int i = 0; i < n; i++) {
			out.print(arr[i] + " ");
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