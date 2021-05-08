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
 * Classe UserManagerAberdeen
 * Cette classe permet recevoir les requêtes GET/POST/DELETE/PUT et de les traiter.
 *
 * @author StellaA
 * @version 1.0
 * @project Aberdeen module 133
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
     * Constructeur de la classe UserManagerAberdeen de l'état-major. Il défini
     * les instances de refCtrl.
     */
    public UserManagerAberdeen() {
        refCtrl = new Ctrl();
    }


    /**
     * Cette méthode permet de recevoir la requête GET pour la connexion de l'utilisateur. Elle demande en paramètres
     * le login de l'utilisateur et le mot de passe. Elle va ensuite vérifier si les identifiants matchent par rapport
     * au entrées dans la base de données. En fonction de ce résultat, un JSON sera retourné.
     *
     * @param username représente le nom de l'utilisateur qui souhaite se connecter.
     * @param password représente le mot de passe de l'utilisateur souhaitant se connecter.
     * @return un String contenant un object Utilisateur sous forme de JSON ou un message d'erreur.
     */
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
