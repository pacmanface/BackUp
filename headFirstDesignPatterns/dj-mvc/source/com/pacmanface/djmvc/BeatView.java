package com.pacmanface.djmvc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.pacmanface.djmvc.interfaces.BPMObserver;
import com.pacmanface.djmvc.interfaces.BeatModel;
import com.pacmanface.djmvc.interfaces.BeatObserver;
import com.pacmanface.djmvc.interfaces.BeatController;

public class BeatView implements ActionListener, BPMObserver, BeatObserver{

    BeatModel model;
    BeatController controller;
    
    JFrame viewFrame;
    JPanel viewPanel;
    JLabel bpmOutputLabel;
    BeatBar beatBar;
    
    JFrame controlFrame;
    JPanel controlPanel;
    JLabel bpmLabel;
    JTextField bpmTextField;
    JButton setBPMButton;
    JButton increaseBPMButton;
    JButton decreaseBPMButton;
    JMenu menu;
    JMenuBar menuBar;
    JMenuItem startMenuItem;
    JMenuItem stopMenuItem;

    public BeatView(BeatModel b, BeatController c){
        model = b;
        controller = c;
        model.registerObserver((BPMObserver)this);
        model.registerObserver((BeatObserver)this);
    }

    public void createView(){
        viewPanel = new JPanel(new GridLayout(1,2));
        viewFrame = new JFrame("View");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100,80));
        bpmOutputLabel = new JLabel("offline",SwingConstants.CENTER);
        beatBar = new BeatBar();
        beatBar.setValue(0);
        JPanel bpmPanel = new JPanel(new GridLayout(2,1));
        bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel,BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
    }

    public void createControls(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        controlFrame = new JFrame("Control");
        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(new Dimension(100,80));
        controlPanel = new JPanel(new GridLayout(1,2));
        menuBar = new JMenuBar();
        menu = new JMenu("DJControl");
        startMenuItem = new JMenuItem("Start");
        stopMenuItem = new JMenuItem("Stop");
        JMenuItem exit = new JMenuItem("exit");
        menu.add(startMenuItem);
        menu.add(stopMenuItem);
        menu.add(exit);
        startMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                controller.start();
            }
        });
        stopMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                controller.stop();
            }
        });
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
        });
        menuBar.add(menu);
        controlFrame.setJMenuBar(menuBar);
        
        bpmTextField = new JTextField(2);
    	bpmLabel = new JLabel("enter bpm ",SwingConstants.RIGHT);
    	setBPMButton = new JButton("Set");
       	setBPMButton.setSize(new Dimension(10,40));
       	increaseBPMButton = new JButton(">>");
       	decreaseBPMButton = new JButton("<<");
       	setBPMButton.addActionListener(this);
       	increaseBPMButton.addActionListener(this);
       	decreaseBPMButton.addActionListener(this);
       	
       	JPanel buttonPanel = new JPanel(new GridLayout(1,2)); 	
       	buttonPanel.add(decreaseBPMButton);
       	buttonPanel.add(increaseBPMButton);
       	
       	JPanel enterPanel = new JPanel(new GridLayout(1,2));
       	enterPanel.add(bpmLabel);
       	enterPanel.add(bpmTextField);
       	
       	JPanel insideControlPanel = new JPanel(new GridLayout(3,1));
       	insideControlPanel.add(enterPanel);
       	insideControlPanel.add(setBPMButton);
       	insideControlPanel.add(buttonPanel);
       	controlPanel.add(insideControlPanel);
       	
       	bpmLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
       	bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
       	
       	controlFrame.getRootPane().setDefaultButton(setBPMButton);
       	controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);
       	
       	controlFrame.pack();
       	controlFrame.setVisible(true);       	
    }

    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource()==setBPMButton){
            int bpm = Integer.parseInt(bpmTextField.getText());
            controller.setBPM(bpm);
        }else if(event.getSource()==increaseBPMButton){
            controller.increaseBPM();
        }else if(event.getSource()==decreaseBPMButton){
            controller.decreaseBPM();    
        }
    }

    @Override
    public void updateBeat() {
        beatBar.setValue(100);        
    }

    @Override
    public void updateBPM() {
        int bpm = model.getBPM();
        if(bpm == 0){
            bpmOutputLabel.setText("offline");
        }else{
            bpmOutputLabel.setText("current bpm "+model.getBPM());
        }
        
    }

    public void enableStopMenuItem(){
        stopMenuItem.setEnabled(true);
    }

    public void disableStopMenuItem(){
        stopMenuItem.setEnabled(false);
    }

    public void enableStartMenuItem(){
        startMenuItem.setEnabled(true);
    }

    public void disableStartMenuItem(){
        startMenuItem.setEnabled(false);
    }
}
