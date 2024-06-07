package Interfaces;

import Classes.Pescador;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroPescador extends JFrame {

    public CadastroPescador() {
        setTitle("Cadastro Pescador");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();

        JLabel senhaLabel = new JLabel("Senha:");
        JPasswordField senhaField = new JPasswordField();

        JLabel rgpLabel = new JLabel("RGP:");
        JTextField rgpField = new JTextField();

        JLabel embarcacaoLabel = new JLabel("Embarcação:");
        JTextField embarcacaoField = new JTextField();


        JButton cadastrarButton = new JButton("Cadastrar");


        panel.add(nomeLabel);
        panel.add(nomeField);

        panel.add(senhaLabel);
        panel.add(senhaField);

        panel.add(rgpLabel);
        panel.add(rgpField);

        panel.add(embarcacaoLabel);
        panel.add(embarcacaoField);

        panel.add(new JLabel());
        panel.add(cadastrarButton);


        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = nomeField.getText();
                String senha = new String(senhaField.getPassword());
                String rgb = rgpField.getText();
                String embarcacao = embarcacaoField.getText();


                Pescador pescador = new Pescador(nome, senha, rgb, embarcacao);

                boolean verificacao = pescador.verificacao(rgb);

                if (verificacao){
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                    new PainelPescador(pescador);
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
