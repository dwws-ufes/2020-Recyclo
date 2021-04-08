import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Specializes;
import com.github.adminfaces.template.session.AdminSession;
import org.omnifaces.util.Faces;
import java.io.Serializable;
import java.io.IOException;
// import static com.github.adminfaces.starter.util.Utils.addDetailMessage;
// import br.ufes.informatica.recyclo.core.controller.LoginController;


@SessionScoped
@Specializes
public class LogonMB extends AdminSession implements Serializable {

    private String currentUser;
    private String email;
    private String password;
    private boolean remember;

    // public void login() throws IOException {
    //     currentUser = email;

    //     addDetailMessage("Logged in successfully as <b>" + email + "</b>");
    //     Faces.getExternalContext().getFlash().setKeepMessages(true);
    //     Faces.redirect("index.xhtml");
    // }

    @Override
    public boolean isLoggedIn() {
        return false;
    }

    //getters&setters
}