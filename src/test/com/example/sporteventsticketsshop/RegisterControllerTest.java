package com.example.sporteventsticketsshop;

import com.example.sporteventsticketsshop.controllers.RegisterController;
import com.example.sporteventsticketsshop.database.NitriteDB;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith({ApplicationExtension.class, MockitoExtension.class})
public class RegisterControllerTest {
    private RegisterController registerController;
    @Mock
    private NitriteDB dbMock;

    @BeforeEach
    public void setUp() throws Exception {
        FxToolkit.registerPrimaryStage();
        registerController = new RegisterController();
        registerController.setUsername(new TextField());
        registerController.setPassword(new PasswordField());
        registerController.setUsernameTaken(new Label());
        registerController.setRole(new ChoiceBox<>());
        registerController.getRole().getItems().addAll(Arrays.asList("Customer", "Organizer"));
        registerController.setM(new Main());
        registerController.setDb(dbMock);
    }

    @AfterEach
    public void tearDown() throws TimeoutException {
        FxToolkit.cleanupStages();
    }

    @Test
    @DisplayName("Register with missing username")
    void testUserRegister_WithMissingUsername(FxRobot robot) throws IOException {
        // Arrange
        registerController.getPassword().setText("password");
        registerController.getRole().getItems().add("Customer");
        registerController.getRole().getSelectionModel().select("Customer");

        // Act
        registerController.userRegister(null);

        // Assert
        assertEquals("Please fill in the username field", registerController.getUsernameTaken().getText());
        verifyNoInteractions(dbMock);
    }

    @Test
    @DisplayName("Register with missing password")
    void testUserRegister_WithMissingPassword(FxRobot robot) throws IOException {
        // Arrange
        registerController.getUsername().setText("john");
        registerController.getRole().getItems().add("Customer");
        registerController.getRole().getSelectionModel().select("Customer");

        // Act
        registerController.userRegister(null);

        // Assert
        assertEquals("Please fill in the password field", registerController.getUsernameTaken().getText());
        verifyNoInteractions(dbMock);
    }

    @Test
    @DisplayName("Register with missing role")
    void testUserRegister_WithMissingRole(FxRobot robot) throws IOException {
        // Arrange
        registerController.getUsername().setText("john");
        registerController.getPassword().setText("password");

        // Act
        registerController.userRegister(null);

        // Assert
        assertEquals("Please fill in the role field", registerController.getUsernameTaken().getText());
        verifyNoInteractions(dbMock);
    }
}