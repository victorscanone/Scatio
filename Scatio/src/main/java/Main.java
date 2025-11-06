import animais.*;
import criacaoERacao.*;
import dadosEPrintes.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String option;
        String[] criarConta = {"", ""};
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
                System.out.println("•[1] Logar");
                System.out.println("•[2] Criar sítio");
                System.out.println("•[0] Sair");
                Printes.linha();
                System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                option = input.next();

                if (option.equals("1")) {
                    Printes.menuLogin();
                    Printes.linha();
                    System.out.println("•[]");
                    System.out.println("•[]");
                    Printes.linha();
                    System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                } else if (option.equals("2")) {
                    Printes.linha();
                    System.out.println("•[]");
                    System.out.println("•[]");
                    Printes.linha();
                    System.out.print("•[?] <<< DIGITE UMA OPÇÃO: ");
                } else if (option.equals("0")) {
                    break;
                } else {

                }


            }
        }
    }
}
