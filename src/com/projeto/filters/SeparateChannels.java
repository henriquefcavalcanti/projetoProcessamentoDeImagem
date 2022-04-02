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

}
