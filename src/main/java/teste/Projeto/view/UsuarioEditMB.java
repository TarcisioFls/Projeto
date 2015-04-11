package teste.Projeto.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import teste.Projeto.business.UsuarioBC;
import teste.Projeto.domain.Usuario;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ManagedBean
@ViewController
@PreviousView("/usuario_edit.xhtml")
public class UsuarioEditMB extends AbstractEditPageBean<Usuario, Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioBC usuarioBC;

	@Override
	@Transactional
	public String delete() {
		this.usuarioBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.usuarioBC.insert(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.usuarioBC.update(getBean());
		return getPreviousView();
	}

	@Override
	protected Usuario handleLoad(Long id) {
		return this.usuarioBC.load(id);
	}
	
	public void saveMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		context.addMessage(null, new FacesMessage("Cadastro Completo", "Membro " + getBean().getNome() + " Cadastrado com Sucesso!"));
	}
	
	public void alterarMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		context.addMessage(null, new FacesMessage("Alteração Completa", "Membro " + getBean().getNome() + " Atualizado com Sucesso!"));
	}

}
