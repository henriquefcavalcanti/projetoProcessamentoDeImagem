package com.projeto.filters;

import com.projeto.PrintImage;
import com.projeto.model.Image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SeparateChannels {

    public static void red(Image image){
        BufferedImage newImageRed = new BufferedImage(image.getImageWidth(), image.getImageHeigth(), BufferedImage.TYPE_INT_RGB);

        for (int line = 0; line < image.getImageHeigth(); line++) {
            for (int column = 0; column < image.getImageWidth(); column++) {

                int rgb = image.getImage().getRGB(column, line);
                Color color = new Color(rgb);
                int red = color.getRed();
                Color vermelhoApenas = new Color(red, 0, 0);
                newImageRed.setRGB(column, line, vermelhoApenas.getRGB());

            }
        }

        PrintImage.showImage(newImageRed);

    }

    public static void green(Image image){
        BufferedImage newImageGreen = new BufferedImage(image.getImageWidth(), image.getImageHeigth(), BufferedImage.TYPE_INT_RGB);

        for (int line = 0; line < image.getImageHeigth(); line++) {
            for (int column = 0; column < image.getImageWidth(); column++) {

                int rgb = image.getImage().getRGB(column, line);
                Color color = new Color(rgb);
                int green = color.getGreen();
                Color vermelhoApenas = new Color(0, green, 0);
                newImageGreen.setRGB(column, line, vermelhoApenas.getRGB());

            }
        }

        PrintImage.showImage(newImageGreen);

    }

    public static void blue(Image image){
        BufferedImage newImageBlue = new BufferedImage(image.getImageWidth(), image.getImageHeigth(), BufferedImage.TYPE_INT_RGB);

        for (int line = 0; line < image.getImageHeigth(); line++) {
            for (int column = 0; column < image.getImageWidth(); column++) {

                int rgb = image.getImage().getRGB(column, line);
                Color color = new Color(rgb);
                int blue = color.getBlue();
                Color vermelhoApenas = new Color(0, 0, blue);
                newImageBlue.setRGB(column, line, vermelhoApenas.getRGB());

            }
        }

        PrintImage.showImage(newImageBlue);

    }

    public static void aumentoDeTonalidade(Image imgEntrada, int banda, int aumento) {
        int largura = imgEntrada.getImage().getWidth();
        int altura = imgEntrada.getImage().getHeight();
        BufferedImage imageSaida = new BufferedImage(imgEntrada.getImageWidth(), imgEntrada.getImageHeigth(), BufferedImage.TYPE_INT_RGB);
//        Image imageSaida = new Image();

        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {

                int rgb = imgEntrada.getImage().getRGB(coluna, linha);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                Color novaCor = null;
                if (banda == 1) {
                    if(red+aumento<= 255) {
                        novaCor = new Color(red + aumento, green, blue);
                    } else {
                        novaCor = new Color(255, green, blue);
                    }
                } else if (banda == 2) {
                    if(green + aumento <= 255) {
                        novaCor = new Color(red, green + aumento, blue);
                    } else {
                        novaCor = new Color(red, 255, blue);
                    }
                } else if (banda == 3) {
                    if(blue + aumento <= 255) {
                        novaCor = new Color(red, green, blue + aumento);
                    } else {
                        novaCor = new Color(red, green, 255);
                    }
                }

                assert novaCor != null;
                imageSaida.setRGB(coluna, linha, novaCor.getRGB());

            }
        }

        PrintImage.showImage(imageSaida);

    }

}
