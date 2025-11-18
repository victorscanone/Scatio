//import animais.*;
//import criacaoERacao.*;
import dadosEPrintes.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        SingletonDados singleton = SingletonDados.getInstance();
        String option;
        String[] infoConta = {"", "", ""}; // Nome, E-mail, Senha
        char logado = 'n';
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
                System.out.println("•[2] Criar sítio"); // Falta terminar tudo
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
                            break outer;
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















        }
    }
}
