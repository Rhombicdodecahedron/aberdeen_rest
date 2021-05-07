/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import beans.Utilisateur;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ctrl.Ctrl;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author StellaA
 */
@Path("ABERDEEN")
public class UserManagerAberdeen {

    @Context
    private UriInfo context;

    /**
     * Instance de la classe Ctrl
     */
    private final Ctrl refCtrl;

    /**
     * Constructeur de la classe UserManagerAberdeen de l'état-major. Il définit
     * les instances de refCtrl.
     */
    public UserManagerAberdeen() {
        refCtrl = new Ctrl();
    }

    @GET
    @Path("connectUser/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String connectUser(@PathParam("username") String username, @PathParam("password") String password) {
        String result = null;
        Gson builder = new GsonBuilder().create();
        try {
            if (refCtrl.connectDB("jdbc:mysql://stellaa.emf-informatique.ch:3306/stellaa_aberdeen_db?serverTimezone=UTC", "stellaa_root", "FXl_qCFjc0DI")) {
                Utilisateur utilisateur = refCtrl.isUsernameAndPasswordMatch(username, password);
                if (utilisateur != null && refCtrl.disconnectDB()) {
                    result = builder.toJson(utilisateur);
                }
            }
        } catch (java.lang.Exception e) {
            result = "Error !!";
            result += "\n";
            result += e.getMessage();
        }

        return result;
    }
}
