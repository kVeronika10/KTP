package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class JImageDisplay extends JComponent {
    private BufferedImage image;

  
    public JImageDisplay(int x, int y)
    {
        image = new BufferedImage(x,y,TYPE_INT_RGB); 
        setPreferredSize(new Dimension(x, y));
    }
   
    public void paintComponent (Graphics g)
    {
        g.drawImage (image, 0, 0, image.getWidth(), image.getHeight(), null);
    }
   
    public void clearImage ()
    {
        for (int x = 0; x < image.getWidth(); x++)
        {
            for (int y = 0; y < image.getHeight(); y++)
            {
                image.setRGB(x, y, 0);
            }
        }
    }
   
    public void drawPixel (int x, int y, int rgbColor)
    {
        image.setRGB(x, y, rgbColor);
    }
}
