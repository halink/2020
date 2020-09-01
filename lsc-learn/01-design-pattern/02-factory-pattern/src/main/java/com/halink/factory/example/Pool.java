package com.halink.factory.example;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class Pool {
    /**
     * 实例
     */
    private static Pool instance = null;
    /**
     * 配置文件
     */
    public String propertiesName = "connection-INF.properties";
    /**
     * 最大连接数
     */
    protected int maxConnect = 100;
    /**
     * 正常连接数
     */
    protected int normalConnect = 10;
    /**
     * 驱动名
     */
    protected String driverName = null;
    /**
     * 驱动
     */
    protected Driver driver = null;

    protected Pool() {
        try {
            init();
            loadDrivers(driverName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized Pool getInstance() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        if (instance == null) {
            instance = (Pool) Class.forName("org.e_book.sqlhelp.Pool").newInstance();
            instance.init();
        }
        return instance;
    }

    private void init() throws IOException {
        InputStream is = Pool.class.getResourceAsStream(propertiesName);
        Properties p = new Properties();
        p.load(is);
        this.driverName = p.getProperty("driverName");
        this.maxConnect = Integer.parseInt(p.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(p.getProperty("normalConnect"));
    }

    protected void loadDrivers(String dri) {
        try {
            driver = (Driver) Class.forName(dri).newInstance();
            DriverManager.registerDriver(driver);
            System.out.println("成功注册 JDBC 驱动程序" + dri);
        } catch (Exception e) {
            System.out.println("无法注册 JDBC 驱动程序:" + dri + ",错误:" + e);
        }
    }

    public abstract void createPool();

    public abstract Connection getConnection();

    public abstract Connection getConnection(long time);

    public abstract void freeConnection(Connection con);

    public abstract int getnum();

    public abstract int getnumActive();

    protected synchronized void release() {
        try {
            DriverManager.deregisterDriver(driver);
            System.out.println("撤销 JDBC 驱动程序 " + driver.getClass().getName());
        } catch (SQLException e) {
            System.out.println("无法撤销 JDBC 驱动程序的注册:" + driver.getClass().getName());
        }
    }
}