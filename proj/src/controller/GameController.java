
        package controller;

        import view.Chessboard;

        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.util.List;

public class GameController {
    private Chessboard chessboard;

    public GameController(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public List<String> loadGameFromFile(String path) {
        try {
            List<String> chessData = Files.readAllLines(Path.of(path));
            if (path.endsWith(".txt")) {
                chessData.add(".txt");//判断格式，传到chessboard的load里面继续判断、
            }
            if (!path.endsWith(".txt")) chessData.add(path.substring(path.indexOf("."), path.length()));
            chessboard.loadGame(chessData);
            return chessData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> cunDangGameAsFile() {
        return chessboard.cunDangGame();
    }


}

