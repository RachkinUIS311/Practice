/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.server.jaxrs.service;

import com.mycompany.server.jaxrs.model.VU36Model;
import com.mycompany.server.jaxrs.model.VU36List;
import com.mycompany.server.jaxrs.dao.*;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class ServerService {
    
    @GET
    @Path("/getlist")
    @Produces(MediaType.APPLICATION_JSON)
    public VU36List getJSON () throws SQLException, Exception
    {
        DBMethods dbmethods = new DBMethods();
        VU36List list = new VU36List();
        list = dbmethods.getList();
        return list;
    }
}