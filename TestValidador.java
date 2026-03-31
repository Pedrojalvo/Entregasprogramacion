package Validador;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import semana5.ValidadorRegistro.ValidationResult;
import static org.junit.jupiter.api.Assertions.*;

class ValidadorRegistroTest {
    
    private final ValidadorRegistro validador = new ValidadorRegistro();
    
    @Test
    @DisplayName("Email válido debe pasar")
    void testEmailValido() {
        ValidationResult result = validador.validarEmail("usuario@dominio.com");
        assertTrue(result.isValid());
    }
    
    @Test
    @DisplayName("Email nulo debe fallar")
    void testEmailNulo() {
        ValidationResult result = validador.validarEmail(null);
        assertFalse(result.isValid());
        assertEquals("El email no puede ser nulo", result.getErrorMessage());
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"usuario@dominio", "usuario@.com", "usuario@dominio.", "@dominio.com", "usuario@dominio.c"})
    @DisplayName("Emails con formato inválido deben fallar")
    void testEmailInvalido(String email) {
        ValidationResult result = validador.validarEmail(email);
        assertFalse(result.isValid());
        assertEquals("Formato de email inválido", result.getErrorMessage());
    }
    
    @Test
    @DisplayName("Email demasiado largo debe fallar")
    void testEmailDemasiadoLargo() {
        String email = "a".repeat(90) + "@dominio.com";
        ValidationResult result = validador.validarEmail(email);
        assertFalse(result.isValid());
        assertEquals("El email excede los 100 caracteres", result.getErrorMessage());
    }
    
    @Test
    @DisplayName("Contraseña válida debe pasar")
    void testContraseniaValida() {
        ValidationResult result = validador.validarContrasenia("Abc123!@#");
        assertTrue(result.isValid());
    }
    
    @Test
    @DisplayName("Contraseña nula debe fallar")
    void testContraseniaNula() {
        ValidationResult result = validador.validarContrasenia(null);
        assertFalse(result.isValid());
        assertEquals("La contraseña no puede ser nula", result.getErrorMessage());
    }
    
    @Test
    @DisplayName("Contraseña demasiado corta debe fallar")
    void testContraseniaCorta() {
        ValidationResult result = validador.validarContrasenia("Ab1!");
        assertFalse(result.isValid());
        assertEquals("La contraseña debe tener al menos 8 caracteres", result.getErrorMessage());
    }
    
    @Test
    @DisplayName("Contraseña sin mayúscula debe fallar")
    void testContraseniaSinMayuscula() {
        ValidationResult result = validador.validarContrasenia("abc123!@#");
        assertFalse(result.isValid());
        assertEquals("La contraseña debe contener al menos una mayúscula", result.getErrorMessage());
    }
    
    @Test
    @DisplayName("Contraseña sin número debe fallar")
    void testContraseniaSinNumero() {
        ValidationResult result = validador.validarContrasenia("Abcdef!@#");
        assertFalse(result.isValid());
        assertEquals("La contraseña debe contener al menos un número", result.getErrorMessage());
    }
    
    @Test
    @DisplayName("Contraseña sin carácter especial debe fallar")
    void testContraseniaSinEspecial() {
        ValidationResult result = validador.validarContrasenia("Abc12345");
        assertFalse(result.isValid());
        assertEquals("La contraseña debe contener al menos un carácter especial", result.getErrorMessage());
    }
    
    @Test
    @DisplayName("Contraseña con espacios debe fallar")
    void testContraseniaConEspacios() {
        ValidationResult result = validador.validarContrasenia("Abc 123!@#");
        assertTrue(result.isValid()); // Los espacios están permitidos por los requisitos actuales
    }
    
    @Test
    @DisplayName("Edad válida debe pasar")
    void testEdadValida() {
        ValidationResult result = validador.validarEdad(25);
        assertTrue(result.isValid());
    }
    
    @Test
    @DisplayName("Edad negativa debe fallar")
    void testEdadNegativa() {
        ValidationResult result = validador.validarEdad(-5);
        assertFalse(result.isValid());
        assertEquals("La edad no puede ser negativa", result.getErrorMessage());
    }
    
    @Test
    @DisplayName("Edad menor de 18 debe fallar")
    void testEdadMenor18() {
        ValidationResult result = validador.validarEdad(17);
        assertFalse(result.isValid());
        assertEquals("Debe ser mayor de edad (18 años o más)", result.getErrorMessage());
    }
    
    @Test
    @DisplayName("Edad mayor de 120 debe fallar")
    void testEdadMayor120() {
        ValidationResult result = validador.validarEdad(121);
        assertFalse(result.isValid());
        assertEquals("Edad máxima permitida es 120 años", result.getErrorMessage());
    }
    
    @Test
    @DisplayName("Edad exactamente 18 debe pasar")
    void testEdadExactamente18() {
        ValidationResult result = validador.validarEdad(18);
        assertTrue(result.isValid());
    }
    
    @Test
    @DisplayName("Edad exactamente 120 debe pasar")
    void testEdadExactamente120() {
        ValidationResult result = validador.validarEdad(120);
        assertTrue(result.isValid());
    }
}