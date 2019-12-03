package com.ljaer.designpatterns.proxy.myjdk;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//用来生成源代码的工具类
public class ZkProxy {

    public static final String ln = "\r\n";

    public static Object newProxyInstance(ZkClassLoader classLoader, Class<?>[] interfaces,
                                          ZkInvocationHandler h) {

        try {
            //动态生成源代码 .java 文件
            String src = generateSrc(interfaces);

            //Java 文件输出磁盘
            String filePath = ZkProxy.class.getResource("").getPath();
            //String filePath = "E:/workspace/ideaworkspace/java-design-pattern-lean/out/production/java-design-pattern-lean/com/ljaer/designpatterns/proxy/myjdk/";
            File f = new File(filePath + "$Proxy0.java");
            if(!f.exists()){
                //先得到文件的上级目录，并创建上级目录，在创建文件
                boolean mkdirResult = f.getParentFile().mkdir();
                try {
                    //创建文件
                    boolean createNewFileResult = f.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

            //把生成的 .java 文件编译成 .class 文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manage.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null,manage,null,null,null,iterable);
            task.call();
            manage.close();

            //把编译生成的 .class 文件加载到 JVM 中
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(ZkInvocationHandler.class);
            f.delete();

            //返回字节码重组以后的新的代理对象
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        sb.append("package com.ljaer.designpatterns.proxy.myjdk;" + ln);
        sb.append("import com.ljaer.designpatterns.proxy.jdk.Person;" + ln);
        sb.append("import java.lang.reflect.*;"+ln);
        sb.append("public class $Proxy0 implements ");
        for (int i = 0; i < interfaces.length; i++) {
            sb.append(interfaces[i].getName());
        }
        sb.append("{" + ln);
            sb.append("ZkInvocationHandler h;"+ln);
            sb.append("public $Proxy0(ZkInvocationHandler h){ "+ln);
                sb.append("this.h = h;" + ln);
            sb.append("}"+ln);

        for (int i = 0; i < interfaces.length; i++) {
            for (Method m : interfaces[i].getMethods()) {
                sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);
                sb.append("try{" + ln);
                sb.append("Method m = " + interfaces[i].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
                sb.append("this.h.invoke(this,m,null);" + ln);
                sb.append("}catch(Throwable e){e.printStackTrace();}" + ln);
                sb.append("}" + ln);
            }
        }

        sb.append("}"+ln);
        return sb.toString();
    }

    private static Map<Class,Class> mappings = new HashMap<Class,Class>();
    static{
        mappings.put(int.class,Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "return 0;";
        }else if(returnClass == void.class){
            return "";
        }else {
            return "return null;";
        }
    }

/*    private static String getCaseCode(String code,Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "((" + mappings.get(returnClass).getName() + ")" + code + ")."
                    + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static boolean hasReturnValue(Class<?> clazz){
        return clazz != void.class;
    }*/

    private static String toLowerFirstCase(String src){
        char[] chars = src.toCharArray();
        chars[0] +=32;
        return String.valueOf(chars);
    }
}
