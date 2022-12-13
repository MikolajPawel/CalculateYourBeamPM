package com;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class MenuBarWithCustomBgColor extends JMenuBar {
    Color bgColor = new ColorUIResource(33,33,33);

    public void setBackgroundColor(Color color) {
        bgColor=color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(bgColor);
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

}
