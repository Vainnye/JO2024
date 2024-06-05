package vues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private JButton athleteButton;
    private JButton equipeButton;
    private JButton paysButton;
    private JButton disciplineButton;
    private JButton epreuveButton;
    private JButton resultatButton;

    public MainView() {
        setTitle("Gestion des Sports");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        athleteButton = new JButton("Athletes");
        equipeButton = new JButton("Equipes");
        paysButton = new JButton("Pays");
        disciplineButton = new JButton("Disciplines");
        epreuveButton = new JButton("Epreuves");
        resultatButton = new JButton("Resultats");

        panel.add(athleteButton);
        panel.add(equipeButton);
        panel.add(paysButton);
        panel.add(disciplineButton);
        panel.add(epreuveButton);
        panel.add(resultatButton);

        add(panel);

        athleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showvuesAthlete();
            }
        });

        equipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showvuesEquipe();
            }
        });

        paysButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showvuesPays();
            }
        });

        disciplineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showvuesDiscipline();
            }
        });

        epreuveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showvuesEpreuve();
            }
        });

        resultatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showvuesResultat();
            }
        });
    }

    private void showvuesAthlete() {
        vuesAthlete vuesathlete = new vuesAthlete();
        vuesathlete.setVisible(true);
    }

    private void showvuesEquipe() {
        vuesEquipe vuesequipe = new vuesEquipe();
        vuesequipe.setVisible(true);
    }

    private void showvuesPays() {
        vuesPays vuespays = new vuesPays();
        vuespays.setVisible(true);
    }

    private void showvuesDiscipline() {
        vuesDiscipline vuesdiscipline = new vuesDiscipline();
        vuesdiscipline.setVisible(true);
    }

    private void showvuesEpreuve() {
        vuesEpreuve vuesepreuve = new vuesEpreuve();
        vuesepreuve.setVisible(true);
    }

    private void showvuesResultat() {
        vuesResultat vuesresultat = new vuesResultat();
        vuesresultat.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainView mainView = new MainView();
                mainView.setVisible(true);
            }
        });
    }
}
