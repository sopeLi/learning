package com.jcloud.learn.test.designMode.factoryPattern;

import com.jcloud.learn.test.designMode.base.Rectangle;
import org.junit.Test;

/**
 * Created by lixin32 on 2018/8/10.
 * http://www.runoob.com/design-pattern/factory-pattern.html
 */

public class ShapeFactoryDemo {

    public static <T> T getClass(Class<? extends T> clazz) {
        T obj = null;
        try {
            obj = (T) Class.forName(clazz.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;
    }

    @Test
    public void ShapeFactoryTest(){
       ShapeFactoryDemo.getClass(Rectangle.class).draw();
    }
}
