

import javax.swing.SwingUtilities;

public class main {
    public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				gui_thomas ex = new gui_thomas();
				ex.setVisible(true);
			}
		});

	}
}
