package src.error;

import javax.swing.JOptionPane;

public class MDCnot1anException extends RuntimeException {
    public MDCnot1anException (int a, int n, int primo) {
        super("O MDC entre a e n de alguma equação informada não é 1");
        JOptionPane.showMessageDialog(null, "O MDC entre " + a + " e " + n + " não é 1: " + primo);
    }
    
}
