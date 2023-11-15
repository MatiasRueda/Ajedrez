module ajedrez {
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires transitive javafx.media;
    requires javafx.fxml;

    opens ajedrez.controller to javafx.fxml;
    exports ajedrez;
}   
