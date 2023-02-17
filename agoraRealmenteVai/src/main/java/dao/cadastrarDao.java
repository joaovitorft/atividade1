package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlDataTable;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

import factory.ConnectionFactory;
import model.CadastrarModel;

@ManagedBean
public class cadastrarDao {
	
	private HtmlDataTable dataTable;
	List<CadastrarModel> cadastro = new ArrayList<>();
	private Connection connection;

	public cadastrarDao() {
		this.connection = new ConnectionFactory().getConnection();

	}

	public void adicionaUsuario(CadastrarModel cadastrar) {

		String sql = "INSERT INTO cadstrarAluno(Nome,Sexo,Cpf,Telefone)VALUES(?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cadastrar.getNome());
			stmt.setString(2, cadastrar.getSexo());
			stmt.setString(3, cadastrar.getCpf());
			stmt.setString(4, cadastrar.getTelefone());

			stmt.execute();
			stmt.close();

		} catch (Exception u) {
			throw new RuntimeException(u);
		}
	}

	public List<CadastrarModel> listar() {

		

		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = connection.prepareStatement("select * from cadstraraluno");
			rs = pstm.executeQuery();
			
			while(rs.next()) {			
				System.out.println("entrou while");
				CadastrarModel cadastrar = new CadastrarModel();
				cadastrar.setNome(rs.getString("Nome"));
				System.out.println(cadastrar.getNome());
				cadastrar.setSexo(rs.getString("Sexo"));
				System.out.println(cadastrar.getSexo());
				cadastrar.setCpf(rs.getString("Cpf"));
				System.out.println(cadastrar.getCpf());
				cadastrar.setTelefone(rs.getString("Telefone"));
				System.out.println(cadastrar.getTelefone());
				
				cadastro.add(cadastrar); 
				System.out.println(cadastro);
				
			}
			
			
		} catch (SQLException e) {
			 throw new RuntimeException(e);
		}
		finally {
			
		}

		return cadastro;
	}

	public List<CadastrarModel> getCadastro() {
		return cadastro;
	}

	public void setCadastro(List<CadastrarModel> cadastro) {
		this.cadastro = cadastro;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	


	
	

}
