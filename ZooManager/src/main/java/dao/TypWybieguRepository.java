/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.mappers.IMapResultSetIntoEntity;
import dao.model.TypWybiegu;
import dao.uow.IUnitOfWork;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author TKK
 */
public class TypWybieguRepository extends RepositoryBase<TypWybiegu> {

    public TypWybieguRepository(Connection connection, IMapResultSetIntoEntity<TypWybiegu> mapper, IUnitOfWork uow) {
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
    protected void setUpdate(TypWybiegu entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setInsert(TypWybiegu entity) throws SQLException {
        insert.setInt(1, entity.getId());
        insert.setString(2, entity.getRodzajWybiegu().toString());
//wyciagniecie enuma na podstawie string
//TypWybiegu.RodzajWybiegu.valueOf(entity.getRodzajWybiegu().toString());
        
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
        for (TypWybiegu.RodzajWybiegu param : TypWybiegu.RodzajWybiegu.values()) {
            add(new TypWybiegu(param));
        }
        getUnitWork().saveChanges();
    }

}
