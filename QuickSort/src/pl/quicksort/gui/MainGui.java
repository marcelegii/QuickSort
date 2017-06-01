/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.quicksort.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Marcel
 */
public class MainGui extends JFrame{
    
    private JPanel mainPanel;
    private JPanel rightPanel;
    private  JPanel centerPanel;
    private JPanel leftPanel;
    private JButton sortButton;
    private JTextArea enterData;
    private JTextArea resultData;
    private JPanel itemPanel;
    private JLabel enterLabel;
    private JLabel resultLabel;
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
         mainPanel.add(itemPanel);
        setContentPane(mainPanel);
        setVisible(true);
        setSize(new Dimension(510, 200));
        setLocationRelativeTo(null);
        setResizable(false);
      }
      
       private void setMainPanel() {
        itemPanel = new JPanel(new BorderLayout(3,3));
        mainPanel=new JPanel();
        itemPanel.setBackground(Color.WHITE);
        
        setContentPane(mainPanel);
    }
       
       private void setCenterArea() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.LIGHT_GRAY);
        centerPanel.setPreferredSize(new Dimension(100, 200));
        
        sortButton = new JButton("SORT");
        centerPanel.add(sortButton, BorderLayout.NORTH);

        
         itemPanel.add(centerPanel,BorderLayout.CENTER);
       }
       
       private void setLeftSide() {
        JPanel leftChildPanel=new JPanel(new BorderLayout(1,2));
        enterLabel=new JLabel(" Enter you numbers, fx: 1, 2, 3");
        leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setPreferredSize(new Dimension(200, 100));
        enterData=new JTextArea(10,5);
        JScrollPane scrollPane= new JScrollPane(enterData);
        leftChildPanel.add(scrollPane);
        leftChildPanel.add(enterLabel, BorderLayout.NORTH);
        leftPanel.add(leftChildPanel,BorderLayout.NORTH);
        

        itemPanel.add(leftPanel,BorderLayout.WEST);
    }
       
        private void setRightSide() {
        JPanel rightChildPanel=new JPanel(new BorderLayout(1,2));
        resultLabel=new JLabel(" Your result");
        rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setPreferredSize(new Dimension(200, 100));
        resultData=new JTextArea(10,5);
        JScrollPane scrollPane= new JScrollPane(resultData);
        rightChildPanel.add(scrollPane);
        rightChildPanel.add(resultLabel, BorderLayout.NORTH);
        rightPanel.add(rightChildPanel,BorderLayout.NORTH);
        

        

        itemPanel.add(rightPanel,BorderLayout.EAST);
    }
}
