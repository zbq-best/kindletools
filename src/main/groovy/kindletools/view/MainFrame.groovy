package kindletools.view

import javax.swing.Box
import javax.swing.BoxLayout
import javax.swing.JFrame
import javax.swing.JPanel
import java.awt.Font

/**
 * Created by 白 on 2016/4/7.
 */
class MainFrame extends JFrame{

    MainFrame() {
        super("Kindle工具箱")

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        setSize(300, 500)
        setFont(new Font("Helvetica",Font.PLAIN, 14));
        setLocationRelativeTo(null)

        JPanel jPanel = new JPanel()
        getContentPane().add(jPanel)
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS))
        jPanel.add(Box.createVerticalStrut(10))
        ResultPane resultPane = new ResultPane()
        jPanel.add(new FunctionPane(resultPane))
        jPanel.add(Box.createVerticalStrut(10))
        jPanel.add(resultPane);

    }
}
