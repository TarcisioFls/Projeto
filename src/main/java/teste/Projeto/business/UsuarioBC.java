package teste.Projeto.business;

import teste.Projeto.domain.Usuario;
import teste.Projeto.persistence.UsuarioDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class UsuarioBC extends DelegateCrud<Usuario, Long, UsuarioDAO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
