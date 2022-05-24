package main;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World");
		List<String> list = Arrays.asList("ola","adeus","tudo");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
