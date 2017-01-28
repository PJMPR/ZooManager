/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.mappers.ZwierzeMapper;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TKK
 */
public class RepositoryCatalogue {

    private final static String CONNECTION_STRING = "jdbc:hsqldb:hsql://localhost/workdb";

    IUnitOfWork uow;
    Connection connection;


    ZwierzetaRepository zwierzeRepo;

    private Connection getNewConnection() throws SQLException {

        try{
        Class.forName("org.hsqldb.jdbcDriver");
        }catch(ClassNotFoundException e){
        e.printStackTrace();
    }
        return DriverManager.getConnection(CONNECTION_STRING);
    }

    private IUnitOfWork getNewUow() {
        return new UnitOfWork(connection);
    }

    public void setUow(IUnitOfWork uow) {
        this.uow = uow;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public RepositoryCatalogue() throws SQLException {

        setConnection(getNewConnection());
        setUow(getNewUow());
              

    }

    public void save(){
        uow.saveChanges();
    }
        
    public void close() {
        try {
            uow.saveChanges();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ZwierzetaRepository zwierzetaRepository() {
        if (zwierzeRepo == null) {
            zwierzeRepo = new ZwierzetaRepository(connection, new ZwierzeMapper(), uow);
        }
        return zwierzeRepo;
    }

}
