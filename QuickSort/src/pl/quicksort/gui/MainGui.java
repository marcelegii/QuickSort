/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.quicksort.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import pl.quicksort.algorithm.QuickSort;

/**
 *
 * @author Marcel Woznica
 * @version 1.0
 */
public class MainGui extends JFrame {
    
    private JPanel mainPanel;
    private JPanel rightPanel;
    private JPanel centerPanel;
    private JPanel leftPanel;
    private JButton sortButton;
    private JTextArea enterData;
    private JTextArea resultData;
    private JPanel panelWithPanels;
    private JLabel enterLabel;
    private JLabel resultLabel;
    private QuickSort quicksort;
    
    public static void main(String[] args) {
        new MainGui();
    }
    
    public MainGui() {
        super("Quick Sort");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMainPanel();
        setCenterArea();
        setLeftSide();
        setRightSide();
        mainPanel.add(panelWithPanels);
        
        setOnClick();
        setContentPane(mainPanel);
        setVisible(true);
        setSize(new Dimension(510, 200));
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private void setMainPanel() {
        panelWithPanels = new JPanel(new BorderLayout(3, 3));
        mainPanel = new JPanel();
        panelWithPanels.setBackground(Color.WHITE);
        
        setContentPane(mainPanel);
    }
    
    private void setCenterArea() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.LIGHT_GRAY);
        centerPanel.setPreferredSize(new Dimension(100, 200));
        
        sortButton = new JButton("SORT");
        centerPanel.add(sortButton, BorderLayout.NORTH);
        panelWithPanels.add(centerPanel, BorderLayout.CENTER);
    }
    
    private void setLeftSide() {
        JPanel leftChildPanel = new JPanel(new BorderLayout(1, 2));
        enterLabel = new JLabel(" Enter you numbers, fx: 1, 2, 3");
        
        leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setPreferredSize(new Dimension(200, 100));
        enterData = new JTextArea(10, 5);
        JScrollPane scrollPane = new JScrollPane(enterData);
        
        leftChildPanel.add(scrollPane);
        leftChildPanel.add(enterLabel, BorderLayout.NORTH);
        leftPanel.add(leftChildPanel, BorderLayout.NORTH);
        
        panelWithPanels.add(leftPanel, BorderLayout.WEST);
    }
    
    private void setRightSide() {
        JPanel rightChildPanel = new JPanel(new BorderLayout(1, 2));
        
        resultLabel = new JLabel(" Your result:");
        rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setPreferredSize(new Dimension(200, 100));
        
        resultData = new JTextArea(10, 5);
        JScrollPane scrollPane = new JScrollPane(resultData);
        rightChildPanel.add(scrollPane);
        rightChildPanel.add(resultLabel, BorderLayout.NORTH);
        rightPanel.add(rightChildPanel, BorderLayout.NORTH);
        panelWithPanels.add(rightPanel, BorderLayout.EAST);
    }
    
    private void setOnClick() {
        
        sortButton.addActionListener(e -> {
            String textFromTextBox = enterData.getText();
            
            quicksort = new QuickSort(textFromTextBox);
            try {
                quicksort.executeSort();
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Data to big. Max value=" + Integer.MAX_VALUE, "Error", JOptionPane.ERROR_MESSAGE);
                enterData.setText("");
            }
            
        });
    }
}
