package cn.ninggc.util.DO.util;

import org.hibernate.Session;

/**
 * 通过接口提供的session进行自定义操作
 * @param <T> 自定义返回值
 */
public interface WithSession<T> {
    public T onQuery(Session session) throws Exception;
}
