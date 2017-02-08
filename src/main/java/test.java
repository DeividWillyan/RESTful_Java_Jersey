import br.com.RESTful.dao.UsuarioDAO;
import br.com.RESTful.domain.Usuario;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		usuario = dao.buscarPorCodigo(3L);

		System.out.println(usuario.getEmail());

	}

}
