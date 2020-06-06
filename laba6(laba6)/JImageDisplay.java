package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class JImageDisplay extends JComponent
{
    private BufferedImage img;
    public BufferedImage getImage()
    {
        return img;
    }
    public JImageDisplay(int x, int y)
    {
        img = new BufferedImage(x,y,TYPE_INT_RGB);
        setPreferredSize(new Dimension(x, y));
    }
    public void paintComponent (Graphics g)

    {
        super.paintComponent (g);
        g.drawImage (img, 0, 0, img.getWidth(), img.getHeight(), null);
    }
    public void drawPixel (int x, int y, int rgbColor)
    {
        img.setRGB(x, y, rgbColor);
    }
}
