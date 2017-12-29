package cn.ninggc.util.DO.util;

import org.hibernate.Session;

import java.util.List;

/**
 * Created by ning on 2017/7/3.
 * 增删改查操作的抽象实现
 * 部分实现可通用，已给出，未给出的可通过调用handler的query实现
 */
public abstract class BaseOperation<T> {
    protected OperationHandler handler = new OperationHandler();

    /**
     * @return true|false
     */
    public boolean insert(T t) {
        return handler.query(new WithSession<Boolean>() {
            @Override
            public Boolean onQuery(Session session) throws Exception {
                session.save(t);
                return true;
            }
        });
    }

    /**
     *
     * @return true|false
     */
    public abstract boolean delete(int id);

    /**
     * 匹配相同id项进行更新数据
     * @return true|false
     */
    public boolean update(T t) {
        return handler.query(new WithSession<Boolean>() {
            @Override
            public Boolean onQuery(Session session) throws Exception {
                session.update(t);
                return true;
            }
        });
    };

    /**
     *
     * @return T|null
     */
    public abstract T selectById(int id);

    /**
     *
     * @return List|null
     */
    public abstract List<T> selectAll();
}
