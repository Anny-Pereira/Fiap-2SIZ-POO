package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Produto {
	
	private int idProduto;
	private String descricao;
	private double preco;
	private Categoria categoria;
	
	
	
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", descricao=" + descricao + ", preco=" + preco + ", categoria="
				+ categoria + "]";
	}
	
	
	
	public void inserirProduto() {
		Connection cnx = ConnectionDB.obterConexao();
		
		PreparedStatement stmt;
		
		String sql = "Insert into Produto (IDPRODUTO, DESCRICAO, PRECO, IDCATEGORIA)"
						+ "VALUES (?,?,?,?)";
		
		try {
			stmt = cnx.prepareStatement(sql);
			stmt.setInt(1, this.idProduto);
			stmt.setString(2, this.descricao);
			stmt.setDouble(3, this.preco);
			stmt.setInt(4, this.categoria.getIdCategoria());
			stmt.executeUpdate();
			System.out.println("\tProduto criado!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
	}
	
	

}
