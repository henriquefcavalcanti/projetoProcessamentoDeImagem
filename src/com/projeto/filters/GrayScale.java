package com.projeto.filters;

import com.projeto.PrintImage;
import com.projeto.model.Image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GrayScale {

    public static void grayScaleMedia(Image image) {
        BufferedImage newImage = new BufferedImage(image.getImageWidth(), image.getImageHeigth(), BufferedImage.TYPE_INT_RGB);

        for (int line = 0; line < image.getImageHeigth(); line++) {
            for (int column = 0; column < image.getImageWidth(); column++) {

                int rgb = image.getImage().getRGB(column, line);
                Color color = new Color(rgb);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int media = (red + green + blue) / 3;

                Color vermelhoApenas = new Color(media, media, media);
                newImage.setRGB(column, line, vermelhoApenas.getRGB());

            }
        }

        PrintImage.showImage(newImage);

    }

    public static void grayScaleBanda(Image imgEntrada, int banda) {
        int largura = imgEntrada.getImageWidth();
        int altura = imgEntrada.getImageHeigth();
        BufferedImage newImage = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int linha = 0; linha < altura; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {

                int rgb = imgEntrada.getImage().getRGB(coluna, linha);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                Color novaCor = null;
                if (banda == 1) {
                    novaCor = new Color(red, red, red);

                } else if (banda == 2) {
                    novaCor = new Color(green, green, green);
                } else if (banda == 3) {
                    novaCor = new Color(blue, blue, blue);
                }

                assert novaCor != null;
                newImage.setRGB(coluna, linha, novaCor.getRGB());

            }
        }

        PrintImage.showImage(newImage);

    }

}
