package com.headfirst.pacmanface;

import java.awt.*;
import java.awt.event.*;
import java.rmi.*;
import javax.swing.*;

public class ClientBrowser {

    JPanel panel;
    JComboBox<Object> comboBox;
    MyRMIServer rmiServer;

    public static void main(String[] args) {
        new ClientBrowser().buildGui();
    }

    public void buildGui(){
        JFrame frame = new JFrame("RMI Browser");
        panel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER,panel);
        Object[] myServices = getMyServices();
        comboBox = new JComboBox<>(myServices);
        comboBox.addActionListener(new ComboBoxListener());
        frame.getContentPane().add(BorderLayout.NORTH, comboBox);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    Object[] getMyServices(){
        Object[] services = null;
        Object stub = null;

        try {
            stub = Naming.lookup("rmi://127.0.0.1/MyRMIServer");    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        rmiServer = (MyRMIServer) stub;

        try {
            services = rmiServer.getServiceList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return services;
    }

    public class ComboBoxListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            Object userSelect = comboBox.getSelectedItem();
            loadService(userSelect);
        }        
    }

    void loadService(Object userSelect){
        try{
            MyService service = rmiServer.getService(userSelect);
            panel.removeAll();
            panel.add(service.getGuiPanel());
            panel.validate();
            panel.repaint();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
