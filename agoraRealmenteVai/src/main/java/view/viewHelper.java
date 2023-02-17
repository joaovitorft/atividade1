package view;

import java.util.ArrayList;
import java.util.List;

import model.CadastrarModel;

public class viewHelper {

	private CadastrarModel cadastrarModel;
	private List<CadastrarModel> cadastro = new ArrayList<CadastrarModel>();

	public List<CadastrarModel> getCadastro() {
		return cadastro;
	}

	public void setCadastro(List<CadastrarModel> cadastro) {
		this.cadastro = cadastro;
	}
	
	public viewHelper() {
		super();
		this.setCadastro(new ArrayList<CadastrarModel>());
		//private List<CadastrarModel> cadastro = new ArrayList<>();
	}

	public CadastrarModel getCadastrarModel() {
		return cadastrarModel;
	}

	public void setCadastrarModel(CadastrarModel cadastrarModel) {
		this.cadastrarModel = cadastrarModel;
	}
	

	
	
}
