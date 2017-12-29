package cn.ninggc.util.DO;

import cn.ninggc.util.DAO.Test;
import cn.ninggc.util.DO.util.BaseOperation;
import cn.ninggc.util.DO.util.OperationHandler;
import cn.ninggc.util.DO.util.WithSession;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TestOperation extends BaseOperation<Test> {
    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Test selectById(int id) {
        return handler.query(new WithSession<Test>() {
            @Override
            public Test onQuery(Session session) throws Exception {
                String hql = "from test where test.id = :id";
                Query<Test> query = session.createQuery(hql, Test.class);
                query.setParameter("id", id);
                return query.uniqueResult();
            }
        });
    }

    @Override
    public List<Test> selectAll() {
        return null;
    }
}
