package com.jx.common;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CheckCodeUtils {

    private static final String CODES = "abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ012345689";
    private static final int LENGTH = 5;
    private static final int IMAGE_WIDTH = 80;
    private static final int IMAGE_HEIGHT = 30;

    private static final int LINE_COUNT = 5;

    public static String randomCode(int codeLength) {
        char[] charArray = CODES.toCharArray();
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < codeLength; i++) {
            sb.append(charArray[random.nextInt(CODES.length())]);
        }
        return sb.toString();
    }

    public static String randomCode() {
        return randomCode(LENGTH);
    }

    public static BufferedImage generateImage(String code) {
        BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.yellow);
        graphics.fillRect(0, 0 , IMAGE_WIDTH, IMAGE_HEIGHT);
        graphics.setColor(Color.blue);
        graphics.setFont(new Font("宋体", Font.ITALIC, 20));
        graphics.drawString(code, 10, 18);
        for (int i = 0; i < LINE_COUNT; i++) {
            Point pStart = generatePoint();
            Point pEnd = generatePoint();
            graphics.setColor(randomColor());
            graphics.drawLine((int) pStart.getX(), (int) pStart.getY(), (int) pEnd.getX(), (int) pEnd.getY());
        }
        return image;
    }

    private static Color randomColor() {
        Random random = new Random();
        return new Color(128 + random.nextInt(128), 128 + random.nextInt(128), 128 + random.nextInt(128));
    }

    private static Point generatePoint() {
        Random random = new Random();
        Point p = new Point();
        p.setLocation(random.nextInt(IMAGE_WIDTH), random.nextInt(IMAGE_HEIGHT));
        return p;
    }
}
