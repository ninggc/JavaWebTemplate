package cn.ninggc.util.bean;

import cn.ninggc.util.util.IGson;

public abstract class BaseBean implements IGson {
    public String toJson()  {
        return gson.toJson(this);
    }
}
