package wrk;

import beans.Utilisateur;
import java.sql.SQLException;

/**
 *
 * @author StellaA
 */
public class Wrk {

    /**
     * Instance de la classe WrkDB
     */
    private final WrkDB wrkDB;

    /**
     * Constructeur de la classe Wrk de l'état-major. Il définit les instances
     * de wrkDB.
     */
    public Wrk() {
        wrkDB = new WrkDB();
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
        return wrkDB.connectDB(pu, login, password);
    }

    /**
     * Cette méthode permet de se déconnecter de la base de données.
     *
     * @return true si la déconnexion à la base de données s'est correctement
     * effectuée ou false.
     * @throws SQLException si une erreur en rapport au SQL se produit.
     */
    public boolean disconnectDB() throws SQLException {
        return wrkDB.disconnectDB();
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
        return wrkDB.isUsernameAndPasswordMatch(username, password);
    }

}
