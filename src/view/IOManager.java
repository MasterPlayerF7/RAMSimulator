package view;

import javax.swing.*;

public class IOManager {

    private static final byte ZERO_ELEMENT = 0;

    private IOManager() {}

    private static Object showInputDialog(String message, String title, Object[] options) {
        return JOptionPane.showInputDialog(null, message,
                title, JOptionPane.PLAIN_MESSAGE,null, options, options == null ? null : options[ZERO_ELEMENT]);
    }

    public static Object getObject(String requirement, String title, Object[] options) {
        return showInputDialog(requirement, title, options);
    }

    public static Object getObject(String requirement, String title) {
        return showInputDialog(requirement, title, null);
    }

    public static String getString(String requirement, String title) {
        return getObject(requirement, title, null).toString();
    }

    public static String getString(String requirement) {
        return getObject(requirement, "", null).toString();
    }

    public static void showOutputDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showOutputDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.INFORMATION_MESSAGE);
    }

}
