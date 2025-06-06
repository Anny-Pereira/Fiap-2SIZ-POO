package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private int idCategoria;
	private String descricao;
	
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "idCategoria:" + idCategoria + "  descricao:" + descricao;
	}
	
	
	
	public void inserirCategoria() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement stmt;
		
		String sql = "INSERT INTO CATEGORIA (IDCATEGORIA, DESCRICAO) VALUES (?,?)";
		
		try {
			stmt = cnx.prepareStatement(sql);
			stmt.setInt(1, this.idCategoria);
			stmt.setString(2, this.descricao);
			stmt.executeUpdate();
			System.out.println("Categoria inserida com sucesso!");
			
		} catch (SQLException	 e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
	}
	
	
	public void alterarCategoria() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement stmt;
		
		String sql = "UPDATE CATEGORIA SET DESCRICAO =? WHERE IDCATEGORIA=?";
		
		try {
			stmt = cnx.prepareStatement(sql);
			stmt.setString(1, this.descricao);
			stmt.setInt(2, this.idCategoria);
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	public void excluirCategoria() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement stmt;
		
		String sql = "DELETE FROM CATEGORIA WHERE IDCATEGORIA=?";
		
		try {
			stmt = cnx.prepareStatement(sql);
			stmt.setInt(1, this.idCategoria);
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
	public List<Categoria> pesquisarCategorias() {
		
		List<Categoria> lstCategorias = new ArrayList();
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement stmt;
		
		String sql = "SELECT * FROM CATEGORIA";
		
		try {
			stmt = cnx.prepareStatement(sql);	
			ResultSet rs = stmt.executeQuery(sql);
			
			
			if(!rs.next()) {
				System.out.println("Não há linhas para exibir!");
			}
			
			while(rs.next()) {
				//Enquanto tiver linhas a serem exibidas
				Categoria c = new Categoria();
				c.idCategoria = rs.getInt("IDCATEGORIA");
				c.descricao = rs.getString("DESCRICAO");
				lstCategorias.add(c);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lstCategorias;
	}
	
	public Categoria buscaCategoria(int idCategoria) {
		
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement stmt;
		Categoria c = new Categoria();
		
		String sql = "SELECT * FROM CATEGORIA WHERE IDCATEGORIA=? ";
		
		try {
			stmt = cnx.prepareStatement(sql);			
			stmt.setInt(1, idCategoria);
			ResultSet rs = stmt.executeQuery();
					
			if(!rs.next()) {
				System.out.println("Não há nada ");
				
			}
		
		
			c.idCategoria = rs.getInt("IDCATEGORIA");
			c.descricao = rs.getString("DESCRICAO");
			System.out.println(c);
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		 return c;
	}
	

}
