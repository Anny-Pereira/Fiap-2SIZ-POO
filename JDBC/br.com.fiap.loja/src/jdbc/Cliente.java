package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private int idCliente;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone
				+ ", cpf=" + cpf + "]";
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public void insereCliente() {
		Connection cnx = ConnectionDB.obterConexao();
		String sql = "Insert into Cliente (idCliente, nome, email, telefone, cpf) values (?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setInt(1, this.idCliente);
			pstmt.setString(2, this.nome);
			pstmt.setString(3, this.email);
			pstmt.setString(4, this.telefone);
			pstmt.setString(5, this.cpf);
			pstmt.executeUpdate();
			System.out.println("Cliente inserido com sucesso!");
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public void alteraCliente() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		String sql = "UPDATE CLIENTE SET EMAIL =?, TELEFONE=? WHERE IDCLIENTE=?";
		
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setString(1, this.email);
			pstmt.setString(2,  this.telefone);
			pstmt.setInt(3, this.idCliente);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	public void excluiCliente() {
		Connection cnx = ConnectionDB.obterConexao() ;
		String sql = "DELETE FROM CLIENTE WHERE IDCLIENTE =?";
		
		PreparedStatement pstmt;
		
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setInt(1,  this.idCliente);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	public List<Cliente> pesquisarClientes() {
		
		List<Cliente> lstClientes = new ArrayList();
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement stmt;
		
		String sql = "SELECT * FROM CLIENTE";
		
		try {
			stmt = cnx.prepareStatement(sql);			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(!rs.next()) {
				System.out.println("Não há linhas para exibir!");
			}
			
			while(rs.next()) {
				//Enquanto tiver linhas a serem exibidas
				Cliente c = new Cliente();
				c.idCliente= rs.getInt("IDCLIENTE");
				c.nome = rs.getString("NOME");
				c.email = rs.getString("EMAIL");
				c.telefone = rs.getString("TELEFONE");
				c.cpf = rs.getString("CPF");
				lstClientes.add(c);
				System.out.println(rs.getString("NOME") + "				 " + rs.getString("CPF"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 return lstClientes;

		
	}
	
	
	public void buscaCliente(int idCliente) {
		
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement stmt;
		
		String sql = "SELECT * FROM CLIENTE WHERE IDCLIENTE=? ";
		
		try {
			stmt = cnx.prepareStatement(sql);			
			stmt.setInt(1, idCliente);
			ResultSet rs = stmt.executeQuery();
					
			if(!rs.next()) {
				System.out.println("Não há nada ");
				
			}
			
			Cliente c = new Cliente();
			c.idCliente = rs.getInt("IDCLIENTE");
			c.nome = rs.getString("NOME");
			c.email = rs.getString("EMAIL");
			c.telefone = rs.getString("TELEFONE");
			c.cpf = rs.getString("CPF");
			System.out.println(c);
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
	}
	
	public void buscaClienteNome(String nomeCliente) {
		
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement stmt;
		
		String sql = "SELECT * FROM CLIENTE WHERE NOME=? ";
		
		try {
			stmt = cnx.prepareStatement(sql);			
			stmt.setString(1, nomeCliente);
			ResultSet rs = stmt.executeQuery();
					
			
			
			while(rs.next()) {
			Cliente c = new Cliente();
			c.idCliente = rs.getInt("IDCLIENTE");
			c.nome = rs.getString("NOME");
			c.email = rs.getString("EMAIL");
			c.telefone = rs.getString("TELEFONE");
			c.cpf = rs.getString("CPF");
			System.out.println(c);
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
	}

}
