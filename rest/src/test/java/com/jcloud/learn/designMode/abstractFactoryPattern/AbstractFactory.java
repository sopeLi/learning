package com.jcloud.learn.designMode.abstractFactoryPattern;

import com.jcloud.learn.designMode.base.Color;
import com.jcloud.learn.designMode.base.Shape;

/**
 * Created by lixin32 on 2018/8/13.
 */
public abstract class  AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
