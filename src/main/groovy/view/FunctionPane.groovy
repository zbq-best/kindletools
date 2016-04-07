package view

import utils.Utils

import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

/**
 * Created by 白 on 2016/4/7.
 */
class FunctionPane extends JPanel{

    JButton btnGenerateDir = new JButton();
    JButton btnDelSDR = new JButton()

    ResultPane resultPane;

    FunctionPane(JFrame parent, ResultPane resultPane) {

        this.resultPane = resultPane

        btnInit()

        setLayout(new FlowLayout())
        add(btnGenerateDir)
        add(btnDelSDR)
    }

    void btnInit() {
        btnGenerateDir.setText("生成书籍目录")
        btnDelSDR.setText("删除多余阅读记录")
        btnGenerateDir.setFocusable(false)
        btnDelSDR.setFocusable(false)

        setClickListener();
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
    }
}
