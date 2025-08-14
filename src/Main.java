import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ProdutoDAO dao = new ProdutoDAO();
        CategoriaDAO catDao = new CategoriaDAO();
        Scanner scan = new Scanner(System.in);
        int tabela;

        System.out.println("Escolha a tabela: \n 1 - Produtos  \n 2 - Categorias");
        tabela = scan.nextInt();
        scan.nextLine();

        switch (tabela) {
            case 1:
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
                                            prod.getPreco());
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
            break;
            case 2:
                System.out.println("1 - Inserir | 2 - Listar | 3 - Atualizar | 4 - Deletar");
                int operacao = scan.nextInt();
                scan.nextLine(); // limpa o buffer

                switch (operacao) {
                    case 1:
                        System.out.println("Insira o nome: ");
                        String nome = scan.nextLine();
                        System.out.println("Insira o status (Ativo = S, Inativo = N): ");
                        String ativo = scan.nextLine();
                        Categoria categoria = new Categoria(nome, ativo);
                        catDao.inserir(categoria);
                        break;
                    case 2:
                        for (Categoria cat : catDao.listar()) {
                            System.out.println(
                                    cat.getId() + " - " +
                                            cat.getNome() + " - " +
                                            cat.getAtivo());
                        }
                        break;
                    case 3:
                        System.out.println("Insira o ID da categoria: ");
                        int id = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Insira o novo nome: ");
                        String nomeNovo = scan.nextLine();
                        System.out.println("Insira o novo status: ");
                        String statusNovo = scan.nextLine();
                        categoria = new Categoria(nomeNovo, statusNovo);
                        categoria.setId(id);
                        catDao.atualizar(categoria);
                        break;
                    case 4:
                        System.out.println("Insira o ID da categoria para deletá-la");
                        id = scan.nextInt();
                        catDao.deletar(id);
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            break;
            default:
                System.out.println("Tabela inexistente!");
            break;
        }

        scan.close();
    }
}
