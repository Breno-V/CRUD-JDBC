import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ProdutoDAO dao = new ProdutoDAO();
        CategoriaDAO catDao = new CategoriaDAO();
        Scanner scan = new Scanner(System.in);
        int tabela;

        System.out.println("======================TABELAS========================");
        System.out.println("\n 1 - Produtos  \n 2 - Categorias\n");
        System.out.println("=====================================================");
        tabela = scan.nextInt();
        scan.nextLine();

        switch (tabela) {
            case 1:
                System.out.println("======================OPÇÕES===========================");
                System.out.println("\n1 - Inserir | 2 - Listar | 3 - Atualizar | 4 - Deletar\n");
                System.out.println("=======================================================");
                int op = scan.nextInt();
                scan.nextLine(); // limpa o buffer

                switch (op) {
                    case 1:
                        System.out.println("OPÇÃO ESCOLHIDA: INSERIR");
                        System.out.print("Insira o nome: ");
                        String nome = scan.nextLine();
                        System.out.print("Insira o preço: ");
                        double preco = scan.nextDouble();
                        Produto produto = new Produto(nome, preco);
                        dao.inserir(produto);
                        System.out.println("PRODUTO INSERIDO COM SUCESSO!");
                        break;
                    case 2:
                        System.out.println("OPÇÃO ESCOLHIDA: LISTAR");
                        for (Produto prod : dao.listar()) {
                            System.out.println(
                                    "ID: " + prod.getId() + " - " +
                                            "NOME: " + prod.getNome() + " - PREÇO: R$" +
                                            prod.getPreco() + "\n");
                        }
                        System.out.println("PRODUTO LISTADO COM SUCESSO");
                        break;
                    case 3:
                        System.out.println("OPÇÃO ESCOLHIDA: ATUALIZAR\n");
                        System.out.print("Insira o ID do produto: ");
                        int id = scan.nextInt();
                        scan.nextLine();
                        System.out.print("Insira o novo nome: ");
                        String nomeNovo = scan.nextLine();
                        System.out.print("Insira o novo preço: ");
                        Double precoNovo = scan.nextDouble();
                        produto = new Produto(nomeNovo, precoNovo);
                        produto.setId(id);
                        dao.atualizar(produto);
                        System.out.println("PRODUTO ATUALIZADO COM SUCESSO");
                        break;
                    case 4:
                        System.out.println("OPÇÃO ESCOLHIDA: DELETAR");
                        for (Produto prod : dao.listar()) {
                            System.out.println(
                                    "ID: " + prod.getId() + " - " +
                                            "NOME: " + prod.getNome() + " - PREÇO: R$" +
                                            prod.getPreco() + "\n");
                        }
                        System.out.print("Insira o ID do produto para deletá-lo: ");
                        id = scan.nextInt();
                        dao.deletar(id);
                        System.out.println("PRODUTO DELETADO COM SUCESSO");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
                break;
            case 2:
                System.err.println("======================OPÇÕES===========================");
                System.out.println("\n1 - Inserir | 2 - Listar | 3 - Atualizar | 4 - Deletar\n");
                System.err.println("=======================================================");
                int operacao = scan.nextInt();
                scan.nextLine(); // limpa o buffer

                switch (operacao) {
                    case 1:
                        System.out.println("OPÇÃO ESCOLHIDA: INSERIR");
                        System.out.print("Insira o nome: ");
                        String nome = scan.nextLine();
                        System.out.print("Insira o status (Ativo = S, Inativo = N): ");
                        String ativo = scan.nextLine();
                        Categoria categoria = new Categoria(nome, ativo);
                        catDao.inserir(categoria);
                        System.out.println("CATEGORIA INSERIDA COM SUCESSO!");
                        break;
                    case 2:
                        for (Categoria cat : catDao.listar()) {
                            System.out.println(
                                    "ID: " + cat.getId() + " - NOME: " +
                                            cat.getNome() + " - STATUS: " +
                                            cat.getAtivo() + "\n");
                        }
                        System.out.println("CATEGORIA LISTADA COM SUCESSO");
                        break;
                    case 3:
                        System.out.println("OPÇÃO ESCOLHIDA: ATUALIZAR\n");
                        System.out.print("Insira o ID da categoria: ");
                        int id = scan.nextInt();
                        scan.nextLine();
                        System.out.print("Insira o novo nome: ");
                        String nomeNovo = scan.nextLine();
                        System.out.print("Insira o novo status: ");
                        String statusNovo = scan.nextLine();
                        categoria = new Categoria(nomeNovo, statusNovo);
                        categoria.setId(id);
                        catDao.atualizar(categoria);
                        System.out.println("CATEGORIA ATUALIZADA COM SUCESSO");
                        break;
                    case 4:
                        System.out.println("OPÇÃO ESCOLHIDA: DELETAR\n");
                        for (Categoria cat : catDao.listar()) {
                            System.out.println(
                                    "ID: " + cat.getId() + " - NOME: " +
                                            cat.getNome() + " - STATUS: " +
                                            cat.getAtivo() + "\n");
                        }
                        System.out.print("Insira o ID da categoria para deletá-la: ");
                        id = scan.nextInt();
                        catDao.deletar(id);
                        System.out.println("CATEGORIA DELETADA COM SUCESSO");
                        break;
                    default:
                        System.out.println("===============");
                        System.out.println("OPÇÃO INVÁLIDA!");
                        System.out.println("===============");
                        break;
                }
                break;
            default:
                System.out.println("===================");
                System.out.println("TABELA INEXISTENTE!");
                System.out.println("===================");
                break;
        }

        scan.close();
    }
}
