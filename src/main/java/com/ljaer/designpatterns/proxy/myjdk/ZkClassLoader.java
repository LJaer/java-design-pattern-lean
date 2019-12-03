package com.ljaer.designpatterns.proxy.myjdk;

import java.io.*;

public class ZkClassLoader extends ClassLoader {

    private File classPathFile;

    public ZkClassLoader(){
        String classPath = ZkClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    protected Class<?> findClass(String name){
       String className = ZkClassLoader.class.getPackage().getName()+"."+name;

       if(classPathFile!=null){
           File classFile = new File(classPathFile,name.replaceAll("\\.","/")+".class");
           if(classFile.exists()){
               FileInputStream in = null;
               ByteArrayOutputStream out = null;

               try {
                   in = new FileInputStream(classFile);
                   out = new ByteArrayOutputStream();
                   byte[] buff = new byte[1024];

                   int len;
                   while((len = in.read(buff))!=-1){
                       out.write(buff,0,len);
                   }

                   return defineClass(className,out.toByteArray(),0,out.size());
               } catch (IOException e) {
                   e.printStackTrace();
               } finally {
                   if(null != in){
                       try {
                           in.close();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }

                   if(null != out){
                       try {
                           out.close();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
               }
           }
       }

       return null;
    }

}
