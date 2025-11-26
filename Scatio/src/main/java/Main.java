//import animais.*;
//import criacaoERacao.*;
import animais.Ave;
import animais.Bovino;
import animais.InterfaceAnimal;
import criacaoERacao.*;
import dadosEPrintes.*;

import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        SingletonDados singleton = SingletonDados.getInstance();
        String option;
        char verLista;
        String[] infoConta = {"", "", ""}; // Nome, E-mail, Senha
        char logado = 'n';
        Racao racao = null;
        InterfaceAnimal animal = null;
        InterfaceCriacoes factory = null;
        InterfaceTiposCriacoes criacao = null;
        String passageiro = "";

        /*
                     ,--.                             ,---.'|
                   ,--.'|                             |   | :
               ,--,:  : |                             :   : |                                          ,---,
            ,`--.'`|  ' :              ,---.          |   ' :      ,---.                             ,---.'|   ,---.
            |   :  :  | |             '   ,'\         ;   ; '     '   ,'\   ,----._,.                |   | :  '   ,'\
            :   |   \ | :  ,--.--.   /   /   |        '   | |__  /   /   | /   /  ' /   ,--.--.      |   | | /   /   |
            |   : '  '; | /       \ .   ; ,. :        |   | :.'|.   ; ,. :|   :     |  /       \   ,--.__| |.   ; ,. :
            '   ' ;.    ;.--.  .-. |'   | |: :        '   :    ;'   | |: :|   | .\  . .--.  .-. | /   ,'   |'   | |: :
            |   | | \   | \__\/: . .'   | .; :        |   |  ./ '   | .; :.   ; ';  |  \__\/: . ..   '  /  |'   | .; :
            '   : |  ; .' ," .--.; ||   :    |        ;   : ;   |   :    |'   .   . |  ," .--.; |'   ; |:  ||   :    |
            |   | '`--'  /  /  ,.  | \   \  /         |   ,/     \   \  /  `---`-'| | /  /  ,.  ||   | '/  ' \   \  /
            '   : |     ;  :   .'   \ `----'          '---'       `----'   .'__/\_: |;  :   .'   \   :    :|  `----'
            ;   |.'     |  ,     .-./                                      |   :    :|  ,     .-./\   \  /
            '---'        `--`---'                                           \   \  /  `--`---'     `----'
                                                                             `--`-'
        */
        Printes.espaco();
        while (true) {
            outer:
            if (logado == 'n') {
                Printes.menuPrincipal();
                Printes.linha();
                System.out.println("•[1] Logar"); // Falta terminar de completar a parte de logar
                System.out.println("•[2] Criar sítio"); // Falta terminar a parte de conseguir criar o sítio
                System.out.println("•[0] Sair"); // FEITO
                Printes.linha();
                System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                option = input.next();

                if (option.equals("1")) {
                    Printes.espaco();
                    infoConta = new String[]{"", "", ""};
                    while (true) {
                        Printes.menuLogin();
                        Printes.linha();
                        System.out.print("•[1] Nome do sítio: @");
                        System.out.printf("%s\n", infoConta[0]);
                        System.out.print("•[2] Senha: ");
                        System.out.printf("%s\n", infoConta[2]);
                        System.out.println("•[3] Logar");
                        System.out.println("•[0] Voltar");
                        Printes.linha();
                        System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                        option = input.next();
                        input.nextLine();

                        if (option.equals("1")) {
                            System.out.print("•[1] <<< DIGITE O NOME DO SÍTIO: ");
                            option = input.nextLine();
                            System.out.println("passou");
                            infoConta[0] = SingletonDados.conferirNomeSitio(infoConta[0], option);
                        } else if (option.equals("2")) {
                            System.out.print("•[2] <<< DIGITE A SENHA DO SÍTIO: ");
                            option = input.nextLine();
                            infoConta[2] = SingletonDados.conferirSenhaSitio(infoConta[2], option);
                        } else if (option.equals("3")) {
                            logado = singleton.logarNoSitio(infoConta);
                            if (logado == 'l') {
                                singleton.setNomeSitio(infoConta[0]);
                                singleton.setEmailSitio(infoConta[1]);
                                singleton.setSenhaSitio(infoConta[2]);
                                Printes.espaco();
                                break outer;
                            }

                        } else if (option.equals("0")) {
                            Printes.espaco();
                            break;
                        }
                    }
                } else if (option.equals("2")) {
                    Printes.espaco();
                    infoConta = new String[]{"", "", ""};
                    while (true) {
                        Printes.menuCriar();
                        Printes.linha();
                        System.out.print("•[1] Nome do sítio: @");
                        System.out.printf("%s\n", infoConta[0]);
                        System.out.print("•[2] E-mail: ");
                        System.out.printf("%s\n", infoConta[1]);
                        System.out.print("•[3] Senha: ");
                        System.out.printf("%s\n", infoConta[2]);
                        System.out.println("•[4] Criar");
                        System.out.println("•[0] Voltar");
                        Printes.linha();
                        System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                        option = input.next();
                        input.nextLine();

                        if (option.equals("1")) {
                            System.out.print("•[1] <<< DIGITE O NOME DO SÍTIO: ");
                            option = input.nextLine();
                            infoConta[0] = SingletonDados.conferirNomeSitio(infoConta[0], option);
                        } else if (option.equals("2")) {
                            System.out.print("•[2] <<< DIGITE O E-MAIL DO SÍTIO: ");
                            option = input.nextLine();
                            infoConta[1] = SingletonDados.conferiremailSitio(infoConta[1], option);
                        } else if (option.equals("3")) {
                            System.out.print("•[3] <<< DIGITE A SENHA DO SÍTIO: ");
                            option = input.nextLine();
                            infoConta[2] = SingletonDados.conferirSenhaSitio(infoConta[2], option);
                        } else if (option.equals("4")) {
                            logado = singleton.criarSitio(infoConta);
                            if (logado == 'l') {
                                singleton.setNomeSitio(infoConta[0]);
                                singleton.setEmailSitio(infoConta[1]);
                                singleton.setSenhaSitio(infoConta[2]);
                            }
                            break outer;
                        } else if (option.equals("0")) {
                            break;
                        }

                    }
                } else if (option.equals("0")) {
                    break;
                } else {
                    Printes.espaco();
                    Printes.opcaoInvalida();
                }




            /*
                   ,--,
                ,---.'|
                |   | :
                :   : |                                          ,---,
                |   ' :      ,---.                             ,---.'|   ,---.
                ;   ; '     '   ,'\   ,----._,.                |   | :  '   ,'\
                '   | |__  /   /   | /   /  ' /   ,--.--.      |   | | /   /   |
                |   | :.'|.   ; ,. :|   :     |  /       \   ,--.__| |.   ; ,. :
                '   :    ;'   | |: :|   | .\  . .--.  .-. | /   ,'   |'   | |: :
                |   |  ./ '   | .; :.   ; ';  |  \__\/: . ..   '  /  |'   | .; :
                ;   : ;   |   :    |'   .   . |  ," .--.; |'   ; |:  ||   :    |
                |   ,/     \   \  /  `---`-'| | /  /  ,.  ||   | '/  ' \   \  /
                '---'       `----'   .'__/\_: |;  :   .'   \   :    :|  `----'
                                     |   :    :|  ,     .-./\   \  /
                                      \   \  /  `--`---'     `----'
                                       `--`-'
            */
            } else if (logado == 'l') {
                Printes.menuPrincipal();
                Printes.linha();
                System.out.printf("•[1] Log out de @%s\n", singleton.getNomeSitio()); // Feito
                System.out.println("•[2] Criações"); // Falta terminar
                System.out.println("•[3] Animais"); // Feito
                System.out.println("•[4] Rações"); // Feito
                System.out.println("•[0] Sair"); // Feito
                Printes.linha();
                System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                option = input.next();

                if (option.equals("1")) {
                    logado = 'n';
                    infoConta = new String[] {"", "", ""};
                    singleton.setNomeSitio("");
                    singleton.setEmailSitio("");
                    singleton.setSenhaSitio("");
                    Printes.espaco();
                    break outer;
                    /*
  ,----..
 /   /   \            ,--,
|   :     :  __  ,-.,--.'|                          ,---.
.   |  ;. /,' ,'/ /||  |,                          '   ,'\             .--.--.
.   ; /--` '  | |' |`--'_      ,--.--.     ,---.  /   /   |   ,---.   /  /    '
;   | ;    |  |   ,',' ,'|    /       \   /     \.   ; ,. :  /     \ |  :  /`./
|   : |    '  :  /  '  | |   .--.  .-. | /    / ''   | |: : /    /  ||  :  ;_
.   | '___ |  | '   |  | :    \__\/: . ..    ' / '   | .; :.    ' / | \  \    `.
'   ; : .'|;  : |   '  : |__  ," .--.; |'   ; :__|   :    |'   ;   /|  `----.   \
'   | '/  :|  , ;   |  | '.'|/  /  ,.  |'   | '.'|\   \  / '   |  / | /  /`--'  /
|   :    /  ---'    ;  :    ;  :   .'   \   :    : `----'  |   :    |'--'.     /
 \   \ .'           |  ,   /|  ,     .-./\   \  /           \   \  /   `--'---'
  `---`              ---`-'  `--`---'     `----'             `----'
  */
                } else if (option.equals("2")) { // Criações [l.2.*]
                    verLista = ' ';
                    Printes.espaco();
                    /*
• [l.2.1] (Deixar de) Ver lista de criações de aves
• [l.2.2] (Deixar de) Ver lista de criações de bovinos
• [l.2.3] Adicionar nova criação de animais
• [l.2.4] Selecionar uma criação para alteração
                    */
                    while (true) {
                        Printes.criacoes();
                        Printes.linha();
                        if (verLista == ' ') { // Feito
                            System.out.println("•[1] Ver lista de criações de aves");
                            System.out.println("•[2] Ver lista de criações de bovinos");
                        } else if (verLista == 'a') {
                            singleton.listas("criacoesAves");
                            System.out.println("•[1] Deixar de ver lista de criações de aves");
                            System.out.println("•[2] Ver lista de criações de bovinos");
                        } else if (verLista == 'b') {
                            singleton.listas("criacoesBovinos");
                            System.out.println("•[1] Ver lista de criações de aves");
                            System.out.println("•[2] Deixar de ver lista de criações de bovinos");
                        }
                        System.out.println("•[3] Adicionar nova criação de aves"); //
                        System.out.println("•[4] Adicionar nova criação de bovinos"); //
                        System.out.println("•[5] Selecionar uma criação para alteração"); //
                        System.out.println("•[0] Voltar"); // Feito
                        Printes.linha();
                        System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                        option = input.next();

                        if (option.equals("1")) {
                            Printes.espaco();
                            if (verLista == 'a') {
                                verLista = ' ';
                            } else {
                                verLista = 'a';
                            }
                        } else if (option.equals("2")) {
                            Printes.espaco();
                            if (verLista == 'b') {
                                verLista = ' ';
                            } else {
                                verLista = 'b';
                            }
                        } else if (option.equals("3")) {
                            input.nextLine();

                            System.out.println("(TIPOS DE CRIAÇÕES: MATRIZ - DESMAMADO - REPRODUTOR)");
                            System.out.print("•[3] <<< DIGITE O NOME DO TIPO DE CRIAÇÃO QUE VOCÊ QUER CRIAR: ");
                            passageiro = input.nextLine();

                            factory = new CriacaoAveFactory();

                            if (!passageiro.toLowerCase().equals("matriz") && !passageiro.toLowerCase().equals("desmamado") && !passageiro.toLowerCase().equals("reprodutor")) {
                                Printes.espaco();
                                Printes.opcaoInvalida();
                                factory = null;
                            } else if (passageiro.toLowerCase().equals("matriz")) {
                                criacao = factory.criarMatriz();
                                Printes.espaco();
                            } else if (passageiro.toLowerCase().equals("desmamado")) {
                                criacao = factory.criarDesmamado();
                                Printes.espaco();
                            } else if (passageiro.toLowerCase().equals("reprodutor")) {
                                criacao = factory.criarReprodutor();
                                Printes.espaco();
                            }

                            verLista = ' ';


                            while (factory != null) {
                                Printes.adicionarNovaCriacaoDeAves();
                                Printes.linha();
                                if (verLista == 'r') {
                                    singleton.listas("racoes");
                                } else if (verLista == 'c') {
                                    singleton.listas("aves");
                                }

                                System.out.println("•[1] Esconder lista");
                                System.out.printf("•[2] Definir nome do setor: %s\n", criacao.getSetor());

                                if (criacao.getRacao() != null && verLista != 'r') { // r
                                    System.out.printf("•[3] Alterar ração escolhida: %s\n", criacao.nomeRacao());

                                } else if (criacao.getRacao() != null && verLista == 'r') {
                                    System.out.printf("•[3] Alterar ração escolhida: %s\n", criacao.nomeRacao());

                                } else if (verLista != 'r' && criacao.getRacao() == null) {
                                    System.out.println("•[3] Ver lista de ração");

                                } else if (verLista == 'r' && criacao.getRacao() == null) {
                                    System.out.println("•[3] Escolher ração");
                                }

                                System.out.printf("•[4] Definir espécie da criação: %s\n", criacao.getEspecie());
                                System.out.printf("•[5] Definir raça da criação: %s\n", criacao.getRaca());
                                System.out.println((verLista == 'c') ? "•[6] Escolher aves para colocar na criação" : "•[6] Ver lista de aves para colocar na criação "); // c
                                System.out.println((verLista == 'c') ? "•[7] Excluir ave da criação" : "•[7] Ver lista de aves para excluir da criação ");
                                System.out.println("•[8] Serializar");
                                System.out.println("•[0] Voltar");
                                Printes.linha();
                                System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                                option = input.next();
                                input.nextLine();

                                if (option.equals("1")) {
                                    Printes.espaco();
                                    verLista = ' ';

                                } else if (option.equals("2")) {
                                    System.out.print("•[2] <<< DIGITE O NOME DO SETOR: ");
                                    passageiro = input.nextLine();
                                    criacao.setSetor(passageiro.toLowerCase(), singleton.getNomeSitio());
                                } else if (option.equals("3")) {
                                    if (verLista != 'r') {
                                        Printes.espaco();
                                        verLista = 'r';
                                    } else {
                                        System.out.print("•[3] <<< DIGITE O NOME DA RAÇÃO QUE VOCÊ DESEJA COLOCAR, OU DIGITE 0 PARA CANCELAR: ");
                                        passageiro = input.nextLine();

                                        if (!passageiro.equals("0")) {
                                            racao = singleton.desserializarRacao(passageiro.toLowerCase());
                                            if (racao != null) criacao.setRacao(racao);
                                        } else {
                                            Printes.espaco();
                                        }
                                    }

                                } else if (option.equals("4")) {
                                    System.out.print("•[4] <<< DIGITE A ESPÉCIE DA CRIAÇÃO: ");
                                    passageiro = input.nextLine();
                                    criacao.setEspecie(passageiro.toLowerCase());
                                } else if (option.equals("5")) {
                                    System.out.print("•[5] <<< DIGITE A RAÇA DA CRIAÇÃO: ");
                                    passageiro = input.nextLine();
                                    criacao.setRaca(passageiro.toLowerCase());
                                } else if (option.equals("6")) {
                                    if (verLista != 'c') {
                                        Printes.espaco();
                                        verLista = 'c';
                                    } else {
                                        System.out.print("•[6] <<< DIGITE O NOME DA AVE QUE VOCÊ DESEJA COLOCAR NA CRIAÇÃO, OU DIGITE 0 PARA CANCELAR: ");
                                        passageiro = input.nextLine();

                                        if (!passageiro.equals("0")) {
                                            animal = singleton.desserializarAnimal(passageiro.toLowerCase(), "aves");
                                            if (animal != null) {
                                                criacao.adicionarNaCriacao(animal);
                                            }
                                        }
                                    }
                                } else if (option.equals("7")) {
                                    if (verLista != 'c') {
                                        Printes.espaco();
                                        verLista = 'c';
                                    } else {
                                        System.out.print("•[7] <<< DIGITE O NOME DA AVE QUE VOCÊ DESEJA EXCLUIR DA CRIAÇÃO, OU DIGITE 0 PARA CANCELAR: ");
                                        passageiro = input.nextLine();

                                        if (!passageiro.equals("0")) {
                                            animal = singleton.desserializarAnimal(passageiro.toLowerCase(), "aves");
                                            if (animal != null) {
                                                criacao.retirarDaCriacao(animal);
                                            }
                                        }
                                    }
                                } else if (option.equals("8")) {
                                    if (criacao.serializar(singleton.getNomeSitio())) {
                                        verLista = ' ';
                                        break;
                                    }
                                } else if (option.equals("0")) {
                                    Printes.espaco();
                                    racao = null;
                                    animal = null;
                                    criacao = null;
                                    factory = null;
                                    verLista = ' ';
                                    break;
                                } else {
                                    Printes.espaco();
                                    Printes.opcaoInvalida();
                                }
                            }
                        } else if (option.equals("4")) {
                            input.nextLine();

                            System.out.println("(TIPOS DE CRIAÇÕES: MATRIZ - DESMAMADO - REPRODUTOR)");
                            System.out.print("•[3] <<< DIGITE O NOME DO TIPO DE CRIAÇÃO QUE VOCÊ QUER CRIAR: ");
                            passageiro = input.nextLine();

                            factory = new CriacaoBovinoFactory();

                            if (!passageiro.toLowerCase().equals("matriz") && !passageiro.toLowerCase().equals("desmamado") && !passageiro.toLowerCase().equals("reprodutor")) {
                                Printes.espaco();
                                Printes.opcaoInvalida();
                                factory = null;
                            } else if (passageiro.toLowerCase().equals("matriz")) {
                                criacao = factory.criarMatriz();
                                Printes.espaco();
                            } else if (passageiro.toLowerCase().equals("desmamado")) {
                                criacao = factory.criarDesmamado();
                                Printes.espaco();
                            } else if (passageiro.toLowerCase().equals("reprodutor")) {
                                criacao = factory.criarReprodutor();
                                Printes.espaco();
                            }

                            verLista = ' ';


                            while (factory != null) {
                                Printes.adicionarNovaCriacaoDeBovinos();
                                Printes.linha();
                                if (verLista == 'r') {
                                    singleton.listas("racoes");
                                } else if (verLista == 'c') {
                                    singleton.listas("bovinos");
                                }

                                System.out.println("•[1] Esconder lista");
                                System.out.printf("•[2] Definir nome do setor: %s\n", criacao.getSetor());

                                if (criacao.getRacao() != null && verLista != 'r') { // r
                                    System.out.printf("•[3] Alterar ração escolhida: %s\n", criacao.nomeRacao());

                                } else if (criacao.getRacao() != null && verLista == 'r') {
                                    System.out.printf("•[3] Alterar ração escolhida: %s\n", criacao.nomeRacao());

                                } else if (verLista != 'r' && criacao.getRacao() == null) {
                                    System.out.println("•[3] Ver lista de ração");

                                } else if (verLista == 'r' && criacao.getRacao() == null) {
                                    System.out.println("•[3] Escolher ração");
                                }

                                System.out.printf("•[4] Definir espécie da criação: %s\n", criacao.getEspecie());
                                System.out.printf("•[5] Definir raça da criação: %s\n", criacao.getRaca());
                                System.out.println((verLista == 'c') ? "•[6] Escolher bovinos para colocar na criação" : "•[6] Ver lista de bovinos para colocar na criação "); // c
                                System.out.println((verLista == 'c') ? "•[7] Excluir bovino da criação" : "•[7] Ver lista de bovinos para excluir da criação ");
                                System.out.println("•[8] Serializar");
                                System.out.println("•[0] Voltar");
                                Printes.linha();
                                System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                                option = input.next();
                                input.nextLine();

                                if (option.equals("1")) {
                                    Printes.espaco();
                                    verLista = ' ';

                                } else if (option.equals("2")) {
                                    System.out.print("•[2] <<< DIGITE O NOME DO SETOR: ");
                                    passageiro = input.nextLine();
                                    criacao.setSetor(passageiro.toLowerCase(), singleton.getNomeSitio());
                                } else if (option.equals("3")) {
                                    if (verLista != 'r') {
                                        Printes.espaco();
                                        verLista = 'r';
                                    } else {
                                        System.out.print("•[3] <<< DIGITE O NOME DA RAÇÃO QUE VOCÊ DESEJA COLOCAR, OU DIGITE 0 PARA CANCELAR: ");
                                        passageiro = input.nextLine();

                                        if (!passageiro.equals("0")) {
                                            racao = singleton.desserializarRacao(passageiro.toLowerCase());
                                            if (racao != null) criacao.setRacao(racao);
                                        } else {
                                            Printes.espaco();
                                        }
                                    }

                                } else if (option.equals("4")) {
                                    System.out.print("•[4] <<< DIGITE A ESPÉCIE DA CRIAÇÃO: ");
                                    passageiro = input.nextLine();
                                    criacao.setEspecie(passageiro.toLowerCase());
                                } else if (option.equals("5")) {
                                    System.out.print("•[5] <<< DIGITE A RAÇA DA CRIAÇÃO: ");
                                    passageiro = input.nextLine();
                                    criacao.setRaca(passageiro.toLowerCase());
                                } else if (option.equals("6")) {
                                    if (verLista != 'c') {
                                        Printes.espaco();
                                        verLista = 'c';
                                    } else {
                                        System.out.print("•[6] <<< DIGITE O NOME DO BOVINO QUE VOCÊ DESEJA COLOCAR NA CRIAÇÃO, OU DIGITE 0 PARA CANCELAR: ");
                                        passageiro = input.nextLine();

                                        if (!passageiro.equals("0")) {
                                            animal = singleton.desserializarAnimal(passageiro.toLowerCase(), "bovinos");
                                            if (animal != null) {
                                                criacao.adicionarNaCriacao(animal);
                                            }
                                        }
                                    }
                                } else if (option.equals("7")) {
                                    if (verLista != 'c') {
                                        Printes.espaco();
                                        verLista = 'c';
                                    } else {
                                        System.out.print("•[7] <<< DIGITE O NOME DO BOVINO QUE VOCÊ DESEJA EXCLUIR DA CRIAÇÃO, OU DIGITE 0 PARA CANCELAR: ");
                                        passageiro = input.nextLine();

                                        if (!passageiro.equals("0")) {
                                            animal = singleton.desserializarAnimal(passageiro.toLowerCase(), "bovinos");
                                            if (animal != null) {
                                                criacao.retirarDaCriacao(animal);
                                            }
                                        }
                                    }
                                } else if (option.equals("8")) {
                                    if (criacao.serializar(singleton.getNomeSitio())) {
                                        verLista = ' ';
                                        break;
                                    }
                                } else if (option.equals("0")) {
                                    Printes.espaco();
                                    racao = null;
                                    animal = null;
                                    criacao = null;
                                    factory = null;
                                    verLista = ' ';
                                    break;
                                } else {
                                    Printes.espaco();
                                    Printes.opcaoInvalida();
                                }
                            }
                        } else if (option.equals("5")) { // []

                            input.nextLine();
                            if (verLista == ' ') {
                                Printes.espaco();
                                System.out.println("--> ABRA A LISTA DO TIPO DE CRIAÇÃO QUE VOCÊ DESEJA SELECIONAR.");

                            } else if (verLista == 'a') {
                                System.out.println("(PARA SELECIONAR UMA CRIAÇÃO DE BOVINO ABRA A LISTA DE CRIAÇÕES DE BOVINOS)");
                                System.out.print("•[5] <<< DIGITE O NOME DA CRIAÇÃO DE AVES QUE VOCÊ DESEJA ALTERAR, OU DIGITE 0 PARA CANCELAR: ");
                                passageiro = input.nextLine();

                                if (!passageiro.equals("0")) {

                                    criacao = singleton.desserializarCriacao(passageiro.toLowerCase(), "criacoesAves");

                                    if (criacao != null) {
                                        Printes.espaco();
                                        verLista = ' ';
                                        while (true) {
                                            Printes.alterarCriacao();
                                            Printes.linha();
                                            if (verLista == 'r') {
                                                singleton.listas("racoes");
                                            } else if (verLista == 'c') {
                                                singleton.listas("aves");
                                            }

                                            System.out.println("•[1] Esconder lista");
                                            System.out.printf("•[2] Alterar nome do setor: %s\n", criacao.getSetor());

                                            if (criacao.getRacao() != null && verLista != 'r') { // r
                                                System.out.printf("•[3] Alterar ração escolhida: %s\n", criacao.nomeRacao());

                                            } else if (criacao.getRacao() != null && verLista == 'r') {
                                                System.out.printf("•[3] Alterar ração escolhida: %s\n", criacao.nomeRacao());

                                            } else if (verLista != 'r' && criacao.getRacao() == null) {
                                                System.out.println("•[3] Ver lista de ração");

                                            } else if (verLista == 'r' && criacao.getRacao() == null) {
                                                System.out.println("•[3] Escolher ração");
                                            }

                                            System.out.printf("•[4] Alterar espécie da criação: %s\n", criacao.getEspecie());
                                            System.out.printf("•[5] Alterar raça da criação: %s\n", criacao.getRaca());
                                            System.out.println((verLista == 'c') ? "•[6] Escolher aves para colocar na criação" : "•[6] Ver lista de aves para colocar na criação "); // c
                                            System.out.println((verLista == 'c') ? "•[7] Excluir ave da criação" : "•[7] Ver lista de aves para excluir da criação ");
                                            System.out.println("•[8] Serializar");
                                            System.out.println("•[9] Excluir serialização");
                                            System.out.println("•[0] Voltar");
                                            Printes.linha();
                                            System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                                            option = input.next();
                                            input.nextLine();

                                            if (option.equals("1")) {
                                                Printes.espaco();
                                                verLista = ' ';
                                            } else if (option.equals("2")) {
                                                System.out.print("•[2] <<< DIGITE O NOME DO SETOR: ");
                                                passageiro = input.nextLine();
                                                criacao.setSetor(passageiro.toLowerCase(), singleton.getNomeSitio());
                                            } else if (option.equals("3")) {
                                                if (verLista != 'r') {
                                                    Printes.espaco();
                                                    verLista = 'r';
                                                } else {
                                                    System.out.print("•[3] <<< DIGITE O NOME DA RAÇÃO QUE VOCÊ DESEJA COLOCAR, OU DIGITE 0 PARA CANCELAR: ");
                                                    passageiro = input.nextLine();

                                                    if (!passageiro.equals("0")) {
                                                        racao = singleton.desserializarRacao(passageiro.toLowerCase());
                                                        if (racao != null) criacao.setRacao(racao);
                                                    } else {
                                                        Printes.espaco();
                                                    }
                                                }
                                            } else if (option.equals("4")) {
                                                System.out.print("•[4] <<< DIGITE A ESPÉCIE DA CRIAÇÃO: ");
                                                passageiro = input.nextLine();
                                                criacao.setEspecie(passageiro.toLowerCase());
                                            } else if (option.equals("5")) {
                                                System.out.print("•[5] <<< DIGITE A RAÇA DA CRIAÇÃO: ");
                                                passageiro = input.nextLine();
                                                criacao.setRaca(passageiro.toLowerCase());
                                            } else if (option.equals("6")) {

                                                if (verLista != 'c') {
                                                    Printes.espaco();
                                                    verLista = 'c';
                                                } else {
                                                    System.out.print("•[6] <<< DIGITE O NOME DA AVE QUE VOCÊ DESEJA COLOCAR NA CRIAÇÃO, OU DIGITE 0 PARA CANCELAR: ");
                                                    passageiro = input.nextLine();

                                                    if (!passageiro.equals("0")) {
                                                        animal = singleton.desserializarAnimal(passageiro.toLowerCase(), "aves");
                                                        if (animal != null) {
                                                            criacao.adicionarNaCriacao(animal);
                                                        }
                                                    }
                                                }
                                            } else if (option.equals("7")) {
                                                if (verLista != 'c') {
                                                    Printes.espaco();
                                                    verLista = 'c';
                                                } else {
                                                    System.out.print("•[7] <<< DIGITE O NOME DA AVE QUE VOCÊ DESEJA EXCLUIR DA CRIAÇÃO, OU DIGITE 0 PARA CANCELAR: ");
                                                    passageiro = input.nextLine();

                                                    if (!passageiro.equals("0")) {
                                                        animal = singleton.desserializarAnimal(passageiro.toLowerCase(), "aves");
                                                        if (animal != null) {
                                                            criacao.retirarDaCriacao(animal);
                                                        }
                                                    }
                                                }

                                            } else if (option.equals("8")) {
                                                if (criacao.serializar(singleton.getNomeSitio())) {
                                                    verLista = ' ';
                                                    break;
                                                }
                                            } else if (option.equals("9")) {
                                                if (singleton.excluirSerializacao("criacoesAves", criacao.getSetor())) {
                                                    break;
                                                }
                                            } else if (option.equals("0")) {
                                                Printes.espaco();
                                                break;
                                            } else {
                                                Printes.espaco();
                                                Printes.opcaoInvalida();
                                            }
                                        }
                                    }
                                }
                            } else if (verLista == 'b') {
                                System.out.println("(PARA SELECIONAR UMA CRIAÇÃO DE AVE ABRA A LISTA DE CRIAÇÕES DE AVES)");
                                System.out.print("•[5] <<< DIGITE O NOME DA CRIAÇÃO DE BOVINOS QUE VOCÊ DESEJA ALTERAR, OU DIGITE 0 PARA CANCELAR: ");
                                passageiro = input.nextLine();

                                if (!passageiro.equals("0")) {

                                    criacao = singleton.desserializarCriacao(passageiro.toLowerCase(), "criacoesBovinos");

                                    if (criacao != null) {
                                        Printes.espaco();
                                        verLista = ' ';
                                        while (true) {
                                            Printes.alterarCriacao();
                                            Printes.linha();
                                            if (verLista == 'r') {
                                                singleton.listas("racoes");
                                            } else if (verLista == 'c') {
                                                singleton.listas("bovinos");
                                            }

                                            System.out.println("•[1] Esconder lista");
                                            System.out.printf("•[2] Alterar nome do setor: %s\n", criacao.getSetor());

                                            if (criacao.getRacao() != null && verLista != 'r') { // r
                                                System.out.printf("•[3] Alterar ração escolhida: %s\n", criacao.nomeRacao());

                                            } else if (criacao.getRacao() != null && verLista == 'r') {
                                                System.out.printf("•[3] Alterar ração escolhida: %s\n", criacao.nomeRacao());

                                            } else if (verLista != 'r' && criacao.getRacao() == null) {
                                                System.out.println("•[3] Ver lista de ração");

                                            } else if (verLista == 'r' && criacao.getRacao() == null) {
                                                System.out.println("•[3] Escolher ração");
                                            }

                                            System.out.printf("•[4] Alterar espécie da criação: %s\n", criacao.getEspecie());
                                            System.out.printf("•[5] Alterar raça da criação: %s\n", criacao.getRaca());
                                            System.out.println((verLista == 'c') ? "•[6] Escolher bovinos para colocar na criação" : "•[6] Ver lista de bovinos para colocar na criação "); // c
                                            System.out.println((verLista == 'c') ? "•[7] Excluir bovino da criação" : "•[7] Ver lista de bovinos para excluir da criação ");
                                            System.out.println("•[8] Serializar");
                                            System.out.println("•[9] Excluir serialização");
                                            System.out.println("•[0] Voltar");
                                            Printes.linha();
                                            System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                                            option = input.next();
                                            input.nextLine();

                                            if (option.equals("1")) {
                                                Printes.espaco();
                                                verLista = ' ';
                                            } else if (option.equals("2")) {
                                                System.out.print("•[2] <<< DIGITE O NOME DO SETOR: ");
                                                passageiro = input.nextLine();
                                                criacao.setSetor(passageiro.toLowerCase(), singleton.getNomeSitio());
                                            } else if (option.equals("3")) {
                                                if (verLista != 'r') {
                                                    Printes.espaco();
                                                    verLista = 'r';
                                                } else {
                                                    System.out.print("•[3] <<< DIGITE O NOME DA RAÇÃO QUE VOCÊ DESEJA COLOCAR, OU DIGITE 0 PARA CANCELAR: ");
                                                    passageiro = input.nextLine();

                                                    if (!passageiro.equals("0")) {
                                                        racao = singleton.desserializarRacao(passageiro.toLowerCase());
                                                        if (racao != null) criacao.setRacao(racao);
                                                    } else {
                                                        Printes.espaco();
                                                    }
                                                }
                                            } else if (option.equals("4")) {
                                                System.out.print("•[4] <<< DIGITE A ESPÉCIE DA CRIAÇÃO: ");
                                                passageiro = input.nextLine();
                                                criacao.setEspecie(passageiro.toLowerCase());
                                            } else if (option.equals("5")) {
                                                System.out.print("•[5] <<< DIGITE A RAÇA DA CRIAÇÃO: ");
                                                passageiro = input.nextLine();
                                                criacao.setRaca(passageiro.toLowerCase());
                                            } else if (option.equals("6")) {

                                                if (verLista != 'c') {
                                                    Printes.espaco();
                                                    verLista = 'c';
                                                } else {
                                                    System.out.print("•[6] <<< DIGITE O NOME DO BOVINO QUE VOCÊ DESEJA COLOCAR NA CRIAÇÃO, OU DIGITE 0 PARA CANCELAR: ");
                                                    passageiro = input.nextLine();

                                                    if (!passageiro.equals("0")) {
                                                        animal = singleton.desserializarAnimal(passageiro.toLowerCase(), "bovinos");
                                                        if (animal != null) {
                                                            criacao.adicionarNaCriacao(animal);
                                                        }
                                                    }
                                                }
                                            } else if (option.equals("7")) {
                                                if (verLista != 'c') {
                                                    Printes.espaco();
                                                    verLista = 'c';
                                                } else {
                                                    System.out.print("•[7] <<< DIGITE O NOME DO BOVINO QUE VOCÊ DESEJA EXCLUIR DA CRIAÇÃO, OU DIGITE 0 PARA CANCELAR: ");
                                                    passageiro = input.nextLine();

                                                    if (!passageiro.equals("0")) {
                                                        animal = singleton.desserializarAnimal(passageiro.toLowerCase(), "bovinos");
                                                        if (animal != null) {
                                                            criacao.retirarDaCriacao(animal);
                                                        }
                                                    }
                                                }

                                            } else if (option.equals("8")) {
                                                if (criacao.serializar(singleton.getNomeSitio())) {
                                                    verLista = ' ';
                                                    break;
                                                }
                                            } else if (option.equals("9")) {
                                                if (singleton.excluirSerializacao("criacoesBovinos", criacao.getSetor())) {
                                                    break;
                                                }
                                            } else if (option.equals("0")) {
                                                Printes.espaco();
                                                break;
                                            } else {
                                                Printes.espaco();
                                                Printes.opcaoInvalida();
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (option.equals("0")) {
                            Printes.espaco();
                            break;
                        } else {
                            Printes.espaco();
                            Printes.opcaoInvalida();
                        }


                    }
                /*
   ,---,                                      ____
  '  .' \                    ,--,           ,'  , `.             ,--,
 /  ;    '.          ,---, ,--.'|        ,-+-,.' _ |           ,--.'|
:  :       \     ,-+-. /  ||  |,      ,-+-. ;   , ||           |  |,      .--.--.
:  |   /\   \   ,--.'|'   |`--'_     ,--.'|'   |  || ,--.--.   `--'_     /  /    '
|  :  ' ;.   : |   |  ,"' |,' ,'|   |   |  ,', |  |,/       \  ,' ,'|   |  :  /`./
|  |  ;/  \   \|   | /  | |'  | |   |   | /  | |--'.--.  .-. | '  | |   |  :  ;_
'  :  | \  \ ,'|   | |  | ||  | :   |   : |  | ,    \__\/: . . |  | :    \  \    `.
|  |  '  '--'  |   | |  |/ '  : |__ |   : |  |/     ," .--.; | '  : |__   `----.   \
|  :  :        |   | |--'  |  | '.'||   | |`-'     /  /  ,.  | |  | '.'| /  /`--'  /
|  | ,'        |   |/      ;  :    ;|   ;/        ;  :   .'   \;  :    ;'--'.     /
`--''          '---'       |  ,   / '---'         |  ,     .-./|  ,   /   `--'---'
                            ---`-'                 `--`---'     ---`-'
*/
                } else if (option.equals("3")) { // Animais [l.3.*]
                    verLista = ' ';
                    Printes.espaco();
                    while (true) {
                        Printes.animais();
                        Printes.linha();
                        if (verLista == 'a') { // Feito
                            singleton.listas("aves");
                            System.out.println("•[1] Deixar de ver lista de aves");
                            System.out.println("•[2] Ver lista de bovinos");
                        } else if (verLista == 'b') { // Feito
                            singleton.listas("bovinos");
                            System.out.println("•[1] Ver lista de aves");
                            System.out.println("•[2] Deixar de ver lista de bovinos");
                        } else { // Feito
                            System.out.println("•[1] Ver lista de aves");
                            System.out.println("•[2] Ver lista de bovinos");
                        }
                        System.out.println("•[3] Adicionar nova ave"); // Feito
                        System.out.println("•[4] Adicionar novo bovino"); // Feito
                        System.out.println("•[5] Selecionar um animal para alterar"); // Feito
                        System.out.println("•[0] Voltar"); // Feito
                        Printes.linha();
                        System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                        option = input.next();

                        if (option.equals("1")) { // Ver lista de aves [l.3.1]
                            Printes.espaco();
                            if (verLista == 'a') {
                                verLista = ' ';
                            } else {
                                verLista = 'a';
                            }
                        } else if (option.equals("2")) { // Ver lista de bovinos [l.3.2]
                            Printes.espaco();
                            if (verLista == 'b') {
                                verLista = ' ';
                            } else {
                                verLista = 'b';
                            }
                        } else if (option.equals("3")) { // Adicionar nova ave [l.3.3.*]
                            animal = new Ave();
                            Printes.espaco();
                            while (true) {
                                Printes.adicionarNovaAve();
                                Printes.linha();
                                System.out.printf("•[1] Nome: %s\n", animal.getNome());
                                System.out.printf("•[2] Estado: %s\n", animal.getEstado());
                                System.out.printf("•[3] Nascimento: %s\n", animal.getNascimento());
                                System.out.printf("•[4] Sexo: %s\n", animal.getSexo());
                                System.out.printf("•[5] Espécie: %s\n", animal.getEspecie());
                                System.out.printf("•[6] Raça: %s\n", animal.getRaca());
                                System.out.printf("•[7] Linhagem: %s\n", animal.getLinhagem());
                                System.out.printf("•[8] Descrição: %s\n", animal.getDescricao());
                                System.out.println("•[9] Serializar nova ave");
                                System.out.println("•[0] Voltar");
                                Printes.linha();
                                System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                                option = input.next();
                                input.nextLine();

                                if (option.equals("1")) {
                                    System.out.print("•[1] <<< DIGITE O NOME DA AVE: ");
                                    passageiro = input.nextLine();
                                    animal.setNome(passageiro.toLowerCase(), singleton.getNomeSitio());
                                } else if (option.equals("2")) {
                                    System.out.println("•[2] <<< ESCOLHA O ESTADO DA AVE ");
                                    System.out.print("(FILHOTE - DESMAMADO - MATRIZ - REPRODUTOR): ");
                                    passageiro = input.nextLine();
                                    animal.setEstado(passageiro.toLowerCase());
                                } else if (option.equals("3")) {
                                    System.out.print("•[3] <<< DIGITE UMA DATA (EXP.: '01/12/2013': ");
                                    passageiro = input.nextLine();
                                    animal.setNascimento(passageiro);
                                } else if (option.equals("4")) {
                                    System.out.print("•[4] <<< DIGITE O SEXO DA AVE [M/F]: ");
                                    passageiro = input.nextLine();
                                    animal.setSexo(passageiro.toLowerCase());
                                } else if (option.equals("5")) {
                                    System.out.print("•[5] <<< DIGITE A ESPÉCIE DA AVE: ");
                                    passageiro = input.nextLine();
                                    animal.setEspecie(passageiro.toLowerCase());
                                } else if (option.equals("6")) {
                                    System.out.print("•[6] <<< DIGITE A RAÇA DA AVE: ");
                                    passageiro = input.nextLine();
                                    animal.setRaca(passageiro.toLowerCase());
                                } else if (option.equals("7")) {
                                    System.out.print("•[7] <<< DIGITE A LINHAGEM DA AVE: ");
                                    passageiro = input.nextLine();
                                    animal.setLinhagem(passageiro.toLowerCase());
                                } else if (option.equals("8")) {
                                    System.out.print("•[8] <<< DIGITE A DESCRIÇÃO DA AVE: ");
                                    passageiro = input.nextLine();
                                    animal.setDescricao(passageiro.toLowerCase());
                                } else if (option.equals("9")) {
                                    if (animal.serializar(singleton.getNomeSitio())) {
                                        break;
                                    }
                                } else if (option.equals("0")) {
                                    Printes.espaco();
                                    break;
                                } else {
                                    Printes.espaco();
                                    Printes.opcaoInvalida();
                                }
                            }
                        } else if (option.equals("4")) { // Adicionar novo bovino [l.3.4.*]
                            animal = new Bovino();
                            Printes.espaco();
                            while (true) {
                                Printes.adicionarNovoBovino();
                                Printes.linha();
                                System.out.printf("•[1] Nome: %s\n", animal.getNome());
                                System.out.printf("•[2] Estado: %s\n", animal.getEstado());
                                System.out.printf("•[3] Nascimento: %s\n", animal.getNascimento());
                                System.out.printf("•[4] Sexo: %s\n", animal.getSexo());
                                System.out.printf("•[5] Espécie: %s\n", animal.getEspecie());
                                System.out.printf("•[6] Raça: %s\n", animal.getRaca());
                                System.out.printf("•[7] Linhagem: %s\n", animal.getLinhagem());
                                System.out.printf("•[8] Descrição: %s\n", animal.getDescricao());
                                System.out.println("•[9] Serializar novo bovino");
                                System.out.println("•[0] Voltar");
                                Printes.linha();
                                System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                                option = input.next();
                                input.nextLine();

                                if (option.equals("1")) {
                                    System.out.print("•[1] <<< DIGITE O NOME DO BOVINO: ");
                                    passageiro = input.nextLine();
                                    animal.setNome(passageiro.toLowerCase(), singleton.getNomeSitio());
                                } else if (option.equals("2")) {
                                    System.out.println("•[2] <<< ESCOLHA O ESTADO DO BOVINO");
                                    System.out.print("(FILHOTE - DESMAMADO - MATRIZ - REPRODUTOR): ");
                                    passageiro = input.nextLine();
                                    animal.setEstado(passageiro.toLowerCase());
                                } else if (option.equals("3")) {
                                    System.out.print("•[3] <<< DIGITE UMA DATA (EXP.: '01/12/2013': ");
                                    passageiro = input.nextLine();
                                    animal.setNascimento(passageiro);
                                } else if (option.equals("4")) {
                                    System.out.print("•[4] <<< DIGITE O SEXO DO BOVINO [M/F]: ");
                                    passageiro = input.nextLine();
                                    animal.setSexo(passageiro.toLowerCase());
                                } else if (option.equals("5")) {
                                    System.out.print("•[5] <<< DIGITE A ESPÉCIE DO BOVINO: ");
                                    passageiro = input.nextLine();
                                    animal.setEspecie(passageiro.toLowerCase());
                                } else if (option.equals("6")) {
                                    System.out.print("•[6] <<< DIGITE A RAÇA DO BOVINO: ");
                                    passageiro = input.nextLine();
                                    animal.setRaca(passageiro.toLowerCase());
                                } else if (option.equals("7")) {
                                    System.out.print("•[7] <<< DIGITE A LINHAGEM DO BOVINO: ");
                                    passageiro = input.nextLine();
                                    animal.setLinhagem(passageiro.toLowerCase());
                                } else if (option.equals("8")) {
                                    System.out.print("•[8] <<< DIGITE A DESCRIÇÃO DO BOVINO: ");
                                    passageiro = input.nextLine();
                                    animal.setDescricao(passageiro.toLowerCase());
                                } else if (option.equals("9")) {
                                    if (animal.serializar(singleton.getNomeSitio())) {
                                        break;
                                    }
                                } else if (option.equals("0")) {
                                    Printes.espaco();
                                    break;
                                } else {
                                    Printes.espaco();
                                    Printes.opcaoInvalida();
                                }
                            }

                        } else if (option.equals("5")) { // Selecionar um animal para alterar [l.3.5]
                            input.nextLine();
                            if (verLista == ' ') {
                                Printes.espaco();
                                System.out.println("--> ABRA A LISTA DO TIPO DE ANIMAL QUE VOCÊ DESEJA SELECIONAR.");

                            } else if (verLista == 'a') {
                                System.out.println("(PARA SELECIONAR UM BOVINO ABRA A LISTA DE BOVINOS)");
                                System.out.print("•[5] <<< DIGITE O NOME DA AVE QUE VOCÊ DESEJA ALTERAR, OU DIGITE 0 PARA CANCELAR: ");
                                passageiro = input.nextLine();

                                if (!passageiro.equals("0")) {

                                    animal = singleton.desserializarAnimal(passageiro.toLowerCase(), "aves");

                                    if (animal != null) {
                                        Printes.espaco();
                                        while (true) {
                                            Printes.alterarAve();
                                            Printes.linha();
                                            System.out.printf("•[1] Nome: %s\n", animal.getNome());
                                            System.out.printf("•[2] Alterar estado: %s\n", animal.getEstado());
                                            System.out.printf("•[3] Alterar nascimento: %s\n", animal.getNascimento());
                                            System.out.printf("•[4] Alterar sexo: %s\n", animal.getSexo());
                                            System.out.printf("•[5] Alterar espécie: %s\n", animal.getEspecie());
                                            System.out.printf("•[6] Alterar raça: %s\n", animal.getRaca());
                                            System.out.printf("•[7] Alterar linhagem: %s\n", animal.getLinhagem());
                                            System.out.printf("•[8] Alterar descrição: %s\n", animal.getDescricao());
                                            System.out.println("•[9] Verificar transicao");
                                            System.out.println("•[10] Salvar alterações");
                                            System.out.println("•[11] Excluir serialização");
                                            System.out.println("•[0] Voltar");
                                            Printes.linha();
                                            System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                                            option = input.next();
                                            input.nextLine();

                                            if (option.equals("1")) {
                                                Printes.espaco();
                                                System.out.println("--> O NOME NÃO PODE SER ALTERADO DEPOIS DE CRIADO.");
                                            } else if (option.equals("2")) {
                                                System.out.println("•[2] <<< ESCOLHA O ESTADO DA AVE");
                                                System.out.print("(FILHOTE - DESMAMADO - MATRIZ - REPRODUTOR): ");
                                                passageiro = input.nextLine();
                                                animal.setEstado(passageiro.toLowerCase());
                                            } else if (option.equals("3")) {
                                                System.out.print("•[3] <<< DIGITE UMA DATA (EXP.: '01/12/2013': ");
                                                passageiro = input.nextLine();
                                                animal.setNascimento(passageiro);
                                            } else if (option.equals("4")) {
                                                System.out.print("•[4] <<< DIGITE O SEXO DA AVE [M/F]: ");
                                                passageiro = input.nextLine();
                                                animal.setSexo(passageiro.toLowerCase());
                                            } else if (option.equals("5")) {
                                                System.out.print("•[5] <<< DIGITE A ESPÉCIE DA AVE: ");
                                                passageiro = input.nextLine();
                                                animal.setEspecie(passageiro.toLowerCase());
                                            } else if (option.equals("6")) {
                                                System.out.print("•[6] <<< DIGITE A RAÇA DA AVE: ");
                                                passageiro = input.nextLine();
                                                animal.setRaca(passageiro.toLowerCase());
                                            } else if (option.equals("7")) {
                                                System.out.print("•[7] <<< DIGITE A LINHAGEM DA AVE: ");
                                                passageiro = input.nextLine();
                                                animal.setLinhagem(passageiro.toLowerCase());
                                            } else if (option.equals("8")) {
                                                System.out.print("•[8] <<< DIGITE A DESCRIÇÃO DA AVE: ");
                                                passageiro = input.nextLine();
                                                animal.setDescricao(passageiro.toLowerCase());
                                            } else if (option.equals("9")) {
                                                animal.verificarTransicao();
                                            } else if (option.equals("10")) {
                                                if (animal.serializar(singleton.getNomeSitio())) {
                                                    Printes.espaco();
                                                    break;
                                                }
                                            } else if (option.equals("11")) {
                                                if (singleton.excluirSerializacao("aves", animal.getNome())) {
                                                    break;
                                                }
                                            } else if (option.equals("0")) {
                                            Printes.espaco();
                                                break;
                                            } else {
                                                Printes.espaco();
                                                Printes.opcaoInvalida();
                                            }
                                        }
                                    }
                                }
                            } else if (verLista == 'b') {
                                System.out.println("(PARA SELECIONAR UMA AVE ABRA A LISTA DE AVES)");
                                System.out.print("•[5] <<< DIGITE O NOME DO BOVINO QUE VOCÊ DESEJA ALTERAR, OU DIGITE 0 PARA CANCELAR: ");
                                passageiro = input.nextLine();

                                if (!passageiro.equals("0")) {

                                    animal = singleton.desserializarAnimal(passageiro.toLowerCase(), "bovinos");

                                    if (animal != null) {
                                        Printes.espaco();
                                        while (true) {
                                            Printes.alterarBovino();
                                            Printes.linha();
                                            System.out.printf("•[1] Nome: %s\n", animal.getNome());
                                            System.out.printf("•[2] Alterar estado: %s\n", animal.getEstado());
                                            System.out.printf("•[3] Alterar nascimento: %s\n", animal.getNascimento());
                                            System.out.printf("•[4] Alterar sexo: %s\n", animal.getSexo());
                                            System.out.printf("•[5] Alterar espécie: %s\n", animal.getEspecie());
                                            System.out.printf("•[6] Alterar raça: %s\n", animal.getRaca());
                                            System.out.printf("•[7] Alterar linhagem: %s\n", animal.getLinhagem());
                                            System.out.printf("•[8] Alterar descrição: %s\n", animal.getDescricao());
                                            System.out.println("•[9] Verificar transicao");
                                            System.out.println("•[10] Salvar alterações");
                                            System.out.println("•[11] Excluir serialização");
                                            System.out.println("•[0] Voltar");
                                            Printes.linha();
                                            System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                                            option = input.next();
                                            input.nextLine();

                                            if (option.equals("1")) {
                                                Printes.espaco();
                                                System.out.println("--> O NOME NÃO PODE SER ALTERADO DEPOIS DE CRIADO.");
                                            } else if (option.equals("2")) {
                                                System.out.println("•[2] <<< ESCOLHA O ESTADO DO BOVINO");
                                                System.out.print("(FILHOTE - DESMAMADO - MATRIZ - REPRODUTOR): ");
                                                passageiro = input.nextLine();
                                                animal.setEstado(passageiro.toLowerCase());
                                            } else if (option.equals("3")) {
                                                System.out.print("•[3] <<< DIGITE UMA DATA (EXP.: '01/12/2013': ");
                                                passageiro = input.nextLine();
                                                animal.setNascimento(passageiro);
                                            } else if (option.equals("4")) {
                                                System.out.print("•[4] <<< DIGITE O SEXO DO BOVINO [M/F]: ");
                                                passageiro = input.nextLine();
                                                animal.setSexo(passageiro.toLowerCase());
                                            } else if (option.equals("5")) {
                                                System.out.print("•[5] <<< DIGITE A ESPÉCIE DO BOVINO: ");
                                                passageiro = input.nextLine();
                                                animal.setEspecie(passageiro.toLowerCase());
                                            } else if (option.equals("6")) {
                                                System.out.print("•[6] <<< DIGITE A RAÇA DO BOVINO: ");
                                                passageiro = input.nextLine();
                                                animal.setRaca(passageiro.toLowerCase());
                                            } else if (option.equals("7")) {
                                                System.out.print("•[7] <<< DIGITE A LINHAGEM DO BOVINO: ");
                                                passageiro = input.nextLine();
                                                animal.setLinhagem(passageiro.toLowerCase());
                                            } else if (option.equals("8")) {
                                                System.out.print("•[8] <<< DIGITE A DESCRIÇÃO DO BOVINO: ");
                                                passageiro = input.nextLine();
                                                animal.setDescricao(passageiro.toLowerCase());
                                            } else if (option.equals("9")) {
                                                animal.verificarTransicao();
                                            } else if (option.equals("10")) {
                                                if (animal.serializar(singleton.getNomeSitio())) {
                                                    Printes.espaco();
                                                    break;
                                                }
                                            } else if (option.equals("11")) {
                                                if (singleton.excluirSerializacao("bovinos", animal.getNome())) {
                                                    break;
                                                }
                                            } else if (option.equals("0")) {
                                                Printes.espaco();
                                                break;
                                            } else {
                                                Printes.espaco();
                                                Printes.opcaoInvalida();
                                            }


                                        }
                                    }
                                }
                            }

                        } else if (option.equals("0")) {
                            Printes.espaco();
                            break;
                        } else {
                            Printes.espaco();
                            Printes.opcaoInvalida();
                        }
                    }

                /*
,-.----.
\    /  \
;   :    \                        ,---.
|   | .\ :                       '   ,'\             .--.--.
.   : |: |   ,--.--.     ,---.  /   /   |   ,---.   /  /    '
|   |  \ :  /       \   /     \.   ; ,. :  /     \ |  :  /`./
|   : .  / .--.  .-. | /    / ''   | |: : /    /  ||  :  ;_
;   | |  \  \__\/: . ..    ' / '   | .; :.    ' / | \  \    `.
|   | ;\  \ ," .--.; |'   ; :__|   :    |'   ;   /|  `----.   \
:   ' | \.'/  /  ,.  |'   | '.'|\   \  / '   |  / | /  /`--'  /
:   : :-' ;  :   .'   \   :    : `----'  |   :    |'--'.     /
|   |.'   |  ,     .-./\   \  /           \   \  /   `--'---'
`---'      `--`---'     `----'             `----'
*/
                } else if (option.equals("4")) { // Rações [l.4.*]
                    verLista = ' ';
                    Printes.espaco();
                    while (true) {
                        Printes.racoes();
                        Printes.linha();
                        if (verLista == ' ') {
                            System.out.println("•[1] Ver lista de rações");
                        } else {
                            singleton.listas("racoes");
                            System.out.println("•[1] Deixar de ver lista de rações");
                        }
                        System.out.println("•[2] Adicionar nova ração");
                        System.out.println("•[3] Selecionar uma ração para alterar");
                        System.out.println("•[0] Voltar");
                        Printes.linha();
                        System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                        option = input.next();

                        if (option.equals("1")) { // Ver lista de rações
                            Printes.espaco();
                            if (verLista == ' ') {
                                verLista = '1';
                            } else {
                                verLista = ' ';
                            }
                        } else if (option.equals("2")) { // Adicionar nova ração [l.4.2.*]
                            racao = new Racao();
                            Printes.espaco();
                            while (true) {
                                Printes.adicionarRacao();
                                Printes.linha();
                                System.out.printf("•[1] Nomear essa ração: %s\n", racao.getNome());
                                System.out.printf("•[2] Colocar a marca da ração: %s\n", racao.getMarca());
                                System.out.printf("•[3] Preço do Kg (em centavos): %s\n", racao.getPrecoEmCentavos());
                                System.out.printf("•[4] Quantas vezes alimentar no dia: %s\n", racao.getQuantasVezesAlimntar());
                                System.out.printf("•[5] Quantidade para alimentar (em gramas): %s\n", racao.getQuantidadeParaAlimentarGramas());
                                System.out.println("•[6] Serializar nova ração");
                                System.out.println("•[0] Voltar");
                                Printes.linha();
                                System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                                option = input.next();
                                input.nextLine();
                                
                                if (option.equals("1")) {
                                    System.out.print("•[1] <<< DIGITE O NOME DA RAÇÃO: ");
                                    passageiro = input.nextLine();
                                    racao.setNome(passageiro, singleton.getNomeSitio());
                                } else if (option.equals("2")) {
                                    System.out.print("•[2] <<< DIGITE A MARCA DA RAÇÃO: ");
                                    passageiro = input.nextLine();
                                    racao.setMarca(passageiro);
                                } else if (option.equals("3")) {
                                    System.out.print("•[3] <<< DIGITE O PREÇO DO QUILO DA RAÇÃO (EM CENTAVOS): ");
                                    passageiro = input.nextLine();
                                    racao.setPrecoEmCentavos(passageiro);
                                } else if (option.equals("4")) {
                                    System.out.print("•[4] <<< DIGITE A QUANTIDADE DE VEZES PARA ALIMENTAR NO DIA: ");
                                    passageiro = input.nextLine();
                                    racao.setQuantasVezesAlimentar(passageiro);
                                } else if (option.equals("5")) {
                                    System.out.print("•[5] <<< DIGITE A QUANTIDADE PARA ALIMENTAR (EM GRAMAS): ");
                                    passageiro = input.nextLine();
                                    racao.setQuantidadeParaAlimentarGramas(passageiro);
                                } else if (option.equals("6")) {
                                    if (racao.serializar(singleton.getNomeSitio())) {
                                        break;
                                    }
                                } else if (option.equals("0")) {
                                    Printes.espaco();
                                    break;
                                } else {
                                    Printes.espaco();
                                    Printes.opcaoInvalida();
                                }
                            }
                        } else if (option.equals("3")) { // Selecionar uma ração para alterar [l.4.3.*]
                            System.out.print("•[3] <<< DIGITE O NOME COMPLETO DA RAÇÃO, OU 0 PARA CANCELAR: ");
                            input.nextLine();
                            passageiro = input.nextLine();

                            if (!passageiro.equals("0")) {

                                racao = singleton.desserializarRacao(passageiro);

                                if (racao != null) {
                                    Printes.espaco();
                                    while (true) {
                                        Printes.alterarRacao();
                                        Printes.linha();
                                        System.out.printf("•[1] Nome da ração: %s\n", racao.getNome());
                                        System.out.printf("•[2] Alterar marca da ração: %s\n", racao.getMarca());
                                        System.out.printf("•[3] Alterar preço do Kg (em centavos): %s\n", racao.getPrecoEmCentavos());
                                        System.out.printf("•[4] Alterar quantas vezes alimentar no dia: %s\n", racao.getQuantasVezesAlimntar());
                                        System.out.printf("•[5] Alterar quantidade para alimentar (em gramas): %s\n", racao.getQuantidadeParaAlimentarGramas());
                                        System.out.println("•[6] Salvar alterações");
                                        System.out.println("•[7] Excluir ração");
                                        System.out.println("•[0] Voltar");
                                        Printes.linha();
                                        System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                                        option = input.next();
                                        input.nextLine();

                                        if (option.equals("1")) {
                                            Printes.espaco();
                                            System.out.println("--> O NOME NÃO PODE SER ALTERADO DEPOIS DE CRIADO.");
                                        } else if (option.equals("2")) {
                                            System.out.print("•[2] <<< DIGITE A MARCA DA RAÇÃO: ");
                                            passageiro = input.nextLine();
                                            racao.setMarca(passageiro);
                                        } else if (option.equals("3")) {
                                            System.out.print("•[3] <<< DIGITE O PREÇO DO QUILO DA RAÇÃO (EM CENTAVOS): ");
                                            passageiro = input.nextLine();
                                            racao.setPrecoEmCentavos(passageiro);
                                        } else if (option.equals("4")) {
                                            System.out.print("•[4] <<< DIGITE A QUANTIDADE DE VEZES PARA ALIMENTAR NO DIA: ");
                                            passageiro = input.nextLine();
                                            racao.setQuantasVezesAlimentar(passageiro);
                                        } else if (option.equals("5")) {
                                            System.out.print("•[5] <<< DIGITE A QUANTIDADE PARA ALIMENTAR (EM GRAMAS): ");
                                            passageiro = input.nextLine();
                                            racao.setQuantidadeParaAlimentarGramas(passageiro);
                                        } else if (option.equals("6")) {
                                            if (racao.serializar(singleton.getNomeSitio())) {
                                                Printes.espaco();
                                                break;
                                            }
                                        } else if (option.equals("7")) {
                                            if (singleton.excluirSerializacao("racoes", racao.getNome())) {
                                                break;
                                            }
                                        } else if (option.equals("0")) {
                                            Printes.espaco();
                                            break;
                                        } else {
                                            Printes.espaco();
                                            Printes.opcaoInvalida();
                                        }
                                    }
                                }
                            }

                        } else if (option.equals("0")) {
                            Printes.espaco();
                            break;
                        } else {
                            Printes.espaco();
                            Printes.opcaoInvalida();
                        }
                    }

                } else if (option.equals("0")) {
                    Printes.espaco();
                    break;
                } else {
                    Printes.espaco();
                    Printes.opcaoInvalida();
                }
            }

















        }
    }
}
