/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.mappers.IMapResultSetIntoEntity;
import dao.model.TypJedzenia;
import dao.model.ZwierzeDoTypJedzenia;
import dao.model.ZwierzeDoWybieg;
import dao.repositories.IZwierzeDoTypJedzenia;
import dao.uow.IUnitOfWork;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TKK
 */
public class ZwierzeDoTypJedzeniaRepository extends RepositoryBase<ZwierzeDoTypJedzenia> implements IZwierzeDoTypJedzenia {

    public static final String TABLE_NAME = "zw_do_typ_jedz";

    public ZwierzeDoTypJedzeniaRepository(Connection connection, IMapResultSetIntoEntity<ZwierzeDoTypJedzenia> mapper, IUnitOfWork uow) {
        super(connection, mapper, uow);
    }

    @Override
    protected String insertSql() {
        return "Insert into "
                + tableName()
                + "(id_zwierze, id_typ_jedzenia) values (?,?)";
    }

    @Override
    protected String updateSql() {
        return "update "
                + tableName()
                + " set (id_zwierze, id_typ_jedzenia) = (?,?) where id = ?";
    }

    @Override
    protected void setUpdate(ZwierzeDoTypJedzenia entity) throws SQLException {
        update.setInt(1, entity.getIdZwierze());
        update.setInt(2, entity.getIdTypJedzenia());
    }

    @Override
    protected void setInsert(ZwierzeDoTypJedzenia entity) throws SQLException {
        insert.setInt(1, entity.getIdZwierze());
        insert.setInt(2, entity.getIdTypJedzenia());
        insert.setInt(3, entity.getId());
    }

    @Override
    protected String deleteSql() {
        return " delete from "
                + tableName()
                + " where id_zwierze=? "
                + " and "
                + " id_typ_jedzenia = ?";
    }

    @Override
    public void setDelete(ZwierzeDoTypJedzenia entity) throws SQLException {
        delete.setInt(1, entity.getIdZwierze());
        delete.setInt(2, entity.getIdTypJedzenia());
    }

    @Override
    protected String createTableSql() {
        return "create table "
                + tableName()
                + "( id int generated by default as identity primary key, id_zwierze int, id_typ_jedzenia int)";
    }

    @Override
    protected String tableName() {
        return TABLE_NAME;
    }

    @Override
    protected void insertNecessaryData() throws SQLException {
    }

    @Override
    public List<TypJedzenia.RodzajJedzenia> pobierzListeJedzeniaDlaZwierze(int id) {
        List<ZwierzeDoTypJedzenia> tempList = new ArrayList<>();
        PreparedStatement getAllById = null;
        try {
            getAllById = connection.prepareCall("select * from " + tableName() + " where id_zwierze=?");
            getAllById.setInt(1, id);
            ResultSet rs = getAllById.executeQuery();
            while (rs.next()) {
                tempList.add(mapper.map(rs));
            }
            List<TypJedzenia.RodzajJedzenia> zwracanaLista = new ArrayList<TypJedzenia.RodzajJedzenia>();
            for (ZwierzeDoTypJedzenia en : tempList) {
                zwracanaLista.add(TypJedzenia.RodzajJedzenia.getById(en.getIdTypJedzenia()));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
