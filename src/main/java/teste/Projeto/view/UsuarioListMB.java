package teste.Projeto.view;

import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import teste.Projeto.business.UsuarioBC;
import teste.Projeto.domain.Usuario;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ManagedBean
@ViewScoped
@ViewController
@NextView("/usuario_edit.xhtml")
@PreviousView("/usuario_list.xhtml")
public class UsuarioListMB extends AbstractListPageBean<Usuario, Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioBC bc;
	
	@Override
	protected List<Usuario> handleResultList() {
		return this.bc.findAll();
	}
	
	private List<Usuario>filtroUsuario;
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);

			if (delete) {
				bc.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

	public List<Usuario> getFiltroUsuario() {
		return filtroUsuario;
	}

	public void setFiltroUsuario(List<Usuario> filtroUsuario) {
		this.filtroUsuario = filtroUsuario;
	}
	
	

}
