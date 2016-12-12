/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.mappers.IMapResultSetIntoEntity;
import dao.model.TypWybiegu;
import dao.model.ZwierzeDoTypWybiegu;
import dao.repositories.IZwierzeDoTypWybiegu;
import dao.uow.IUnitOfWork;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TKK
 */
public class ZwierzeDoTypWybieguRepository extends RepositoryBase<ZwierzeDoTypWybiegu> implements IZwierzeDoTypWybiegu {

    private static final String TABLE_NAME = "zwierze_do_typ_wybiegu";

    public ZwierzeDoTypWybieguRepository(Connection connection, IMapResultSetIntoEntity<ZwierzeDoTypWybiegu> mapper, IUnitOfWork uow) {
        super(connection, mapper, uow);
    }

    @Override
    protected String insertSql() {
        return "insert into "
                + tableName()
                + " (id_zwierze, id_typ_wybiegu)"
                + "values (?,?)";
    }

    @Override
    protected String updateSql() {
        return "update "
                + tableName()
                + " set (id_zwierze, id_typ_wybiegu) ="
                + " (?,?)"
                + " where id = ?";
    }

    @Override
    protected void setUpdate(ZwierzeDoTypWybiegu entity) throws SQLException {
        update.setInt(1, entity.getIdZwierze());
        update.setInt(2, entity.getIdWybieg());
        update.setInt(3, entity.getId());

    }

    @Override
    protected void setInsert(ZwierzeDoTypWybiegu entity) throws SQLException {
        insert.setInt(1, entity.getIdZwierze());
        insert.setInt(2, entity.getIdWybieg());
    }

    @Override
    protected String createTableSql() {
        return "create table "
                + tableName()
                + "(id int generated by default as identity primary key,"
                + "id_zwierze int,"
                + "id_typ_wybiegu int,"
                + "foreign key (id_zwierze) references "
                + ZwierzetaRepository.TABLE_NAME
                + "(id),"
                + "foreign key (id_typ_wybiegu) references "
                + TypWybieguRepository.TABLE_NAME
                + "(id))";
    }

    @Override
    protected String tableName() {
        return TABLE_NAME;
    }

    @Override
    protected String deleteSql() {
        return " delete from "
                + tableName()
                + " where id_zwierze=? "
                + " and "
                + " id_typ_wybiegu = ?";
    }

    @Override
    public void setDelete(ZwierzeDoTypWybiegu entity) throws SQLException {
        delete.setInt(1, entity.getIdZwierze());
        delete.setInt(2, entity.getIdWybieg());
    }

    @Override
    protected void insertNecessaryData() throws SQLException {
    }

    @Override
    public List<TypWybiegu.RodzajWybiegu> getRodzajeWybieguDlaZwierze(int idZwierze) {
        List<ZwierzeDoTypWybiegu> tempList = new ArrayList<>();
        PreparedStatement getAllById;
        try {
            getAllById = connection.prepareCall("select * from " + tableName() + " where id_zwierze=?");
            getAllById.setInt(1, idZwierze);
            ResultSet rs = getAllById.executeQuery();
            while (rs.next()) {
                tempList.add(mapper.map(rs));
            }
            List<TypWybiegu.RodzajWybiegu> zwracanaLista = new ArrayList<>();
            for (ZwierzeDoTypWybiegu en : tempList) {
                zwracanaLista.add(TypWybiegu.RodzajWybiegu.getById(en.getIdWybieg()));
            }
            return zwracanaLista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
