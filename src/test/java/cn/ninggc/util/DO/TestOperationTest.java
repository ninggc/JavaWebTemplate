package cn.ninggc.util.DO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestOperationTest {
    TestOperation to = new TestOperation();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        cn.ninggc.util.DAO.Test t = new cn.ninggc.util.DAO.Test();
        System.out.println(to.insert(t));
    }

    @Test
    public void selectById() throws Exception {
        System.out.println(to.selectById(1).toJson());
    }

    @Test
    public void selectAll() throws Exception {
    }

}