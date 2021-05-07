package wrk;

import beans.Utilisateur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author StellaA
 */
public class WrkDB {

    /**
     * Variable de connection à la base de données.
     */
    private Connection jdbcConnection;

    /**
     * Constructeur de la classe WrkDB de l'état-major. Il définit la variable
     * jdbcConnection à null.
     */
    public WrkDB() {
        jdbcConnection = null;
    }

    /**
     *
     * Cette méthode permet de se connecter à la base de données de
     * l'état-major. Elle demande en paramètre l'url de la connexion à la base
     * de données, le login et le mot de passe.
     *
     * @param PU représente l'url pour la connexion à la base de données.
     * @param login représente le nom d'utilisateur du visiteur voulant se
     * connecter.
     * @param password représente le mot de passe du visiteur voulant se
     * connecter.
     * @return true si la connexion à la base de données s'est correctement
     * effectuée ou false.
     * @throws Exception si une quelconque erreur se produit.
     */
    public boolean connectDB(String PU, String login, String password) throws Exception {
        boolean ok = false;
        if (jdbcConnection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            jdbcConnection = DriverManager.getConnection(PU, login, password);
            ok = true;
        }
        return ok;
    }

    /**
     * Cette méthode permet de se déconnecter de la base de données.
     *
     * @return true si la déconnexion à la base de données s'est correctement
     * effectuée ou false.
     * @throws SQLException si une erreur en rapport au SQL se produit.
     */
    public boolean disconnectDB() throws SQLException {
        boolean ok = false;
        if (jdbcConnection != null) {
            jdbcConnection.close();
            jdbcConnection = null;
            ok = true;
        }
        return ok;
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
        Utilisateur result = null;

        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            PreparedStatement preparedStatement = jdbcConnection.prepareStatement("SELECT * FROM t_utilisateur WHERE username=? AND password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = new Utilisateur(resultSet.getString("username"), resultSet.getString("password"));
                //  result.setDate_creation(resultSet.getDate("date_creation"));
                result.setIsUsernamePasswordCorrect(true);
            } else {
                result = new Utilisateur(username, password);
            }
            resultSet.close();
            preparedStatement.close();
        }
        return result;

    }

}
