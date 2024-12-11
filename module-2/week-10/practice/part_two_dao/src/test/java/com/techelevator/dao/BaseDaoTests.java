package com.techelevator.dao;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestingDatabaseConfig.class)
public abstract class BaseDaoTests {

    @Autowired
    protected DataSource dataSource;

    @Autowired
    protected DataSource invalidDataSource;

    protected String didNotThrowAnyException(String methodName) {
        return methodName + " did not throw exception if unable to reach database";
    }

    protected String didNotThrowDaoException(String methodName) {
        return methodName + " threw an exception, but it should throw DaoException if unable to reach database";
    }

    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }

}
