package com.juyong.prototype;

import jdk.jfr.Description;

import java.io.*;

/**
 * @Description: TODO
 * @Author: juyong
 * @Date: 2019/12/21 00:11
 */
public class DeepPrototype implements Serializable,Cloneable {

    private String name ;
    private DeepClone deepClone ;

    public DeepPrototype() {
        super();
    }

    public DeepPrototype(String name, DeepClone deepClone) {
        this.name = name;
        this.deepClone = deepClone;
    }
    

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //使用clone进行深拷贝
        Object deep = null ;
        //先对简单类型和String克隆
        deep = super.clone() ;
        //对引用类型的属性，进行单独处理
        DeepPrototype deepPrototype = (DeepPrototype)deep ;
        deepPrototype.deepClone = (DeepClone)deepClone.clone() ;

        return deep;
    }

    /*
     * @Author: juyong
     * @Description: 使用序列化实现对象的深拷贝
     * @Date: 0:23 2019/12/21
     * @Param: []
     * @return: java.lang.Object
     **/
    public Object deepClone(){
        //创建流对象
        ByteArrayOutputStream bos = null ;
        ObjectOutputStream oos = null ;
        ByteArrayInputStream bis = null ;
        ObjectInputStream ois = null ;

        try {
            bos = new ByteArrayOutputStream() ;
            oos = new ObjectOutputStream(bos) ;
            //当前这个对象以对象流的方式输出
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray()) ;
            ois = new ObjectInputStream(bis) ;
            //深拷贝的对象

            DeepPrototype prototype = (DeepPrototype) ois.readObject() ;
            return prototype ;
        } catch (Exception e) {
            e.printStackTrace();
            return null ;
        } finally {
            try {
                if(bos != null) { bos.close();}
                if(oos != null){ oos.close();}
                if(bis != null){ bis.close();}
                if(ois != null){ ois.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeepClone getDeepClone() {
        return deepClone;
    }

    public void setDeepClone(DeepClone deepClone) {
        this.deepClone = deepClone;
    }

    public void close(){}

    @Override
    public String toString() {
        return "DeepPrototype{" +
                "name='" + name + '\'' +
                ", deepClone=" + deepClone +
                '}';
    }
}
