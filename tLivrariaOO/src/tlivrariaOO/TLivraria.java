/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tlivrariaOO;

import java.util.Scanner;
import model.cliente;
import model.editora;
import model.livro;
import controler.CClientes;//Controle dos Clientes
import controler.CEditoras;
import controler.CLivros;
import controler.CVendaLivros;
import java.util.Date;
import model.vendaLivro;

/**
 *
 * @author jairb
 */
public class TLivraria {

    public static int menu() {
        Scanner ler = new Scanner(System.in);
        System.out.println("-- Menu Livraria --");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("11- atualizar clietes");
        System.out.println("2 - Listar Clientes");
        System.out.println("3 - Cadastrar Editara");
        System.out.println("4 - Listar Editoras");
        System.out.println("5 - Cadastrar Livro");
        System.out.println("6 - Listar Livros");
        System.out.println("7 - Venda Livro");
        System.out.println("8 - Listar Vendas");
        System.out.println("9 - Sair");
        System.out.println("Escolha um opção acima");
        return Integer.parseInt(ler.nextLine());
    }

    /**
     * Projeto Livraria com Orientação a Objetos
     *
     * @param args the command line arguments 2. Sobre cada cliente, é
     * importante manter seu endereço, telefone, CPF e lista dos livros que este
     * cliente já comprou. 2.1 Para cada compra, é importante guardar a data em
     * que esta foi realizada. 3. Um cliente pode comprar muitos livros. Um
     * livro pode ser vendido para mais de um cliente pois geralmente há vários
     * livros em estoque. 4. Um cliente pode ser pessoa física ou jurídica. Se
     * for pessoa jurídica, o seu identificador deve ser o CNPJ. 5. A livraria
     * compra livros de editoras. 6. Sobre as editoras, a livraria precisa de
     * seu código, endereço, telefone de contato, e o nome de seu gerente. 7.
     * Cada cliente tem um código único. 8. Deve-se manter um cadastro sobre
     * cada livro na livraria. Para cada livro, é importante armazenar o nome do
     * autor, assunto, editora, ISBN e a quantidade dos livros em estoque. 9.
     * Editoras diferentes não fornecem o mesmo tipo de livro. Padrão MVC -
     * Model, View, Controler | Classe Cliente, Telas, Classe Repósitório
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ler = new Scanner(System.in);
        CClientes cadClientes = new CClientes();// Repositório de Clientes
        CEditoras cadEditoras = new CEditoras();// Repositório de Clientes
        CLivros cadLivros = new CLivros();
        CVendaLivros cadVendaLivros = new CVendaLivros();

        Boolean sys = true, opC;
        int opM = 0;

        while (sys) {
            try {
                opM = menu();
            } catch (Exception e) {
                System.out.println("erro: " + e + "\nOpção Inválida!");
            }
            switch (opM) {
                case 1:
                    System.out.println("-- Cadastro de Clientes --");
                    opC = true;
                    boolean doc=false;
                    while (opC) {
                        cliente cli = new cliente();
                        cli.setIdCliente(cadClientes.addClientes());
                        System.out.println("Informe o id do Cliente: ");
                        cli.setIdCliente(ler.nextInt());
                        System.out.println("Informe o Nome: ");
                        ler.nextLine();
                        cli.setNomeCliente(ler.nextLine());
                        System.out.println("É pessoa física? \n1 - Sim\n2 - Não");
                        int tPessoa = ler.nextInt();
                        System.out.println("Infome o documento");
                        String cpfCNPJ = ler.next();
                        cliente cliCpfCnpj;
                       
                        do{ cliCpfCnpj = cadClientes.pesqCli (tPessoa, cpfCNPJ);
                        if (tPessoa == 1 && cliCpfCnpj == null){
                            cli.setCpf(cpfCNPJ);
                            cli.setCnpj(null);
                            doc=false;
                        } else if (tPessoa == 2 &&  cliCpfCnpj == null){
                            cli.setCpf(null);
                            cli.setCnpj(cpfCNPJ);
                            doc=false;
                        }
                        if(cadClientes.verificaCliente(cliCpfCnpj.getIdCliente())){
                           System.out.println("Este documento ja existe"
                            +"\n tente novamente");
                           doc=true;
                        }
                        } while(doc);
                        ler.nextLine();
                        System.out.println("Informe o telefone: ");
                        cli.setTelefone(ler.nextLine());
                        System.out.println("Informe o endereço: ");
                        cli.setEndereco(ler.nextLine());
                        cadClientes.addCliente(cli);
                        System.out.println("Cliente " + cli.getNomeCliente() + " foi cadastro com sucesso!");
                         

                        System.out.println("Deseja continuar cadastrando?\n1 - Sim\n2 - Não");
                        int opCC;
                        opCC = ler.nextInt();
                        opC = opCC == 1;
                    }
                        
                    break;
                case 11:
                  boolean update = false;
                  do{
                    System.out.println(" Atualizar cliente");
                    System.out.println("Pesquisa por :\n1 - CPF\n2- CNPJ");
                    int cpfCNPJ = ler.nextInt();
                    System.out.println("informe o valor de pesquisa");
                    String pesq=ler.next();
                    cliente cliUp;
                    cliUp= cadClientes.pesqCli(cpfCNPJ,pesq);
                    if(cliUp.getCpf() !=null || cliUp.getCnpj()!=null){
                        
                    System.out.println("Cliente Selecionao");
                    System.out.println(cliUp.getNomeCliente());
                    System.out.println("nome:");
                    ler.nextLine();
                    cliUp.setNomeCliente(ler.nextLine());
                   
                    } else{
                        System.out.println("Cliente nao econtrado!\nTente novamente");
                        update=true;
                    }
            }while (update);
                           break;
                case 2:
                    System.out.println("Lista de Clientes");
                    for (int i = 0; i < cadClientes.getClientes().size(); i++) {
                        System.out.println("Clientes: " + (i + 1) + " | "
                                + cadClientes.getClientes().get(i));
                    }
                    break;
                case 3:
                    System.out.println("-- Cadastro de Editoras --");
                    opC = true;
                    while (opC) {
                        editora edt = new editora();
                        System.out.println("Informe o id da editora");
                        edt.setIdEditora(ler.nextInt());
                        System.out.println("Informe o nome da editora");
                        ler.nextLine();
                        edt.setNmEditora(ler.nextLine());
                        System.out.println("Informe o telefone");
                        edt.setTelefone(ler.nextLine());
                        System.out.println("Informe o endereço");
                        edt.setEndereco(ler.nextLine());
                        System.out.println("Quem é o Gerente?");
                        edt.setGerente(ler.nextLine());
                        cadEditoras.addEditora(edt);//Cadastro no repositório
                        System.out.println("Editora " + edt.getNmEditora()
                                + " cadastrada com sucesso!");

                        System.out.println("Deseja continuar cadastrando?\n1 - Sim\n2 - Não");
                        int opCC;
                        opCC = ler.nextInt();
                        opC = opCC == 1;
                    }
                    break;
                case 4:
                    System.out.println("Lista de Editoras");
                    for (int i = 0; i < cadEditoras.getEditora().size(); i++) {
                        System.out.println("Editoras: " + (i + 1) + " | "
                                + cadEditoras.getEditora().get(i));
                    }
                    break;
                case 5:
                    System.out.println("-- Cadastro de Livros --");
                    opC = true;
                     CLivros cadLivro=new CLivros();
                    while (opC) {
                        livro liv = new livro();
                        liv.setIdLivro(cadLivro.addLivro());
                        System.out.println("Informe o id do Livro:");
                        liv.setIdLivro(ler.nextInt());
                        System.out.println("Informe o título do Livro:");
                        ler.nextLine();
                        liv.setTitulo(ler.nextLine());
                        System.out.println("Informe o assunto:");
                        liv.setAssunto(ler.nextLine());
                        System.out.println("Informe o Autor:");
                        liv.setAutor(ler.nextLine());
                        System.out.println("Informe o ISBN:");
                        liv.setIsbn(ler.next());
                        System.out.println("Informe o estoque:");
                        liv.setEstoque(ler.nextInt());
                        System.out.println("Informe o preço:");
                        liv.setPreco(ler.nextFloat());
                        boolean edtLivroOK = true;
                        do {
                            System.out.println("Informe o id da Editora");
                            int edtLivro = ler.nextInt();
                            if (cadEditoras.verficaEditora(edtLivro)) {
                                edtLivroOK = false;
                                liv.setIdEditora(edtLivro);
                            } else {
                                System.out.println("Editora inválida, tente novamente!");
                            }
                        } while (edtLivroOK);
                        cadLivros.addLivro(liv);
                        System.out.println("Livro " + liv.getTitulo()
                                + " cadastrado com sucesso!");

                        System.out.println("Deseja continuar cadastrando?\n1 - Sim\n2 - Não");
                        int opCC;
                        opCC = ler.nextInt();
                        opC = opCC == 1;
                    }
                    break;
                case 6:
                    System.out.println("-- Lista de Livros --");
                    for (int i = 0; i < cadLivros.getLivros().size(); i++) {
                        System.out.println("Livro: " + (i + 1) + " | "
                                + cadLivros.getLivros().get(i));
                    }
                    break;
                case 7:
                    System.out.println("-- Cadastro de Vendas --");
                    opC = true;
                    while (opC) {
                        int idCliente, idLivro, qtd;
                        Date dataVenda = new Date(System.currentTimeMillis());

                        boolean verIdCli = true;
                        do {
                            System.out.println("Informe o id do Cliente: ");
                            idCliente = ler.nextInt();
                            if(cadClientes.verificaCliente(idCliente)){
                                verIdCli = false;
                            }else{
                                System.out.println("Cliente inválido, tente novamente!");
                            }
                        } while (verIdCli);
                        
                        boolean verIdLiv= true;
                        do{
                            System.out.println("Informe o id do Livro: ");
                            idLivro = ler.nextInt();
                            if(cadLivros.verficaLivro(idLivro)){
                                verIdLiv=false;
                            }else{
                                System.out.println("Livro incorreto, tente novamente!");
                            }
                        }while(verIdLiv);
                        
                        boolean verEstLiv = true;
                        do{
                            System.out.println("Informe a quantidade compra de livros: ");
                            qtd = ler.nextInt();
                            if(cadLivros.verEstoqueLivro(idLivro, qtd)){
                                verEstLiv = false;
                                cadLivros.atualizaEstoqueLivro(idLivro, qtd);
                            }else{
                                System.out.println("Estoque insuficiente para esta compra."
                                        + "\nTente novamente!");
                            }
                        }while(verEstLiv);
                        
                        vendaLivro vendaLivro = new vendaLivro(idCliente, idLivro, qtd, dataVenda);
                        cadVendaLivros.addVendaLivro(vendaLivro);
                        System.out.println("Venda concluída com sucesso!");

                        System.out.println("Deseja continuar cadastrando?\n1 - Sim\n2 - Não");
                        int opCC;
                        opCC = ler.nextInt();
                        opC = opCC == 1;
                    }
                    break;
                case 8:
                    System.out.println("-- Lista de Venda Livros --");
                    for (int i = 0; i < cadVendaLivros.getVendaLivros().size(); i++) {
                        System.out.println("Livro: " + (i + 1) + " | "
                                + cadVendaLivros.getVendaLivros().get(i));
                    }

                    break;
                case 9:
                    System.out.println("Aplicação encerrada pelo usuário!");
                    sys = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }//fim switch
        }//fim while

    }

}
