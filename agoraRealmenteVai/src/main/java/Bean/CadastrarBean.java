package Bean;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import dao.cadastrarDao;
import factory.ConnectionFactory;
import model.CadastrarModel;
import javax.servlet.http.HttpServletRequest;




@ManagedBean
public class CadastrarBean {
	
	
	private List<CadastrarModel> cadastro = null;
	
	public void enviaCadastroDao() {
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

		
		CadastrarModel cadastrar = new CadastrarModel();
		cadastrarDao Dao = new cadastrarDao();

		String nome = request.getParameter("cadastrarAluno:cadastrarNome");
		String sexo = request.getParameter("cadastrarAluno:cadastrarSexo");
		String cpf = request.getParameter("cadastrarAluno:cadastrarCpf");
		String telefone = request.getParameter("cadastrarAluno:cadastrarTelefone");
		
		cadastrar.setNome(nome);
		cadastrar.setSexo(sexo);
		cadastrar.setCpf(cpf);
		cadastrar.setTelefone(telefone);
		
		
		
		Dao.adicionaUsuario(cadastrar);
		
	}
	
	
	

}
