package GUI


import CryptLibary._
import javax.swing.border.EmptyBorder

import scala.swing._
import scala.swing.event.ButtonClicked

object ScalaGUI extends SimpleSwingApplication {

  private def outerBorder = new EmptyBorder(10, 10, 10, 10)

  private def innerBorder = new EmptyBorder(5, 0, 5, 0)

  val frame = new Frame {

    title = "Verschlüsselung"

    val button = new Button("Verschlüsseln")
    val combobox = new ComboBox[String](Seq("Blockverschlüsselung", "Vigeneréverfahren", "Bitverschlüsselung")) {
      border = innerBorder
    }
    val textPane = new TextPane {
      border = outerBorder
    }

    val passwordField = new PasswordField()


    contents = new GridPanel(1, 2) {

      contents += textPane
      contents += new GridPanel(3, 1) {
        contents += new BoxPanel(Orientation.Vertical) {
          contents += new Label("Schlüssel")
          contents += passwordField
          border = innerBorder
        }
        contents += combobox

        contents += button

        border = outerBorder

      }

    }

    listenTo(button)

    reactions += {
      case ButtonClicked(_) =>
        val text = textPane.peer.getText
        val passphrase: String = passwordField.peer.getPassword.mkString

        val newText: String = combobox.peer.getSelectedIndex match {
          case 0 => Blockweise.crypt(text)(Blockweise.genKey(passphrase))
          case 1 => Vigenére.encrypt(passphrase, text)
          case 2 => Binary.crypt(passphrase, text)
          case _ => "!<<ERROR>>!"
        }

        textPane.peer.setText(newText)
    }

  }

  def top = frame

}
