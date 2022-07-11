/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.server.jaxrs.model;

import java.util.ArrayList;
import com.mycompany.server.jaxrs.model.VU36Model;
/**
 *
 * @author MyPC
 */
public class VU36List {
    private ArrayList<VU36Model> list = new ArrayList<VU36Model>();

    public VU36List() {
    }
    
    public VU36List(ArrayList<VU36Model> list) {
        this.list = list;
    }

    public ArrayList<VU36Model> getList() {
        return list;
    }

    public void setList(ArrayList<VU36Model> list) {
        this.list = list;
    }
    
    public void addEl(VU36Model note) {
        this.list.add(note);
    }
    
    public void removeEl(VU36Model note) {
        this.list.remove(note);
    }

    @Override
    public String toString() {
        return "DBList{" + "list=" + list + '}';
    }
    
    
}
