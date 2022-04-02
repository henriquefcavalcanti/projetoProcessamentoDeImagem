package com.projeto;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class PrintImage {

    public static void showImage(BufferedImage image) {
        var frame = new JFrame();
        var icon = new ImageIcon(image);
        var label = new JLabel(icon);
        frame.add(label);
        frame.pack();
        frame.setVisible(true);
    }


}
