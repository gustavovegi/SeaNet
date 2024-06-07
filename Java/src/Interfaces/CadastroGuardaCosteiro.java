package Interfaces;

import Classes.GuardaCosteiro;
import Classes.Pescador;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroGuardaCosteiro extends JFrame{

    public CadastroGuardaCosteiro(){
        setTitle("Cadastro Guarda Costeiro");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();

        JLabel senhaLabel = new JLabel("Senha:");
        JPasswordField senhaField = new JPasswordField();

        JLabel cacLabel = new JLabel("CAC:");
        JTextField cacField = new JTextField();

        JLabel regiaoLabel = new JLabel("Região:");
        JTextField regiaoField = new JTextField();

        JLabel departamentoLabel = new JLabel("Departamento:");
        JTextField departamentoField = new JTextField();


        JButton cadastrarButton = new JButton("Cadastrar");

            panel.add(nomeLabel);
            panel.add(nomeField);

            panel.add(senhaLabel);
            panel.add(senhaField);

            panel.add(cacLabel);
            panel.add(cacField);

            panel.add(regiaoLabel);
            panel.add(regiaoField);

            panel.add(departamentoLabel);
            panel.add(departamentoField);

            panel.add(new JLabel());
            panel.add(cadastrarButton);


            cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = nomeField.getText();
                String senha = new String(senhaField.getPassword());
                String cac = new String(cacField.getText());
                String regiao = regiaoField.getText();
                String departamento = departamentoField.getText();


                GuardaCosteiro guarda = new GuardaCosteiro(nome, senha, cac ,regiao, departamento);

                boolean verificacao = guarda.verificacao(cac);

                if (verificacao){
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                    new PainelGuardaCosteiro(guarda);
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "Credencial incorreta! Cadastre novamente!", null, JOptionPane.ERROR_MESSAGE);
                    clearAll(panel);
                }
            }
        });


        add(panel);


        setVisible(true);
    }

    public static void clearAll(JPanel panel) {
        for (int i = 0; i < panel.getComponentCount(); i++) {
            if (panel.getComponent(i) instanceof JTextComponent) {
                JTextComponent textComponent = (JTextComponent) panel.getComponent(i);
                textComponent.setText(""); // Limpa o texto do JTextComponent
            }
        }
    }
}
