import view.FunctionPane
import view.ResultPane

import javax.swing.JFrame
import javax.swing.UIManager
import java.awt.BorderLayout
import java.awt.Font

/**
 * Created by 白 on 2016/4/7.
 */
class Main {
    static void main(def args) {

        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel")

        def jf = new JFrame("Kindle工具箱")
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        jf.setLayout(new BorderLayout());

        ResultPane resultPane = new ResultPane();
        jf.add(new FunctionPane(jf, resultPane), BorderLayout.NORTH);
        jf.add(resultPane, BorderLayout.CENTER);

        jf.setSize(300, 500)
        jf.setFont(new Font("Helvetica",Font.PLAIN, 14));
        jf.setLocationRelativeTo(null)
        jf.setVisible(true)
    }
}
