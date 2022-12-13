package com;

import javax.swing.*;


public class ProgressFrame implements Runnable{
    private JPanel contentPane;
    private JProgressBar progressBar;
    private JLabel label;

    private JFrame contentFrame;

    private boolean exit;
    private String message;

    Thread progressThread;

    public ProgressFrame(String message, String title){

        this.message = message;
        label.setText(message);

        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setValue(16);

        contentFrame = new JFrame(title);
        contentFrame.setVisible(false);
        contentFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        contentFrame.setResizable(false);
        contentFrame.setContentPane(contentPane);
        contentFrame.pack();
        contentFrame.setLocationRelativeTo(null);


        exit = false;
        progressThread = new Thread(this);
        progressThread.start();

    }


    @Override
    public void run() {
        contentFrame.setVisible(true);
        int dotNumber = 0;
        while (!exit) {

            if(progressBar.getValue() < 94){progressBar.setValue(progressBar.getValue() + 2);}
            if(progressBar.getValue() == 94){progressBar.setValue(16);}
            if(dotNumber == 0){label.setText(message + "."); dotNumber++;}
            else if(dotNumber == 1){label.setText(message + ".."); dotNumber++;}
            else if(dotNumber == 2){label.setText(message + "..."); dotNumber++;}
            else if(dotNumber == 3){label.setText(message); dotNumber = 0;}

            try {
                Thread.sleep(500);
            } catch (Exception ignored) {}

        }

        progressBar.setValue(100);
        contentFrame.dispose();

    }

    public void stopIt(){
        exit = true;
    }

}

