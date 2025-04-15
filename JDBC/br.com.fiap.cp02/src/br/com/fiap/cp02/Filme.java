package br.com.fiap.cp02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Filme {

	
	private int idFilme;
	private String titulo;
	private String diretor;
	private String genero;
	private int duracao_min;
	
	
	public int getId() {
		return idFilme;
	}
	public void setId(int id) {
		this.idFilme = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getDuracao_min() {
		return duracao_min;
	}
	public void setDuracao_min(int duracao_min) {
		this.duracao_min = duracao_min;
	}
	@Override
	public String toString() {
		return "Filme [idFilme=" + idFilme + ", titulo=" + titulo + ", diretor=" + diretor + ", genero=" + genero
				+ ", duracao_min=" + duracao_min + "]";
	}
	
	
	
	//MÉTODOS
	public void inserirFilme() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement stmt;
		
		String sql = "INSERT INTO FILME (ID, TITULO, DIRETOR, GENERO, DURACAO_MIN) VALUES (?,?,?,?,?)";
		
		try {
			stmt = cnx.prepareStatement(sql);
			stmt.setInt(1, this.idFilme);
			stmt.setString(2, this.titulo);
			stmt.setString(3, this.diretor);
			stmt.setString(4, this.genero);
			stmt.setInt(5, this.duracao_min);
			stmt.executeUpdate();
			System.out.println("Filme inserido com sucesso!");
			
		} catch (SQLException	 e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
	}
	
	
	public void alterarFilme() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement stmt;
		
		String sql = "UPDATE FILME SET DIRETOR =?, GENERO=? WHERE ID=?";
		
		try {
			stmt = cnx.prepareStatement(sql);
			stmt.setString(1, this.diretor);
			stmt.setString(2, this.genero);
			stmt.setInt(3, this.idFilme);
			stmt.executeUpdate();
			System.out.println("Alteracao feita com sucesso!");
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	public void excluirFilme() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement stmt;
		
		String sql = "DELETE FROM FILME WHERE ID=?";
		
		try {
			stmt = cnx.prepareStatement(sql);
			stmt.setInt(1, this.idFilme);
			stmt.executeUpdate();
			System.out.println("Filme deletado!");
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
	public List<Filme> listarTodos() {
		
		List<Filme> listaFilmes = new ArrayList();
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement stmt;
		
		String sql = "SELECT * FROM FILME";
		
		try {
			stmt = cnx.prepareStatement(sql);	
			ResultSet rs = stmt.executeQuery(sql);
			

			//if(!rs.next()) {
			//	System.out.println("Não há linhas para exibir!");
			//}
			
			while(rs.next()) {
				//Enquanto tiver linhas a serem exibidas
				Filme f = new Filme();
				f.idFilme = rs.getInt("ID");
				f.titulo = rs.getString("TITULO");
				f.diretor = rs.getString("DIRETOR");
				f.genero = rs.getString("GENERO");
				f.duracao_min = rs.getInt("DURACAO_MIN");
				listaFilmes.add(f);
				System.out.println(rs.getString("TITULO") + "	" + rs.getString("DIRETOR") + "	" + rs.getString("GENERO"));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return listaFilmes;
	}
	
	public void buscaFilme(String genero) {
		
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement stmt;
		
		String sql = "SELECT * FROM FILME WHERE GENERO=? ";
		
		try {
			stmt = cnx.prepareStatement(sql);			
			stmt.setString(1, genero);
			ResultSet rs = stmt.executeQuery();
					
			//if(!rs.next()) {
			//	System.out.println("Não há nada!");
			//}
		
			while(rs.next()) {
				Filme f = new Filme();
				f.genero = rs.getString("GENERO");
				f.idFilme = rs.getInt("ID");
				f.titulo = rs.getString("TITULO");
				f.diretor = rs.getString("DIRETOR");
				f.duracao_min = rs.getInt("DURACAO_MIN");
				System.out.println(f);
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	
	
	
}
