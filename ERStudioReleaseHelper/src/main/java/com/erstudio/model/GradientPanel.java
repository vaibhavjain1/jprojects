package main.java.com.erstudio.model;

/**
 * @author akshit.arora
 * for the Gradient Panel
 */
import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int width = getWidth();
        int height = getHeight();
        Color upperGradientColor = new Color(204, 255, 255);
        Color downwardGradientColor = Color.WHITE;
        GradientPaint gradientPaint = new GradientPaint(0, 0, upperGradientColor, 0, height, downwardGradientColor);
        graphics2D.setPaint(gradientPaint);
        graphics2D.fillRect(0, 0, width, height);
    }
}
