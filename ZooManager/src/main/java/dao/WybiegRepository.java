/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.model.Wybieg;
import dao.mappers.IMapResultSetIntoEntity;
import dao.model.IHaveId;
import dao.model.Zwierze;
import dao.repositories.IRepositoryWybieg;
import dao.uow.IUnitOfWork;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TKK
 */
public class WybiegRepository extends RepositoryBase<Wybieg> implements IRepositoryWybieg{

    public WybiegRepository(Connection connection, IMapResultSetIntoEntity<Wybieg> mapper, IUnitOfWork uow) {
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
    protected void setUpdate(Wybieg entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setInsert(Wybieg entity) throws SQLException {
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
    public List<Wybieg> pobierzListeWybiegow(Zwierze zwierze) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
