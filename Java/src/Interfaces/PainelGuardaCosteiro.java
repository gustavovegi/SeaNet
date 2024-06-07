package Interfaces;

import Classes.GuardaCosteiro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PainelGuardaCosteiro extends JFrame{

    private JComboBox<String> regionComboBox;
    private JComboBox<String> tipoPescaComboBox;

    public PainelGuardaCosteiro(GuardaCosteiro guarda) {
        // Configurações básicas do JFrame
        setTitle("Painel Pescador");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Criação dos JComboBoxes
        regionComboBox = new JComboBox<>(new String[]{"","Sul", "Norte"});
        tipoPescaComboBox = new JComboBox<>(new String[]{"","Água Doce", "Água Salgada"});

        JButton searchButton = new JButton("Pesquisar");

        // Criação do painel e definição do layout
        JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());

        // Adicionando os JComboBoxes ao painel
            panel.add(new JLabel("Região:"));
            panel.add(regionComboBox);
            panel.add(new JLabel("Tipo de Pesca:"));
            panel.add(tipoPescaComboBox);
            panel.add(searchButton);

            searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedRegion = (String) regionComboBox.getSelectedItem();
                String selectedHabitat = (String) tipoPescaComboBox.getSelectedItem();

                if (regionComboBox.getSelectedIndex() == 0 && tipoPescaComboBox.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Selecione uma região ou um habitat.",
                            "ERRO", JOptionPane.ERROR_MESSAGE);
                } else if ( regionComboBox.getSelectedIndex() != 0 && tipoPescaComboBox.getSelectedIndex() == 0 ){
                    System.out.println("entrei");
                    ArrayList<String> peixes = guarda.listar(selectedRegion);
                    JOptionPane.showMessageDialog(null, "Peixes selecionados: "+peixes,
                            "Peixes por Região", JOptionPane.INFORMATION_MESSAGE);
                }else if ( regionComboBox.getSelectedIndex() == 0 && tipoPescaComboBox.getSelectedIndex() != 0 ){
                    ArrayList<String> peixes = guarda.listar(selectedHabitat);
                    JOptionPane.showMessageDialog(null, "Peixes da região selecionada: "+peixes,
                            "Peixes selecionados:", JOptionPane.INFORMATION_MESSAGE);
                }else if ( regionComboBox.getSelectedIndex() != 0 && tipoPescaComboBox.getSelectedIndex() != 0 ){
                    ArrayList<String> peixes = guarda.listar(selectedRegion, selectedHabitat);
                    JOptionPane.showMessageDialog(null, "Peixes da região selecionada: "+peixes,
                            "Peixes selecionados:", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Adicionando o painel ao JFrame
        add(panel);

        setVisible(true);

}
}
