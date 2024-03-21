module program {
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.media;
    requires java.desktop;
    requires transitive com.opencsv;

    exports program;
    exports program.GUI;
    exports program.DataTypes.Classes;
    exports program.DataTypes.Enums;
}
