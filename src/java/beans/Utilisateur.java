package beans;

//import java.sql.Date;

/**
 * Bean Utilisateur
 * Ce Bean contient les informations de l'utilisateur de la base de données.
 *
 * @author Alexis
 * @version 1.0
 * @project Aberdeen module 133
 * @since 06.05.2021
 */
public class Utilisateur {

    private String username;
    private String password;
    private boolean isUsernamePasswordCorrect;
    //private Date date_creation;

    /**
     * Constructeur du Bean Utilisateur.
     *
     * @param username représente le login de l'utilisateur
     * @param password représente le mot de passe de l'utilisateur.
     */
    public Utilisateur(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //SETTER ET GETTER

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsUsernamePasswordCorrect(boolean isUsernamePasswordCorrect) {
        this.isUsernamePasswordCorrect = isUsernamePasswordCorrect;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isIsUsernamePasswordCorrect() {
        return isUsernamePasswordCorrect;
    }

    /*
        public void setDate_creation(Date date_creation) {
            this.date_creation = date_creation;
        }
    */

    /*
        public Date getDate_creation() {
            return date_creation;
        }
    */

}
