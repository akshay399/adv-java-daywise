package sunbeam;

import java.util.*;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, 1,2,3,4,5);
		list.stream().forEach(x->System.out.println(x));
	}
}
