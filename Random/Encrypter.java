import java.io.*;
import java.util.*;

public class Encrypter {
	private static final String _password = "a@d$^Gs15F";
	private Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println(xorEncrypt("instagram"));
	}

	private static String myEncrypt(String key) {
		StringBuilder encryptedPassword = new StringBuilder();

		
	}

	private static String xorEncrypt(String key) {
		StringBuilder encryptedPassword = new StringBuilder();

		for (int i = 0; i < _password.length(); i++) {
			encryptedPassword.append(_password.charAt(i) ^ key.charAt(i % key.length()));
		}

		return encryptedPassword.toString();
	}
}