/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.server.jaxrs.dao;

import java.sql.*;
import com.mycompany.server.jaxrs.model.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author MyPC
 */
public class DBMethods {
    
    
    public static VU36List getList() throws Exception, SQLException
    {
        
        Class.forName("org.postgresql.Driver");
            
        String url = "jdbc:postgresql://localhost:5432/db";
        String user = "Admin";
        String pass = "123456";
        Connection conn = DriverManager.getConnection(url, user, pass);
        Statement stmt = conn.createStatement();
        StringBuilder query = new StringBuilder();
        
        query.append(" select vu_36.id,vu_36.vagnum, nsi.nsi_type as remtype, t1.nsi_type as vag, vu_36.tsn, vu_36.tsk, vu_36.snazv ");
        query.append(" from vu_36 ");
        query.append(" inner join nsi on remtype = nsi_kod and nsi_spr = 86 ");
        query.append(" inner join nsi as t1 on vagtype = t1.nsi_kod and t1.nsi_spr= 34 ");
        query.append(" where vu_36.tsk between nsi.nsi_datan and nsi.nsi_datak ");
        ResultSet rs = stmt.executeQuery(query.toString());
        
        VU36List list = new VU36List();
        while (rs.next()) {
            VU36Model model = new VU36Model();
            model.setId(rs.getInt("id"));
            model.setVagnum(rs.getString("vagnum"));
            model.setRemtype(rs.getString("remtype"));
            model.setVag(rs.getString("vag"));
            model.setTsn(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(rs.getTimestamp("tsn")));
            model.setTsk(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(rs.getTimestamp("tsk")));
            model.setSnazv(rs.getString("snazv"));
            list.addEl(model);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    
    public static VU36Model getDoc(int id) throws Exception, SQLException
    {
        
        Class.forName("org.postgresql.Driver");
            
        String url = "jdbc:postgresql://localhost:5432/db";
        String user = "Admin";
        String pass = "123456";
        Connection conn = DriverManager.getConnection(url, user, pass);
        Statement stmt = conn.createStatement();
        StringBuilder query = new StringBuilder();
        
        query.append(" select vu_36.id, vu_36.vagnum, nsi.nsi_fname, vu_36.tsn, vu_36.tsk, vu_36.nazv ");
        query.append(" from vu_36 ");
        query.append(" inner join nsi on remtype = nsi_kod and nsi_spr = 86 and vu_36.tsk between nsi.nsi_datan and nsi.nsi_datak ");
        query.append(" inner join nsi as t1 on vagtype = t1.nsi_kod and t1.nsi_spr= 34 and vu_36.tsk between t1.nsi_datan and t1.nsi_datak ");
        query.append(" where vu_36.id = " + id);
        ResultSet rs = stmt.executeQuery(query.toString());
        
        VU36Model doc = new VU36Model();
        if (rs.next()) {
            doc.setId(rs.getInt("id"));
            doc.setVagnum(rs.getString("vagnum"));
            doc.setRemtype(rs.getString("nsi_fname"));
            doc.setTsn(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(rs.getTimestamp("tsn")));
            doc.setTsk(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(rs.getTimestamp("tsk")));
            doc.setSnazv(rs.getString("nazv"));
        }
        
        rs.close();
        stmt.close();
        conn.close();
        return doc;
    }
    
}
