package com.projeto.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    BufferedImage image;
    int imageWidth;
    int imageHeigth;

    public Image() {
    }

    public Image(String imagePath) throws IOException {
        File file = new File(imagePath);
        this.image = ImageIO.read(file);
        this.imageWidth = this.image.getWidth();
        this.imageHeigth = this.image.getHeight();
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public int getImageHeigth() {
        return imageHeigth;
    }
}
