package src.error;

import javax.swing.JOptionPane;

public class MDCnot1NException extends RuntimeException {
    public MDCnot1NException(int value, int value2) {
        super("O MDC entre os n's informados não é 1");
        JOptionPane.showMessageDialog(null, "O MDC entre os n informados não é 1: " + value + ", " + value2);
    }
}
