/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.mappers.IMapResultSetIntoEntity;
import dao.model.ZwierzeDoWybieg;
import dao.uow.IUnitOfWork;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author TKK
 */
public class ZwierzeDoWybiegRepository extends RepositoryBase<ZwierzeDoWybieg> {

    public ZwierzeDoWybiegRepository(Connection connection, IMapResultSetIntoEntity<ZwierzeDoWybieg> mapper, IUnitOfWork uow) {
        super(connection, mapper, uow);
    }

    @Override
    protected String insertSql() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String updateSql() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setUpdate(ZwierzeDoWybieg entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setInsert(ZwierzeDoWybieg entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String createTableSql() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String tableName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void insertNecessaryData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String deleteSql() {
        return " delete from "
                +tableName()
                + " where zwierz_id=? "
                + " and "
                + " wybieg_id = ?";
    }

    @Override
    public void setDelete(ZwierzeDoWybieg entity) throws SQLException {
        delete.setInt(1, entity.getIdZwierze());
        delete.setInt(2, entity.getIdWybieg());
    }

}
