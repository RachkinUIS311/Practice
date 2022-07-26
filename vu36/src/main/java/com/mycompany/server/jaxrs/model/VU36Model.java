/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.server.jaxrs.model;

/**
 *
 * @author MyPC
 */
public class VU36Model {
    
    private int id;
    private String vagnum;
    private String remtype;
    private String vag;
    private String tsn;
    private String tsk;
    private String snazv;

    public VU36Model() {
    }

    
    
    public VU36Model(int id, String vagnum, String remtype, String vag, String tsn, String tsk, String snazv) {
        this.id = id;
        this.vagnum = vagnum;
        this.remtype = remtype;
        this.vag = vag;
        this.tsn = tsn;
        this.tsk = tsk;
        this.snazv = snazv;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVagnum() {
        return vagnum;
    }

    public void setVagnum(String vagnum) {
        this.vagnum = vagnum;
    }

    public String getRemtype() {
        return remtype;
    }

    public void setRemtype(String remtype) {
        this.remtype = remtype;
    }

    public String getVag() {
        return vag;
    }

    public void setVag(String vag) {
        this.vag = vag;
    }

    public String getTsn() {
        return tsn;
    }

    public void setTsn(String tsn) {
        this.tsn = tsn;
    }

    public String getTsk() {
        return tsk;
    }

    public void setTsk(String tsk) {
        this.tsk = tsk;
    }

    public String getSnazv() {
        return snazv;
    }

    public void setSnazv(String snazv) {
        this.snazv = snazv;
    }

    @Override
    public String toString() {
        return "VU36Model{" + "id=" + id + ", vagnum=" + vagnum + ", remtype=" + remtype + ", vag=" + vag + ", tsn=" + tsn + ", tsk=" + tsk + ", snazv=" + snazv + '}';
    }

}