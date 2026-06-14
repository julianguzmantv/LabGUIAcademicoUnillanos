package com.campus.main;

import javax.swing.SwingUtilities;

import com.campus.view.MainFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}
