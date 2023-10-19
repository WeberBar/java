
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dao.ConnectionFactory;
import Entity.Produto;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {
    public void inserir(Produto produto) {
        String sql = "insert into produtos(nome, quantidade, valorUnitario) values (?,?,?)";

        try (Connection conn = ConnectionFactory.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, String.valueOf(produto.getQuantidade()));
            stmt.setString(3,String.valueOf(produto.getValorProduto()));
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir produtos: " + ex.getMessage());
        }
    }
    public void excluir(int codigo) {
        String sql = "delete from produtos where id = ?";

        try (Connection conn = ConnectionFactory.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigo);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir produto: " + ex.getMessage());
        }
    }
     public ArrayList<Produto> getAllUsuarios() {
        String sql = "SELECT * FROM produtos";
        ArrayList<Produto> produtos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql); 
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nome = rs.getString("nome");
                String quantidade = rs.getString("quantidade");
                String precoProduto = rs.getString("valorUnitario");
                int id = rs.getInt("id");

                Produto produ = new Produto(id, nome, Integer.parseInt(quantidade), Double.parseDouble(precoProduto));
                produtos.add(produ);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Todos produtos: " + ex.getMessage());
        }

        return produtos;
    }
}

