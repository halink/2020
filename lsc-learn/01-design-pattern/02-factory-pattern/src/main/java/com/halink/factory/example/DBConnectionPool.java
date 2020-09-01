package com.halink.factory.example;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public class DBConnectionPool extends Pool {
    private static int num = 0;
    private static int numActive = 0;
    private static DBConnectionPool pool = null;
    private int checkedOut;
    private Vector<Connection> freeConnections = new Vector<Connection>();
    private String passWord = null;
    private String url = null;
    private String userName = null;

    private DBConnectionPool() {
        try {
            init();
            for (int i = 0; i < normalConnect; i++) {
                Connection c = newConnection();
                if (c != null) {
                    freeConnections.addElement(c);
                    num++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized DBConnectionPool getInstance() {
        if (pool == null) {
            pool = new DBConnectionPool();
        }
        return pool;
    }

    private void init() throws IOException {
        InputStream is = DBConnectionPool.class.getResourceAsStream(propertiesName);
        Properties p = new Properties();
        p.load(is);
        this.userName = p.getProperty("userName");
        this.passWord = p.getProperty("passWord");
        this.driverName = p.getProperty("driverName");
        this.url = p.getProperty("url");
        this.driverName = p.getProperty("driverName");
        this.maxConnect = Integer.parseInt(p.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(p.getProperty("normalConnect"));
    }

    @Override
    public synchronized void freeConnection(Connection con) {
        freeConnections.addElement(con);
        num++;
        checkedOut--;
        numActive--;
        notifyAll();
    }

    private Connection newConnection() {
        Connection con = null;
        try {
            if (userName == null) {
                con = DriverManager.getConnection(url);
            } else {
                con = DriverManager.getConnection(url, userName, passWord);
            }
            System.out.println("连接池创建一个新的连接");
        } catch (SQLException e) {
            System.out.println("无法创建这个 URL 的连接" + url);
            return null;
        }
        return con;
    }

    @Override
    public int getnum() {
        return num;
    }

    @Override
    public int getnumActive() {
        return numActive;
    }

    @Override
    public synchronized Connection getConnection() {
        Connection con = null;
        if (freeConnections.size() > 0) {
            num--;
            con = (Connection) freeConnections.firstElement();
            freeConnections.removeElementAt(0);
            try {
                if (con.isClosed()) {
                    System.out.println("从连接池删除一个无效连接");
                    con = getConnection();
                }
            } catch (SQLException e) {
                System.out.println("从连接池删除一个无效连接");
                con = getConnection();
            }
        } else if (maxConnect == 0 || checkedOut < maxConnect) {
            con = newConnection();
        }
        if (con != null) {
            checkedOut++;
        }
        numActive++;
        return con;
    }

    @Override
    public synchronized Connection getConnection(long timeout) {
        long startTime = System.currentTimeMillis();
        Connection con;
        while ((con = getConnection()) == null) {
            try {
                wait(timeout);
            } catch (InterruptedException e) {
            }
            if ((System.currentTimeMillis() - startTime) >= timeout) {
                return null;
            }
        }
        return con;
    }

    @Override
    public synchronized void release() {
        try {
            Enumeration allConnections = freeConnections.elements();
            while (allConnections.hasMoreElements()) {
                Connection con = (Connection) allConnections.nextElement();
                try {
                    con.close();
                    num--;
                } catch (SQLException e) {
                    System.out.println("无法关闭连接池中的连接");
                }
            }
            freeConnections.removeAllElements();
            numActive = 0;
        } finally {
            super.release();
        }
    }

    @Override
    public void createPool() {
        pool = new DBConnectionPool();
        if (pool != null) {
            System.out.println("创建连接池成功");
        } else {
            System.out.println("创建连接池失败");
        }
    }
}
