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
                System.out.println("•[2] Criar sítio"); //
                System.out.println("•[0] Sair"); // FEITO
                Printes.linha();
                System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                option = input.next();

                if (option.equals("1")) {
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

                        if (option.equals("1")) {
                            System.out.print("•[1] <<< DIGITE O NOME DO SÍTIO: ");
                            infoConta[0] = SingletonDados.conferirNomeSitio(infoConta[0], input.next());
                        } else if (option.equals("2")) {
                            System.out.print("•[2] <<< DIGITE A SENHA DO SÍTIO: ");
                            infoConta[2] = SingletonDados.conferirSenhaSitio(infoConta[2], input.next());
                        } else if (option.equals("3")) {
                            logado = singleton.logarNoSitio(infoConta);
                        } else if (option.equals("0")) {
                            Printes.espaco();
                            break;
                        }
                    }
                } else if (option.equals("2")) {
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
