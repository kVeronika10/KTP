package com.company;
import com.company.FractalGenerator;
import com.company.JImageDisplay;
import com.company.Mandelbrot;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;
import javax.swing.JFileChooser.*;
import javax.swing.filechooser.*;
import javax.imageio.ImageIO.*;
import java.awt.image.*;

public class FractalExplorer
{
    private int display_size;

    private JImageDisplay display; 

    private FractalGenerator fractal; 

    private Rectangle2D.Double range;

    public FractalExplorer(int size)  {
        display_size = size;
        fractal = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractal.getInitialRange(range);
        display = new JImageDisplay(display_size, display_size);
    }


    
    public void createAndShowGUI() {
        display.setLayout(new BorderLayout());
        JFrame frame = new JFrame("Fractal Explorer");
        frame.add(display, BorderLayout.CENTER);

        // кнопка сброса изображения
        JButton resetButton = new JButton("Reset");
        frame.add(resetButton, BorderLayout.SOUTH);
        ButtonHandler resetHandler = new ButtonHandler();
        resetButton.addActionListener(resetHandler);

        MouseHandler click = new MouseHandler();
        display.addMouseListener(click);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false); 
    }

  
    private void drawFractal() {
        for (int x = 0; x < display_size; x++) {
            for (int y = 0; y < display_size; y++) {
                double xCoord = FractalGenerator.getCoord(range.x,
                        range.x + range.width, display_size, x);
                double yCoord = FractalGenerator.getCoord(range.y,
                        range.y + range.height, display_size, y);

                int num_iters = fractal.numIterations(xCoord, yCoord);

                if (num_iters == -1) {
                    display.drawPixel(x, y, 0);
                } else {
                    float hue = 0.7f + (float) num_iters / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);

                    display.drawPixel(x, y, rgbColor);
                }
            }
        }
        display.repaint(); 
    }

    
    public class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Reset")) 
            {
                fractal.getInitialRange(range);
                drawFractal();
            }
        }
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            double xCoord = fractal.getCoord(range.x,
                    range.x + range.width, display_size, x);

            int y = e.getY();
            double yCoord = fractal.getCoord(range.y,
                    range.y + range.height, display_size, y);


            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

            drawFractal();
        }
    }



        public static void main(String[] args) {
            FractalExplorer displayExplorer = new FractalExplorer(800);
            displayExplorer.createAndShowGUI();
            displayExplorer.drawFractal();
        }
}




