package jdbc;

public class Venda {
	
	private int idVenda;
	private double valorTotal;
	private Cliente cliente;
	private Produto produto;
	private int idItensVenda;
	private int qtdProduto;
	
	
	
	@Override
	public String toString() {
		return "Venda [idVenda=" + idVenda + ", valorTotal=" + valorTotal + ", cliente=" + cliente + ", produto="
				+ produto + ", idItensVenda=" + idItensVenda + ", qtdProduto=" + qtdProduto + "]";
	}
	
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getIdItensVenda() {
		return idItensVenda;
	}
	public void setIdItensVenda(int idItensVenda) {
		this.idItensVenda = idItensVenda;
	}
	public int getQtdProduto() {
		return qtdProduto;
	}
	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	}
	
	

}
