import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<PessoaFisica> listaPf = new ArrayList<>();
        PessoaFisica metodoPf = new PessoaFisica();

        ArrayList<PessoaJuridica> listaPj = new ArrayList<>();
        PessoaJuridica metodoPj = new PessoaJuridica();

        System.out.println("Bem vindo ao sistema de cadastro de Pessoas Físicas e Juridicas");

        Scanner leitor = new Scanner(System.in);

        String opcao;

        do {

            System.out.println("Escolha uma opção: 1 - Pessoa Física / 2 - Pessoa Jurídica / 0 - Sair");
            opcao = leitor.nextLine();

            switch (opcao){
                case "1" :

                    String opcaoPF;

                    do {
                        System.out.println("Digite uma opção: 1-Cadastrar PF / 2-Listar PF / 0-Voltar ");
                        opcaoPF = leitor.nextLine();

                        switch (opcaoPF){
                            case "1":

                                PessoaFisica novaPf = new PessoaFisica();
                                Endereco novoEndPF = new Endereco();

                                System.out.println("Digite o nome: ");
                                novaPf.nome = leitor.nextLine();

                                System.out.println("Digite o CPF: ");
                                novaPf.cpf = leitor.nextLine();

                                System.out.println("Digite o rendimento: ");
                                novaPf.rendimento = leitor.nextFloat();

                                System.out.println("Digite a data de nacimento: (dd/mm/aaaa) ");
                                novaPf.dataNasc = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                                Period idade = Period.between(novaPf.dataNasc, LocalDate.now());

                                if (idade.getYears() >= 18){
                                    System.out.println("Idade Válida!");
                                }else {
                                    System.out.println("Idade Inválida!");
                                    break;
                                }

                                System.out.println("Digite o logradouro: ");
                                novoEndPF.logradouro = leitor.next();

                                System.out.println("Digite o numero: ");
                                novoEndPF.numero = leitor.next();

                                System.out.println("Este endereço é comercial? S/N: ");
                                String endCom = leitor.next();
                                if (endCom.equals("S") || endCom.equals("s")){
                                    novoEndPF.endComercial = true;
                                }else {
                                    novoEndPF.endComercial = false;
                                }

                                novaPf.endereco = novoEndPF;

                                listaPf.add(novaPf);

                                System.out.println("Cadastro realizado com sucesso!");

                                break;

                            case "2":

                                if (listaPf.size() > 0){

                                    for (PessoaFisica cadaPf : listaPf) {
                                        System.out.println("Nome: " + cadaPf.nome);
                                        System.out.println("CPF: " + cadaPf.cpf);
                                        System.out.println("Data de Nacimento: " + cadaPf.dataNasc.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Imposto a ser pagado: " + metodoPf.CalcularImposto(cadaPf.rendimento));
                                        System.out.println("Endereço: " + cadaPf.endereco.logradouro + "-" + cadaPf.endereco.numero);

                                        System.out.println();
                                        System.out.println("Aperte ENTER para continuar");
                                        leitor.nextLine();
                                    }

                                }else {
                                    System.out.println("Lista vazia!");
                                }

                                break;

                            case "0":
                                System.out.println("Volta");
                                break;

                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }

                    }while (!opcaoPF.equals("0"));

                    break;

                case "2":
                    String opcaoPj;


                    do {
                        System.out.println("Digite uma opção: 1-Cadastrar PJ / 2-Listar PJ / 0-Voltar");
                        opcaoPj = leitor.nextLine();

                        switch (opcaoPj){
                            case "1":

                                PessoaJuridica novaPj = new PessoaJuridica();
                                Endereco novoEndPj = new Endereco();

                                System.out.println("Digite o nome: ");
                                novaPj.nome = leitor.nextLine();

                                System.out.println("Digite a razão social: ");
                                novaPj.razaoSocial = leitor.nextLine();

                                System.out.println("Digite o CNPJ: ");
                                novaPj.cnpj = leitor.nextLine();

                                System.out.println("Digite o rendimento: ");
                                novaPj.rendimento = leitor.nextFloat();

                                System.out.println("Digite a data de criação da empresa: (dd/mm/aaaa) ");
                                novaPj.dataCriacao = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                                leitor.nextLine();

                                System.out.println("Digite o logradouro: ");
                                novoEndPj.logradouro = leitor.nextLine();

                                System.out.println("Digite o numero: ");
                                novoEndPj.numero = leitor.nextLine();

                                System.out.println("Este endereço é comercial? S/N");
                                String endCom = leitor.next();

                                if (endCom.equals("S") || endCom.equals("s") ){
                                    novoEndPj.endComercial = true;
                                }else {
                                    novoEndPj.endComercial = false;
                                }

                                novaPj.endereco = novoEndPj;
                                listaPj.add(novaPj);

                                System.out.println("Cadastro realizado com sucesso!");

                                break;

                            case "2":
                                if (listaPj.size() > 0){
                                    for (PessoaJuridica cadaPj: listaPj){
                                        System.out.println("Nome: " + cadaPj.nome);
                                        System.out.println("Razão social: " + cadaPj.razaoSocial);
                                        System.out.println("CNPJ: " + cadaPj.cnpj);
                                        System.out.println("Data de criação: " + cadaPj.dataCriacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Imposto a ser pago: " + metodoPj.CalcularImpostoPj(cadaPj.rendimento));
                                        System.out.println("Endereço: " + cadaPj.endereco.logradouro + "-" + cadaPj.endereco.numero);
                                        System.out.println("Comercial: " + (cadaPj.endereco.endComercial?"Sim":"Não" ));
                                        System.out.println();
                                        System.out.println("Aperte ENTER para continuar");
                                        leitor.nextLine();
                                    }
                                }
                                break;

                            case "0":
                                System.out.println("Sair do sistema...");
                                break;

                            default:
                                System.out.println("Opção inválida");
                                break;
                        }

                    }while (!opcaoPj.equals("0"));

                    break;

                case "0":
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } while (!opcao.equals("0"));
    }
}