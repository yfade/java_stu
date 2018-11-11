package com.java.io;

import org.junit.Test;

import java.io.*;

/**
 * Created by pc on 2018/8/25.
 */
public class IOTest {
    @Test
    public void test1(){
        File file=new File("resource/io.txt");
        System.out.println(file.getName());//获取文件名
        System.out.println(file.getParent());//文件的父文件夹
        File f1=new File("resource");
        System.out.println(f1.list());//返回string数组，文件名字
        System.out.println(f1.listFiles());//以file数组返回，f1.listFiles()[0].getName()同f1.list()[0]
        System.out.println(file.exists());
        File file1=new File("resourceww");
        if (!file1.exists()){
            System.out.println("create-------");
            file1.mkdir();
        }
        System.out.println(file.renameTo(new File("resourceww/io.txt")));//重命名，后面的resourceww文件夹必须存在，文件可以不存在
        System.out.println(file.getPath());///相对路径
        System.out.println(file.getAbsoluteFile());//绝对路径
        System.out.println(file.getAbsolutePath());//绝对路径
    }
    @Test
    public void testss(){
        File file=new File("io.txt");
        System.out.println(file.exists());
    }

    @Test
    public void testIO(){
        File file=new File("resource/io.txt");
        File file2=new File("F:/fileresource");
        if (!file2.exists())
            file2.mkdirs();
        File file1=new File("F:/fileresource/io.txt");
        BufferedReader bis=null;
        BufferedWriter bos=null;
        try {
            FileInputStream fis=new FileInputStream(file);
            InputStreamReader isr=new InputStreamReader(fis,"utf-8");
            FileOutputStream fos=new FileOutputStream(file1);
            OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
            bis =new BufferedReader(isr);
            bos=new BufferedWriter(osw);
            char[] b=new char[3];
            int len=0;
            while ((len=bis.read(b))!=-1){
                bos.write(b,0,len);
                bos.flush();
            }
            String str="\r\n中国人";
            char[] bytes=str.toCharArray();
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bis!=null)
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bos!=null)
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
