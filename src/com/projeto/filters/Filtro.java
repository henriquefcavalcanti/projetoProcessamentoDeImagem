package com.projeto.filters;

import com.projeto.PrintImage;
import com.projeto.model.Image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Filtro {

    public static void negativo(Image image) {
        BufferedImage newImage = new BufferedImage(image.getImageWidth(), image.getImageHeigth(), BufferedImage.TYPE_INT_RGB);

        for (int line = 0; line < image.getImageHeigth(); line++) {
            for (int column = 0; column < image.getImageWidth(); column++) {

                int rgb = image.getImage().getRGB(column, line);
                Color color = new Color(rgb);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                Color vermelhoApenas = new Color(255 - red, 255 - green, 255 - blue);
                newImage.setRGB(column, line, vermelhoApenas.getRGB());

            }
        }

        PrintImage.showImage(newImage);

    }

    public static void negativoYIQ(double[][][] imgYiq) {
        int largura = imgYiq.length;
        int altura = imgYiq[0].length;

        BufferedImage newImage = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int linha = 0; linha < largura; linha++) {
            for (int coluna = 0; coluna < altura; coluna++) {


                int red = (int) (255 - (imgYiq[linha][coluna][0] + 0.956 * imgYiq[linha][coluna][1] + 0.621 * imgYiq[linha][coluna][2]));
                int green = (int) (255 - (imgYiq[linha][coluna][0] - 0.272 * imgYiq[linha][coluna][1] - 0.647 * imgYiq[linha][coluna][2]));
                int blue = (int) (255 - (imgYiq[linha][coluna][0] - 1.106 * imgYiq[linha][coluna][1] + 1.703 * imgYiq[linha][coluna][2]));

                if (red > 255) {
                    red = 255;
                }
                if (blue > 255) {
                    blue = 255;
                }
                if (green > 255) {
                    green = 255;
                }

                if (red < 0)
                    red = 0;
                if (green < 0)
                    green = 0;
                if (blue < 0)
                    blue = 0;

                Color novaColor = new Color(red, green, blue);
                newImage.setRGB(linha, coluna, novaColor.getRGB());

            }
        }

        PrintImage.showImage(newImage);
    }

    public static void limiarizacao(Image image, int limiar) {
        BufferedImage newImage = new BufferedImage(image.getImageWidth(), image.getImageHeigth(), BufferedImage.TYPE_INT_RGB);

        for (int line = 0; line < image.getImageHeigth(); line++) {
            for (int column = 0; column < image.getImageWidth(); column++) {

                int rgb = image.getImage().getRGB(column, line);
                Color color = new Color(rgb);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int media = (red + green + blue) / 3;

                int newColor;

                if (media > limiar) {
                    newColor = 255;
                } else {
                    newColor = 0;
                }

                Color vermelhoApenas = new Color(newColor, newColor, newColor);
                newImage.setRGB(column, line, vermelhoApenas.getRGB());

            }
        }

        PrintImage.showImage(newImage);

    }

    public static double[][][] convertRgbtoYiq(Image image) {

        int largura = image.getImageWidth();
        int altura = image.getImageHeigth();

        double[][][] imgYIQ = new double[largura][altura][3];

        for (int linha = 0; linha < largura; linha++) {
            for (int coluna = 0; coluna < altura; coluna++) {


                int rgb = image.getImage().getRGB(linha, coluna);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                imgYIQ[linha][coluna][0] = 0.299 * red + 0.587 * green + 0.144 * blue; // Y
                imgYIQ[linha][coluna][1] = 0.596 * red - 0.274 * green - 0.322 * blue; // I
                imgYIQ[linha][coluna][2] = 0.211 * red - 0.523 * green + 0.312 * blue; // Q
            }
        }

        return imgYIQ;

    }

    public static void convertYiqToRgb(double[][][] imgYiq) {
        int largura = imgYiq.length;
        int altura = imgYiq[0].length;

        BufferedImage newImage = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int linha = 0; linha < largura; linha++) {
            for (int coluna = 0; coluna < altura; coluna++) {

                int red = (int) (imgYiq[linha][coluna][0] + 0.956 * imgYiq[linha][coluna][1] + 0.621 * imgYiq[linha][coluna][2]);
                int green = (int) (imgYiq[linha][coluna][0] - 0.272 * imgYiq[linha][coluna][1] - 0.647 * imgYiq[linha][coluna][2]);
                int blue = (int) (imgYiq[linha][coluna][0] - 1.106 * imgYiq[linha][coluna][1] + 1.703 * imgYiq[linha][coluna][2]);

                if (red > 255) {
                    red = 255;
                }
                if (blue > 255) {
                    blue = 255;
                }
                if (green > 255) {
                    green = 255;
                }

                Color novaColor = new Color(red, green, blue);
                newImage.setRGB(linha, coluna, novaColor.getRGB());

            }
        }

        PrintImage.showImage(newImage);

    }

    public static void brilhoAddRGB(Image image, Integer valorAdd) {
        BufferedImage newImage = new BufferedImage(image.getImageWidth(), image.getImageHeigth(), BufferedImage.TYPE_INT_RGB);

        for (int line = 0; line < image.getImageHeigth(); line++) {
            for (int column = 0; column < image.getImageWidth(); column++) {

                int rgb = image.getImage().getRGB(column, line);
                Color color = new Color(rgb);
                int red = color.getRed() + valorAdd;
                int green = color.getGreen() + valorAdd;
                int blue = color.getBlue() + valorAdd;

                if (red > 255) {
                    red = 255;
                }
                if (green > 255) {
                    green = 255;
                }
                if (blue > 255) {
                    blue = 255;
                }

                if (red < 0)
                    red = 0;
                if (green < 0)
                    green = 0;
                if (blue < 0)
                    blue = 0;

                Color vermelhoApenas = new Color(red, green, blue);
                newImage.setRGB(column, line, vermelhoApenas.getRGB());

            }
        }

        PrintImage.showImage(newImage);
    }

    public static void brilhoMttRGB(Image image, Integer valorMtt) {
        BufferedImage newImage = new BufferedImage(image.getImageWidth(), image.getImageHeigth(), BufferedImage.TYPE_INT_RGB);

        for (int line = 0; line < image.getImageHeigth(); line++) {
            for (int column = 0; column < image.getImageWidth(); column++) {

                int rgb = image.getImage().getRGB(column, line);
                Color color = new Color(rgb);
                int red = color.getRed() * valorMtt;
                int green = color.getGreen() * valorMtt;
                int blue = color.getBlue() * valorMtt;

                if (red > 255) {
                    red = 255;
                }
                if (green > 255) {
                    green = 255;
                }
                if (blue > 255) {
                    blue = 255;
                }

                if (red < 0)
                    red = 0;
                if (green < 0)
                    green = 0;
                if (blue < 0)
                    blue = 0;

                Color vermelhoApenas = new Color(red, green, blue);
                newImage.setRGB(column, line, vermelhoApenas.getRGB());

            }
        }

        PrintImage.showImage(newImage);
    }

    public static void brilhoAddYiq(double[][][] imgYiq, Integer valorAdd) {
        int largura = imgYiq.length;
        int altura = imgYiq[0].length;

        BufferedImage newImage = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int linha = 0; linha < largura; linha++) {
            for (int coluna = 0; coluna < altura; coluna++) {


                int red = (int) (valorAdd + (imgYiq[linha][coluna][0] + 0.956 * imgYiq[linha][coluna][1] + 0.621 * imgYiq[linha][coluna][2]));
                int green = (int) (valorAdd + (imgYiq[linha][coluna][0] - 0.272 * imgYiq[linha][coluna][1] - 0.647 * imgYiq[linha][coluna][2]));
                int blue = (int) (valorAdd + (imgYiq[linha][coluna][0] - 1.106 * imgYiq[linha][coluna][1] + 1.703 * imgYiq[linha][coluna][2]));

                if (red > 255) {
                    red = 255;
                }
                if (blue > 255) {
                    blue = 255;
                }
                if (green > 255) {
                    green = 255;
                }

                if (red < 0)
                    red = 0;
                if (green < 0)
                    green = 0;
                if (blue < 0)
                    blue = 0;

                Color novaColor = new Color(red, green, blue);
                newImage.setRGB(linha, coluna, novaColor.getRGB());

            }
        }

        PrintImage.showImage(newImage);
    }

    public static void brilhoMttYiq(double[][][] imgYiq, Integer valorMtt) {
        int largura = imgYiq.length;
        int altura = imgYiq[0].length;

        BufferedImage newImage = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int linha = 0; linha < largura; linha++) {
            for (int coluna = 0; coluna < altura; coluna++) {


                int red = (int) (valorMtt * (imgYiq[linha][coluna][0] + 0.956 * imgYiq[linha][coluna][1] + 0.621 * imgYiq[linha][coluna][2]));
                int green = (int) (valorMtt * (imgYiq[linha][coluna][0] - 0.272 * imgYiq[linha][coluna][1] - 0.647 * imgYiq[linha][coluna][2]));
                int blue = (int) (valorMtt * (imgYiq[linha][coluna][0] - 1.106 * imgYiq[linha][coluna][1] + 1.703 * imgYiq[linha][coluna][2]));

                if (red > 255) {
                    red = 255;
                }
                if (blue > 255) {
                    blue = 255;
                }
                if (green > 255) {
                    green = 255;
                }

                if (red < 0)
                    red = 0;
                if (green < 0)
                    green = 0;
                if (blue < 0)
                    blue = 0;

                Color novaColor = new Color(red, green, blue);
                newImage.setRGB(linha, coluna, novaColor.getRGB());

            }
        }

        PrintImage.showImage(newImage);
    }



}
