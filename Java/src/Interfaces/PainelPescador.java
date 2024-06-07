package Interfaces;

import Classes.Pescador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PainelPescador extends JFrame{

    private JComboBox<String> regionComboBox;
    private JComboBox<String> habitatComboBox;

    public PainelPescador(Pescador pescador) {
        // Configurações básicas do JFrame
        setTitle("Painel Pescador");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Criação dos JComboBoxes
        regionComboBox = new JComboBox<>(new String[]{"","Sul", "Norte"});
        habitatComboBox = new JComboBox<>(new String[]{"","Rio", "Oceano"});

        JButton searchButton = new JButton("Pesquisar");

        // Criação do painel e definição do layout
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Adicionando os JComboBoxes ao painel
        panel.add(new JLabel("Região:"));
        panel.add(regionComboBox);
        panel.add(new JLabel("Habitat:"));
        panel.add(habitatComboBox);
        panel.add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedRegion = (String) regionComboBox.getSelectedItem();
                String selectedHabitat = (String) habitatComboBox.getSelectedItem();

                if (regionComboBox.getSelectedIndex() == 0 && habitatComboBox.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Selecione uma região ou um habitat.",
                            "ERRO", JOptionPane.ERROR_MESSAGE);
                } else if ( regionComboBox.getSelectedIndex() != 0 && habitatComboBox.getSelectedIndex() == 0 ){
                    System.out.println("entrei");
                    ArrayList<String> peixes = pescador.listar(selectedRegion);
                    JOptionPane.showMessageDialog(null, "Peixes selecionados: "+peixes,
                            "Peixes por Região", JOptionPane.INFORMATION_MESSAGE);
                }else if ( regionComboBox.getSelectedIndex() == 0 && habitatComboBox.getSelectedIndex() != 0 ){
                    ArrayList<String> peixes = pescador.listar(selectedHabitat);
                    JOptionPane.showMessageDialog(null, "Peixes da região selecionada: "+peixes,
                            "Peixes selecionados:", JOptionPane.INFORMATION_MESSAGE);
                }else if ( regionComboBox.getSelectedIndex() != 0 && habitatComboBox.getSelectedIndex() != 0 ){
                    ArrayList<String> peixes = pescador.listar(selectedRegion, selectedHabitat);
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
