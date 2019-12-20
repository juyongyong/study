package com.juyong.principle;

/**
 * @Description: 开闭原则
 * @Author: juyong
 * @Date: 2019/12/18 13:38
 */
public class Client {
    public static void main(String[] args) {
        DrawImage drawImage = new DrawImage() ;
        Shape rectangle = new Rectangle() ;
        Shape triangle = new Triangle() ;
        Shape circle = new Circle() ;
        Shape other = new Other() ;

        drawImage.draw(rectangle);
        drawImage.draw(triangle);
        drawImage.draw(circle);
        drawImage.draw(other);




    }
}
