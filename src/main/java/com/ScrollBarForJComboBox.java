package com;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import java.awt.*;

class ScrollBarForJComboBox extends BasicComboBoxEditor {
    JScrollPane scroller = new JScrollPane();
    public ScrollBarForJComboBox() {
        super();
        scroller.setViewportView(editor);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }
    @Override
    public Component getEditorComponent() {
        return scroller;
    }

    @Override
    protected JTextField createEditorComponent() {
        JTextField editor = new JTextField();
        return editor;
    }

}