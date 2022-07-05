/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.server.jaxrs.model;

import java.util.ArrayList;
import com.mycompany.server.jaxrs.model.DBNote;
/**
 *
 * @author MyPC
 */
public class DBList {
    private ArrayList<DBNote> list = new ArrayList<DBNote>();

    public DBList() {
    }
    
    public DBList(ArrayList<DBNote> list) {
        this.list = list;
    }

    public ArrayList<DBNote> getList() {
        return list;
    }

    public void setList(ArrayList<DBNote> list) {
        this.list = list;
    }
    
    public void addEl(DBNote note) {
        this.list.add(note);
    }
    
    public void removeEl(DBNote note) {
        this.list.remove(note);
    }

    @Override
    public String toString() {
        return "DBList{" + "list=" + list + '}';
    }
    
    
}
