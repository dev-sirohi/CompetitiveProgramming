import java.io.*;
import java.util.*;

public class ForbiddenInteger {
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
		// as long as you have 1, the ans is yes
		// when you dont have 1, then there are conditions
		// if you have 2, then all even are possible
		// and if you have 3 as well, then all odds are possible as well

		int n = in.nextInt();
		int k = in.nextInt();
		int x = in.nextInt();

		if (x != 1) {
			out.println("YES");
			ArrayList<Integer> res = new ArrayList<>();
			int sum = 0;
			while (true) {
				if (k == x) {
					k--;
					continue;
				}
				if (sum + k == n) {
					res.add(k);
					break;
				}
				if (sum + k < n) {
					res.add(k);
					sum += k;
				} else k--;
			}

			out.println(res.size());

			for (int i = 0; i < res.size(); i++) {
				out.print(res.get(i) + " ");
			}

			out.println();
		} else {
			if (k == 2 && n % 2 == 0) {
				out.println("YES");
				ArrayList<Integer> res = new ArrayList<>();
				int sum = 0;
				while (true) {
					if (sum + k == n) {
						res.add(k);
						break;
					}
					if (sum + k < n) {
						res.add(k);
						sum += k;
					} else k--;
				}

				out.println(res.size());

				for (int i = 0; i < res.size(); i++) {
					out.print(res.get(i) + " ");
				}

				out.println();
			} else if (k >= 3) {
				k = 3;
				out.println("YES");
				ArrayList<Integer> res = new ArrayList<>();
				int sum = 0;
				while (true) {
					if (sum + k == n) {
						res.add(k);
						break;
					}
					if (sum + k < n) {
						if (n - (sum + k) < 2) {
							k--;
						} else {
							res.add(k);
							sum += k;
						}
					} else k--;
				}

				out.println(res.size());

				for (int i = 0; i < res.size(); i++) {
					out.print(res.get(i) + " ");
				}

				out.println();
			} else {
				out.println("NO");
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