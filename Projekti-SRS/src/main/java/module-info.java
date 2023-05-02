module com.example.projektisrs {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires jbcrypt;
    requires java.sql;
    requires java.desktop;
    requires pdfbox;

    opens com.example.projektisrs to javafx.fxml, javafx.graphics;
    opens controllers to javafx.fxml, javafx.graphics;
    exports com.example.projektisrs;
    opens models to javafx.base;

}