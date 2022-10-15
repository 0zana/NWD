package rekurencja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NWD2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj a = ");
		int a = sc.nextInt();
		System.out.println("Podaj b = ");
		int b = sc.nextInt();
		ArrayList<Integer> liczbyPierwsze = pierwsze();
		Collections.reverse(liczbyPierwsze);
		System.out.println("Największy wspólny dzielnik "+ a+ " i "+ b + " to " + rozklad(a, b, liczbyPierwsze));
			
		}
	
	public static ArrayList<Integer> pierwsze() {
		ArrayList<Integer> pierwsze = new ArrayList<>();
		pierwsze.add(2);
		for (int i=1; i<100; i++) {
			for (int j=i-1; j>0; j--) {
				if(i%j!=0) {
					if(j==2) {
						pierwsze.add(i);
					}		
				}else {
					j=0;
				}	
			}
		}
		return pierwsze;
	}
	
	public static int rozklad(int a, int b, ArrayList<Integer> pierwsze) {
		ArrayList<Integer> rozkladA = new ArrayList<>();
		ArrayList<Integer> rozkladB = new ArrayList<>();
		int wynik=1;
		while(a!=1) {
			 for(int i:pierwsze) {
				 if(a%i==0) {
					 a=a/i;
					 rozkladA.add(i);
				 }
		 }
		}
		while(b!=1) {
			 for(int i:pierwsze) {
				 if(b%i==0) {
					 b=b/i;
					 rozkladB.add(i);
				 }
		 }
		}
		for(int i:rozkladA) {
			if (rozkladB.contains(i)){
				wynik=wynik*i;
			}
		}
		
		return wynik;
	}
}
