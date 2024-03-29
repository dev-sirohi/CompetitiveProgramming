import java.io.*;
import java.util.*;

public class ClockConversion {
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
		String time = in.next();
		String[] timeArr = time.split(":");
		int hour = Integer.parseInt(timeArr[0]);
		int min = Integer.parseInt(timeArr[1]);

		if (hour < 12) {
			if (hour == 0) {
				hour = 12;
				if (min < 10) {
					out.println(hour + ":" + "0" + min + " AM");
				} else {
					out.println(hour + ":" + min + " AM");
				}
			}else if (hour < 10) {
				if (min < 10) {
					out.println("0" + hour + ":" + "0" + min + " AM");
				} else {
					out.println("0" + hour + ":" + min + " AM");
				}
			} else {
				if (min < 10) {
					out.println(hour + ":" + "0" + min + " AM");
				} else {
					out.println(hour + ":" + min + " AM");
				}
			}
		} else {
			hour = hour == 12 ? 12 : hour - 12;
			if (hour < 10) {
				if (min < 10) {
					out.println("0" + hour + ":" + "0" + min + " PM");
				} else {
					out.println("0" + hour + ":" + min + " PM");
				}
			} else {
				if (min < 10) {
					out.println(hour + ":" + "0" + min + " PM");
				} else {
					out.println(hour + ":" + min + " PM");
				}
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