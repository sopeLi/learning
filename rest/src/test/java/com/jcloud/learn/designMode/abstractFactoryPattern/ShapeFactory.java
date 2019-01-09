package com.jcloud.learn.designMode.abstractFactoryPattern;

import com.jcloud.learn.designMode.base.Circle;
import com.jcloud.learn.designMode.base.Color;
import com.jcloud.learn.designMode.base.Rectangle;
import com.jcloud.learn.designMode.base.Shape;

/**
 * Created by lixin32 on 2018/8/13.
 */
public class ShapeFactory extends AbstractFactory {

    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}