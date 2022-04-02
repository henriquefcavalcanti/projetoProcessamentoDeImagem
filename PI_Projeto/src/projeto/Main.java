package projeto;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o caminho da imagem que vc deseja manipular: ");
		String imagePath = scanner.nextLine();
		
		System.out.println(imagePath);
		 
		
		scanner.close();
	}

}
