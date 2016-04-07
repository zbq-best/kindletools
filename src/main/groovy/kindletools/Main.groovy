package kindletools

import kindletools.view.MainFrame

import javax.swing.*
/**
 * Created by 白 on 2016/4/7.
 */
class Main {

    static void main(def args) {

        if (new File("./documents").exists()) {
            Common.path = "./documents"
        } else {
            Common.path = "."
        }

        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel")

        JFrame frame = new MainFrame()
        frame.setVisible(true)
    }
}
