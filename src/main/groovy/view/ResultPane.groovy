package view
import javax.swing.*
import java.awt.BorderLayout

/**
 * Created by 白 on 2016/4/7.
 */
class ResultPane extends JPanel{

    JTextArea txtResult = new JTextArea()

    ResultPane() {
        setLayout(new BorderLayout())
        txtResult.setEditable(false)
        txtResult.setLineWrap(true)
        add(new JScrollPane(txtResult), BorderLayout.CENTER)
    }
}
