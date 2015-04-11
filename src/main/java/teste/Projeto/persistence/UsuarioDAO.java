package teste.Projeto.persistence;

import teste.Projeto.domain.Usuario;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
