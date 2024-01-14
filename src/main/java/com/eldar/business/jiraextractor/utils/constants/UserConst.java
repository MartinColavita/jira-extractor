package com.eldar.business.jiraextractor.utils.constants;

/**
 * @author claudio.vilas
 * date 01/2024
 * description constantes para mensajes de usuarios
 */

public class UserConst {
    public static final String U_NAME_EMPTY = "el nombre es requerido";
    public static final String U_SURNAME_EMPTY = "el apellido es requerido";
    public static final String U_USERNAME_EMPTY = "el username es requerido";
    public static final String U_USERNAME_EXISTS = "el username ya existe";
    public static final String U_PASSWORD_EMPTY = "la contraseña es requerida";
    public static final String U_EMAIL_EMPTY = "el email es requerido";
    public static final String U_EMAIL_EXISTS = "ya esta registrado el email: ";
    public static final String U_EMAIL_MALFORMED = "formato de email invalido";
    public static final String U_USER_ID_NOT_FOUND = "no se encuentra un usuario con id ";
    public static final String U_NAME_NOT_FOUND = "no se encontraron usuarios con nombre ";
    public static final String U_EMAIL_IN_USE = "otro usuario tiene registrado el mail ";
    public static final String U_PASS_LENGHT_INVALID = "la contraseña debe tener entre 8 y 20 caracteres";
    public static final String U_PASS_MAL_FORMED = "contraseña invalida";
    public static final String U_USERNAME_NOT_FOUND = "usuario no encontrado";
    public static final String U_IS_ENABLED = "el usuario ya esta habilitado";
    public static final String U_IS_ADMIN = "el usuario ya tiene rol ADMINISTRADOR";
    public static final String U_PASS_NO_MATCH = "la contraseña no es correcta";
    public static final String U_NEW_PASS_FAIL = "fallo en la validacion de la nueva contraseña";
}
