import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ProdutoDAO dao = new ProdutoDAO();
        Scanner scan = new Scanner(System.in);

        System.out.println("1 - Inserir | 2 - Listar | 3 - Atualizar | 4 - Deletar");
        int op = scan.nextInt();
        scan.nextLine(); // limpa o buffer

        switch (op) {
            case 1:
                System.out.println("Insira o nome: ");
                String nome = scan.nextLine();
                System.out.println("Insira o preço: ");
                double preco = scan.nextDouble();
                Produto produto = new Produto(nome, preco);
                dao.inserir(produto);
                break;
            case 2:
                for (Produto prod : dao.listar()) {
                    System.out.println(
                        prod.getId() + " - " +
                        prod.getNome() + " -  R$" +
                        prod.getPreco()
                    );
                }
                break;
            case 3:
                System.out.println("Insira o ID do produto: ");
                int id = scan.nextInt();
                scan.nextLine();
                System.out.println("Insira o novo nome: ");
                String nomeNovo = scan.nextLine();
                System.out.println("Insira o novo preço: ");
                Double precoNovo = scan.nextDouble();
                produto = new Produto(nomeNovo, precoNovo);
                produto.setId(id);
                dao.atualizar(produto);
                break;
            case 4:
                System.out.println("Insira o ID do produto para deletá-lo");
                id = scan.nextInt();
                dao.deletar(id);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
        scan.close();
    }
}
