package Validador;

import java.util.regex.Pattern;

public class ValidadorRegistro {
    
    public static class ValidationResult {
        private final boolean isValid;
        private final String errorMessage;
        
        public ValidationResult(boolean isValid, String errorMessage) {
            this.isValid = isValid;
            this.errorMessage = errorMessage;
        }
        
        public boolean isValid() { return isValid; }
        public String getErrorMessage() { return errorMessage; }
    }
    
    public ValidationResult validarEmail(String email) {
        if (email == null) {
            return new ValidationResult(false, "El email no puede ser nulo");
        }
        
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!Pattern.matches(emailRegex, email)) {
            return new ValidationResult(false, "Formato de email inválido");
        }
        
        if (email.length() > 100) {
            return new ValidationResult(false, "El email excede los 100 caracteres");
        }
        
        return new ValidationResult(true, "Email válido");
    }
    
    public ValidationResult validarContrasenia(String contrasenia) {
        if (contrasenia == null) {
            return new ValidationResult(false, "La contraseña no puede ser nula");
        }
        
        if (contrasenia.length() < 8) {
            return new ValidationResult(false, "La contraseña debe tener al menos 8 caracteres");
        }
        
        if (contrasenia.length() > 50) {
            return new ValidationResult(false, "La contraseña no puede exceder los 50 caracteres");
        }
        
        if (!Pattern.compile("[A-Z]").matcher(contrasenia).find()) {
            return new ValidationResult(false, "La contraseña debe contener al menos una mayúscula");
        }
        
        if (!Pattern.compile("[a-z]").matcher(contrasenia).find()) {
            return new ValidationResult(false, "La contraseña debe contener al menos una minúscula");
        }
        
        if (!Pattern.compile("[0-9]").matcher(contrasenia).find()) {
            return new ValidationResult(false, "La contraseña debe contener al menos un número");
        }
        
        if (!Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]").matcher(contrasenia).find()) {
            return new ValidationResult(false, "La contraseña debe contener al menos un carácter especial");
        }
        
        return new ValidationResult(true, "Contraseña válida");
    }
    
    public ValidationResult validarEdad(int edad) {
        if (edad < 0) {
            return new ValidationResult(false, "La edad no puede ser negativa");
        }
        
        if (edad < 18) {
            return new ValidationResult(false, "Debe ser mayor de edad (18 años o más)");
        }
        
        if (edad > 120) {
            return new ValidationResult(false, "Edad máxima permitida es 120 años");
        }
        
        return new ValidationResult(true, "Edad válida");
    }
}