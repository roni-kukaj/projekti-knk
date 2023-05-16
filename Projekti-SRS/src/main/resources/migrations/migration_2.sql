Use DB_SRS;

CREATE TABLE ColorSettings(
	id INTEGER PRIMARY KEY,
    color VARCHAR(10),
    logo VARCHAR(50),
    registerlogo VARCHAR(50),
    studentlogo VARCHAR(50),
    updatelogo VARCHAR(50),
    graphicslogo VARCHAR(50),
    settingslogo VARCHAR(50)
);

INSERT INTO ColorSettings VALUES(1, '#38B6FF', 'blue_logo_sm.png', 'blue_register_logo.png', 'blue_students_logo.png', 'blue_update_logo.png', 'blue_graphics_logo.png', 'blue_settings_logo.png');