package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	
	public List<Produto> pesquisarProduto(){
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement stmt;
		String sql = "SELECT a.idproduto, A.descricao, A.PRECO, B.DESCRICAO AS CATEGORIA FROM PRODUTO a"
				+ " INNER JOIN categoria B ON a.idcategoria = b.idcategoria";
		List<Produto> lstProduto = new ArrayList<Produto>();
		
		try {
			stmt = cnx.prepareStatement(sql);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()) {
				Produto p = new Produto();
				p.descricao = rs.getString("descricao");
				p.idProduto = rs.getInt("idProduto");
				p.preco = rs.getDouble("preco");
				
				Categoria c = new Categoria();
				c.setDescricao(rs.getString("Categoria"));
				p.setCategoria(c);
				lstProduto.add(p);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lstProduto;
		
	}
	
	public List<Produto> pesquisarProduto(String descricao){
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement stmt;
		String sql = "SELECT a.idproduto, A.descricao, A.PRECO, B.DESCRICAO AS CATEGORIA FROM PRODUTO a"
				+ " INNER JOIN categoria B ON a.idcategoria = b.idcategoria"
				+ " WHERE A.DESCRICAO LIKE UPPER(?) COLLATE BINARY_CI";
		List<Produto> lstProduto = new ArrayList<Produto>();
		
		try {
			stmt = cnx.prepareStatement(sql);
			stmt.setString(1, "%" + descricao.toUpperCase() + "%");
			ResultSet rs= stmt.executeQuery();
			while(rs.next()) {
				Produto p = new Produto();
				p.descricao = rs.getString("descricao");
				p.idProduto = rs.getInt("idProduto");
				p.preco = rs.getDouble("preco");
				
				Categoria c = new Categoria();
				c.setDescricao(rs.getString("Categoria"));
				p.setCategoria(c);
				lstProduto.add(p);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lstProduto;
		
	}
	
	

}
