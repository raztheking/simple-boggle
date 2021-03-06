import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

public class GameScene {

    public static GridPane gridPane = new GridPane();

    public static Scene getScene() {
        BoggleGUI.stage.setTitle("Boggle");

        gridPane = new GridPane();
        for (int i = 0; i < Boggle.BOARD_SIZE; i++) {
            gridPane.getColumnConstraints().add(new ColumnConstraints(50));
            gridPane.getRowConstraints().add(new RowConstraints(50));
        }

        gridPane.add(new Text(Boggle.getCurrentPlayer().getName() +  ": " + Boggle.getCurrentPlayer().getScore()), 0, 0);
        gridPane.add(new Text("0"), Boggle.BOARD_SIZE-1, 0);

        gridPane.setAlignment(Pos.CENTER);
        updateBoard();

        TextField word = new TextField();
        Button submit = new Button("Submit");
        submit.setDefaultButton(true);
        gridPane.add(new Text("Word:"), 0, Boggle.BOARD_SIZE+1);
        gridPane.add(word, 1, Boggle.BOARD_SIZE+1);
        gridPane.add(submit, Boggle.BOARD_SIZE-1, Boggle.BOARD_SIZE+1);

        submit.setOnMouseClicked(e -> Boggle.handleTurn(word.getCharacters().toString()));

        return new Scene(gridPane, 600, 600);
    }

    public static void updateBoard() {
        for (int i = 0; i < Boggle.BOARD_SIZE; i++) {
            for (int j = 0; j < Boggle.BOARD_SIZE; j++) {
                gridPane.add(new Text(""+Boggle.board[i][j]), i, j+1);
            }
        }
    }

}
