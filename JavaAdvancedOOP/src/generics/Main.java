package generics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int num = Integer.parseInt(reader.readLine());
//       List<Box<Integer>> boxes = new ArrayList<>();
//        while(num-- > 0) {
//            Box<Integer> box = new Box<>(Integer.parseInt(reader.readLine()));
//            boxes.add(box);
//        }
//        for (Box<Integer> box : boxes) {
//            System.out.println(box);
//        }


        List<String> list = new ArrayList<>();
        list.add("Ginka");
        list.add("Mimi");
        list.add("Dancho");


        String el = list.get(2);
        list.set(2,list.get(0));
        list.set(0,el);

        System.out.println(list);

    }
}
