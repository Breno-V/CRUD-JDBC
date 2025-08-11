//Data Acess Object

import java.sql.*;
import java.util.*;

public class ProdutoDAO {
    public void inserir(Produto produto) {
        String comandoSql = "INSERTO INTO produtos (nome, preco) VALUES (?, ?)";

        try (Connection conexao = Conexao.conectar();
                PreparedStatement stmt = conexao.prepareStatement(comandoSql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.executeUpdate();
            System.err.println("Produto inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
