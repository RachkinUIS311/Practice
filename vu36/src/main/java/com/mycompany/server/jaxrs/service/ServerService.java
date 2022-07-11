/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.server.jaxrs.service;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.server.jaxrs.model.VU36Model;
import com.mycompany.server.jaxrs.model.VU36List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
//import java.io.File;
//import java.io.IOException;

import java.util.ArrayList;
@Path("")
public class ServerService {
    
    //private final static String baseFile = "DBNote.json";

    /*
    public static DBNote toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), DBNote.class);
    }
    */
    
    @GET
    @Path("/getlist")
    @Produces(MediaType.APPLICATION_JSON)
    public VU36List getJSON ()
    {
        VU36List list = new VU36List();
        //ArrayList<DBNote> el = new ArrayList<DBNote>();
        list.addEl(new VU36Model("05806195", "ДР", "СВ", "2022-04-18 09:00:00+03", "2022-04-25 09:00:00+03", "ЛВЧД_САРАТОВ"));
        return list;
    }
}