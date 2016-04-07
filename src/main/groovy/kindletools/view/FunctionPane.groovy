package kindletools.view

import kindletools.Common
import kindletools.Utils

import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

/**
 * Created by 白 on 2016/4/7.
 */
class FunctionPane extends JPanel{

    JButton btnGenerateDir = new JButton("生成书籍目录")
    JButton btnDelSDR = new JButton("删除多余阅读记录")
    JButton btnChooseDir = new JButton("重新选择目录")
    JLabel labelPath = new JLabel(getCurrentPathString())
    ResultPane resultPane

    FunctionPane(ResultPane resultPane) {

        this.resultPane = resultPane
        setLayout(new GridLayout(0,1))

        btnGenerateDir.setFocusable(false)
        btnDelSDR.setFocusable(false)
        btnChooseDir.setFocusable(false)

        setClickListener()

        add(labelPath)
        JPanel jPanel1 = new JPanel()
        jPanel1.setLayout(new FlowLayout())
        jPanel1.add(btnChooseDir);
        add(jPanel1);

        JPanel jPanel2 = new JPanel()
        jPanel2.setLayout(new FlowLayout())
        jPanel2.add(btnGenerateDir)
        jPanel2.add(btnDelSDR)
        add(jPanel2);
    }

    void setClickListener() {
        btnGenerateDir.addActionListener(new ActionListener() {
            @Override
            void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(parent, "");
                resultPane.txtResult.setText(Utils.generateDirectory(true))
            }
        })

        btnDelSDR.addActionListener(new ActionListener() {
            @Override
            void actionPerformed(ActionEvent e) {
                resultPane.txtResult.setText(Utils.deleteSdr())
            }
        })

        btnChooseDir.addActionListener(new ActionListener() {
            @Override
            void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser()
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY)
                def flag = fc.showOpenDialog(null)
                if (flag == JFileChooser.APPROVE_OPTION) {
                    Common.path = fc.getSelectedFile().getPath()
                    labelPath.setText(getCurrentPathString())
                }
            }
        })
    }

    def getCurrentPathString() {
        "<html><body>" + new File(Common.path).getCanonicalPath() + "</body></html>"
    }
}
