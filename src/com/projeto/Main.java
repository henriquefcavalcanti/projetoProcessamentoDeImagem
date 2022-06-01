package com.projeto;

import com.projeto.filters.Filtro;
import com.projeto.filters.GrayScale;
import com.projeto.filters.SeparateChannels;
import com.projeto.model.Image;

import java.io.IOException;
import java.util.Scanner;

public class Main {

//    C:/Users/henri/Pictures/f1Donuts.jpg
//    C:/Users/henri/Pictures/f12022drivers.jpg
//    C:/Users/henri/Pictures/senna.jpg
//    C:\Users\henri\Pictures\sennaBandeira2.jpg
    // D:\Faculdade\P5\processamentoDeImagem\lenaOG.png
// D:\Faculdade\P5\processamentoDeImagem\lena.png
// D:\Faculdade\P5\processamentoDeImagem\barbara.png

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o caminho da imagem que vc deseja manipular:");
        String imagePath = scanner.nextLine();

        Image image = new Image(imagePath);

        double[] gauss3x3 = {0.0625, 0.125, 0.0625, 0.125, 0.25, 0.125, 0.0625, 0.125, 0.0625};

        double[] horizontal = {-1, -2, -1, 0, 0, 0, 1, 2, 1};

        boolean repetirMenu = true;
        while (repetirMenu) {

            printMenu();
            String escolhaMenu = scanner.nextLine();
            System.out.println(escolhaMenu);

            switch (escolhaMenu) {
                case "1":
                    System.out.println("Digite a banda que você deseja alterar (1 - Red; 2 - Green; 3 - Blue): ");
                    int banda = Integer.parseInt(scanner.nextLine());
                    System.out.print("Digite o aumento que você deseja: ");
                    int aumento = Integer.parseInt(scanner.nextLine());
                    SeparateChannels.aumentoDeTonalidade(image, banda, aumento);
                    break;
                case "2":
                    GrayScale.grayScaleBanda(image, 1);
                    break;
                case "3":
                    GrayScale.grayScaleBanda(image, 2);
                    break;
                case "4":
                    GrayScale.grayScaleBanda(image, 3);
                    break;
                case "5":
                    GrayScale.grayScaleMedia(image);
                    break;
                case "6":
                    Filtro.negativo(image);
                    break;
                case "7":
                    System.out.println("Digite o limiar: ");
                    int limiar = Integer.parseInt(scanner.nextLine());
                    Filtro.limiarizacao(image, limiar);
                    break;
                case "8":
                    double[][][] yiq = Filtro.convertRgbtoYiq(image);
                    break;
                case "9":
                    double[][][] yiq2 = Filtro.convertRgbtoYiq(image);
                    Filtro.convertYiqToRgb(yiq2);
                    break;
                case "10":
                    System.out.println("Digite o valor que você deseja adicionar: ");
                    int valorAdd = Integer.parseInt(scanner.nextLine());
                    Filtro.brilhoAddRGB(image, valorAdd);
                    break;
                case "11":
                    System.out.println("Digite o valor que você deseja multiplicar: ");
                    int varlorMtt = Integer.parseInt(scanner.nextLine());
                    Filtro.brilhoMttRGB(image, varlorMtt);
                    break;
                case "12":
                    System.out.println("Digite o valor que você deseja adicionar: ");
                    int valorAddYIQ = Integer.parseInt(scanner.nextLine());
                    double[][][] yiqAdd = Filtro.convertRgbtoYiq(image);
                    Filtro.brilhoAddYiq(yiqAdd, valorAddYIQ);
                    break;
                case "13":
                    System.out.println("Digite o valor que você deseja multiplicar: ");
                    int varlorMttYIQ = Integer.parseInt(scanner.nextLine());
                    double[][][] yiqMtt = Filtro.convertRgbtoYiq(image);
                    Filtro.brilhoMttYiq(yiqMtt, varlorMttYIQ);
                    break;
                case "14":
                    double[][][] yiqNeg = Filtro.convertRgbtoYiq(image);
                    Filtro.negativoYIQ(yiqNeg);
                    break;
                case "15":
                    Filtro.mediana(image);
                    break;
                case "16":
                    Filtro.media(image);
                    break;
                case "17":
                    Filtro.convolucao(image, gauss3x3);
                    break;
                case "0":
                    repetirMenu = false;
                    break;
            }

        }

        scanner.close();
    }

    public static void printMenu() {

        System.out.println("\n\n\n\n");
        System.out.println("---------------- MENU ----------------");
        System.out.println("1 - Aumento de tonalidade");
        System.out.println("2 - Cinza R");
        System.out.println("3 - Cinza G");
        System.out.println("4 - Cinza B");
        System.out.println("5 - Cinza Média");
        System.out.println("6 - Negativo");
        System.out.println("7 - Limiarização");
        System.out.println("8 - RGB -> YIQ");
        System.out.println("9 - YIQ -> RGB");
        System.out.println("10 - Brilho aditivo em RGB");
        System.out.println("11 - Brilho mutiplicativo em RGB");
        System.out.println("12 - Brilho aditivo em YIQ");
        System.out.println("13 - Brilho mutiplicativo em YIQ");
        System.out.println("14 - Negativo em Y");
        System.out.println("15 - Mediana");
        System.out.println("16 - Media");
        System.out.println("17 - Convolução");
        System.out.println("0 - Finalizar programa");
        System.out.print("Escolha um item do menu: ");

    }

}
