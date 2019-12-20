package com.juyong.prototype;

import java.io.Serializable;

/**
 * @Description: 测试深拷贝
 * @Author: juyong
 * @Date: 2019/12/21 00:04
 */
public class DeepClone implements Serializable,Cloneable {

    private String cloneName ;
    private String cloneClass ;

    public DeepClone(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "DeepClone{" +
                "cloneName='" + cloneName + '\'' +
                ", cloneClass='" + cloneClass + '\'' +
                '}';
    }

    public String getCloneName() {
        return cloneName;
    }

    public void setCloneName(String cloneName) {
        this.cloneName = cloneName;
    }

    public String getCloneClass() {
        return cloneClass;
    }

    public void setCloneClass(String cloneClass) {
        this.cloneClass = cloneClass;
    }
}
