package com.jcloud.learn.interview;

import java.io.File;

/**
 * @author lixin
 * @description: 删除文件夹下的所有文件
 * 当是文件夹且当中有文件时，需要遍历删除文件后再删除文件夹，不然删不掉
 * @date Create in 18:25 2022/1/6
 */
public class DeleteFile {
    public static void main(String[] args) {
        File file = new File("E:/test");//路径
        file.delete();
        System.out.println("test");
//        deleteFile(file);
    }

    private static void deleteFile(File file) {
        //判断是否为文件，是，则删除
        if (file.isFile()) {
            System.out.println(file.getAbsoluteFile());//打印路径
            file.delete();
        } else {//不为文件，则为文件夹
            String[] childFilePath = file.list();//获取文件夹下所有文件相对路径
            for (String path : childFilePath) {
                File childFile = new File(file.getAbsoluteFile() + "/" + path);
                deleteFile(childFile);//递归，对每个都进行判断
            }
            System.out.println(file.getAbsoluteFile());
            file.delete();
        }
    }
}
