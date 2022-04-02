package com.projeto;

import com.projeto.filters.SeparateChannels;
import com.projeto.model.Image;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o caminho da imagem que vc deseja manipular:");
        String imagePath = scanner.nextLine();

        System.out.println(imagePath);

        Image image = new Image(imagePath);

        System.out.println(image.getImageWidth());
        System.out.println(image.getImageHeigth());

        SeparateChannels.red(image);
        SeparateChannels.green(image);
        SeparateChannels.blue(image);

        PrintImage.showImage(image.getImage());

        scanner.close();
    }

}
