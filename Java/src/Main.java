import Interfaces.CadastroPescador;
import Interfaces.CadastroGuardaCosteiro;


import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] options = {"Pescador", "Guarda Costeiro"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Escolha o tipo de usuário que quer ser cadastrado?",
                "Cadastro de Usuário",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );
        if (choice == 0) {
            new CadastroPescador();
        } else if (choice == 1) {
            new CadastroGuardaCosteiro();
        }





    }
}
