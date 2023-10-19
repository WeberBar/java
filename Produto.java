package Entity;


public class Produto {
private int id;
private String nome;
private int quantidade;
private double valorProduto;

    public Produto() {
    }


    public Produto(int id, String nome, int quantidade, double valorProduto) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorProduto = valorProduto;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }
 
     public String toString(){
        return "Código: " + getId()
                +"\nNome: " + getNome()
                +"\nQuantidade em estoque: " + getQuantidade()
                +"\nPreço: R$" + String.format("%.2f", getValorProduto());
    }
}
