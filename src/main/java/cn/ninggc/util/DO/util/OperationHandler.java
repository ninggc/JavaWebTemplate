package cn.ninggc.util.DO.util;

import cn.ninggc.util.util.MySessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by ning on 2017/7/4.
 * 抽象画的描述了对数据库的增删改查操作
 * 通过DoInDo接口实现用户自定义操作
 */
public class OperationHandler {

    private Session session;
    private Transaction transaction;

//    public boolean insert(WithSession<Boolean> withSession) {
//        return query(withSession);
//    }
//
//    public boolean delete(int id, DoInDO<Integer, Boolean> doInDO) {
//        boolean flag = false;
//        try {
//            session = MySessionUtil.getSession();
//            transaction = session.beginTransaction();
//            flag = doInDO.dosomething(session, id);
//            transaction.commit();
//        } catch (Exception e) {
//            flag = false;
//            System.out.println(e.getMessage());
//            transaction.rollback();
//        } finally {
//            if (session != null && session.isConnected()) {
//                session.close();
//            }
//        }
//        return flag;
//    }
//
//    public boolean update(T t, DoInDO<T, Boolean> doInDO) {
//        boolean flag = false;
//        try {
//            session = MySessionUtil.getSession();
//            transaction = session.beginTransaction();
//            flag = doInDO.dosomething(session, t);
//            transaction.commit();
//        } catch (Exception e) {
//            flag = false;
//            System.out.println(e.getMessage());
//            transaction.rollback();
//        } finally {
//            if (session != null && session.isConnected()) {
//                session.close();
//            }
//        }
//        return flag;
//    }
//
//    public T selectById(int id, DoInDO<Integer, T> doInDO) {
//        return query(new WithSession<T>() {
//            @Override
//            public T onQuery(Session session) throws Exception {
//                return doInDO.dosomething(session, id);
//            }
//        });
////        T t = null;
////        try {
////            session = MySessionUtil.getSession();
////            transaction = session.beginTransaction();
////            t = doInDO.dosomething(session, id);
////            transaction.commit();
////        } catch (Exception e) {
////            t = null;
////            e.printStackTrace();
////            transaction.rollback();
////        } finally {
////            if (session != null && session.isConnected()) {
////                session.close();
////            }
////        }
////        return t;
//    }
//
//    public T selectBy(String key, DoInDO<String, T> doInDO) {
//        T t = null;
//        try {
//            session = MySessionUtil.getSession();
//            transaction = session.beginTransaction();
//            t = doInDO.dosomething(session, key);
//            transaction.commit();
//        } catch (Exception e) {
//            t = null;
//            System.out.println(e);
//            transaction.rollback();
//        } finally {
//            if (session != null && session.isConnected()) {
//                session.close();
//            }
//        }
//        return t;
//    }
//
//    public List<T> selectListBy(String key, DoInDO<String, List<T>> doInDO) {
//        return query(new WithSession<List<T>>() {
//            @Override
//            public List<T> onQuery(Session session) throws Exception {
//                return doInDO.dosomething(session, key);
//            }
//        });
//
//    }
//
//    public List<T> selectAll(DoInDO<T, List<T>> doInDO) {
//        return query(new WithSession<List<T>>() {
//            @Override
//            public List<T> onQuery(Session session) {
//                return doInDO.dosomething(session, null);
//            }
//        });
//  }

    /**
     * 获取session后自定义操作吧
     * @param withSession 提供了session的接口
     * @param <R> 返回值
     * @return 接口中的泛型就是返回值
     */
    public <R> R query(WithSession<R> withSession) {
        R r = null;
        try {
            session = MySessionUtil.getSession();
            transaction = session.beginTransaction();
            r = withSession.onQuery(session);
            transaction.commit();
        } catch (Exception e) {
            r = null;
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null && session.isConnected()) {
                session.close();
            }
        }
        return r;
    }
}
