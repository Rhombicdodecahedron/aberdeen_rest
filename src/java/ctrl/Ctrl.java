package ctrl;

import beans.Utilisateur;
import java.sql.SQLException;
import wrk.Wrk;

/**
 *
 * @author StellaA
 */
public class Ctrl {

    /**
     * Instance de la classe Wrk
     */
    private final Wrk refWrk;

    /**
     * Constructeur de la classe WrkDB de l'état-major. Il définit les instances
     * de WrkLog, WrkDispatcher, WrkDataBase, WrkRobot et WrkServer
     */
    public Ctrl() {
        refWrk = new Wrk();
    }

    /**
     *
     * Cette méthode permet de se connecter à la base de données de
     * l'état-major. Elle demande en paramètre l'url de la connexion à la base
     * de données, le login et le mot de passe.
     *
     * @param pu représente l'url pour la connexion à la base de données.
     * @param login représente le nom d'utilisateur du visiteur voulant se
     * connecter.
     * @param password représente le mot de passe du visiteur voulant se
     * connecter.
     * @return true si la connexion à la base de données s'est correctement
     * effectuée ou false.
     * @throws Exception si une quelconque erreur se produit.
     */
    public boolean connectDB(String pu, String login, String password) throws Exception {
        return refWrk.connectDB(pu, login, password);
    }

    /**
     * Cette méthode permet de se déconnecter de la base de données.
     *
     * @return true si la déconnexion à la base de données s'est correctement
     * effectuée ou false.
     * @throws SQLException si une erreur en rapport au SQL se produit.
     */
    public boolean disconnectDB() throws SQLException {
        return refWrk.disconnectDB();
    }

    /**
     * Cette mthode permet de tester si le login et le mot de passe passés en
     * paramètre correspondent à un utilisateur de la base de données.
     *
     * @param username représente le login de l'utilisateur a rechercher dans la
     * base de données.
     * @param password représente le mot de passe de l'utilisateur a rechercher
     * dans la base de données.
     * @return null si une erreur se produit ou un objet Utilisateur.
     * @throws SQLException si une erreur en rapport au SQL se produit.
     */
    public Utilisateur isUsernameAndPasswordMatch(String username, String password) throws SQLException {
        return refWrk.isUsernameAndPasswordMatch(username, password);
    }

}
