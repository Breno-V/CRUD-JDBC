//Data Acess Object

import java.sql.*;
import java.util.*;

public class ProdutoDAO {
    public void inserir(Produto produto) {
        String comandoSql = "INSERT INTO produtos (nome, preco) VALUES (?, ?)";

        try (Connection conexao = Conexao.conectar();
                PreparedStatement stmt = conexao.prepareStatement(comandoSql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.executeUpdate();
            System.out.println("Produto inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Não foi possível inserir o produto!");
            e.printStackTrace();
        }
    }

    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        String comandoSql = "SELECT * FROM produtos";

        try (Connection connection = Conexao.conectar();
                Statement stmt = connection.createStatement();
                ResultSet result = stmt.executeQuery(comandoSql)) {
            while (result.next()) {
                Produto produto = new Produto(result.getString("nome"), result.getDouble("preco"));
                produto.setId(result.getInt("id"));
                lista.add(produto);
            }
        } catch(SQLException e) {
            System.out.println("Não foi possível listar os produtos disponíveis!");
            e.printStackTrace();
        }
        return lista;
    }

    public void atualizar(Produto produto) {
        String comandoSql = "UPDATE produtos SET nome=?, preco=? WHERE id=?";

        try(Connection connection = Conexao.conectar(); PreparedStatement stmt = connection.prepareStatement(comandoSql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getId());
            stmt.executeUpdate();

            System.out.println("Produto atualizado com sucesso!");
        } catch (SQLException e){
            System.out.println("Não foi possível atualizar o produto!");
            e.printStackTrace();
        }
    }

    public void deletar(int id){
        String comandoSql = "DELETE FROM produtos WHERE id=?";

        try(Connection connection = Conexao.conectar(); PreparedStatement stmt = connection.prepareStatement(comandoSql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Produto deletado com sucesso!");
        }catch(SQLException e){
            System.out.println("Não foi possível deletar esse produto!");
            e.printStackTrace();
        }
    }
}
