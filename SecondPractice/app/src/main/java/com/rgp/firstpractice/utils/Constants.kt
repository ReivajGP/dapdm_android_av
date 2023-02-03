package com.rgp.firstpractice.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants {

    // Networking
    const val BASE_URL = "https://private-295f5-lyricsbook.apiary-mock.com/"  // Con el slash al final
    const val SONGS_LIST_EP = "songslist"
    const val SONGS_LYRICS_EP = "lyrics"
    const val NO_NETWORK = "NO_NETWORK"

    // Authentication
    const val AUTH_ERROR_INVALID_EMAIL = "ERROR_INVALID_EMAIL"
    const val AUTH_ERROR_WRONG_PASSWORD = "ERROR_WRONG_PASSWORD"
    const val AUTH_ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_PROVIDER = "ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL"
    const val AUTH_ERROR_EMAIL_IN_USE = "ERROR_EMAIL_ALREADY_IN_USE"
    const val AUTH_ERROR_TOKEN_EXPIRED = "ERROR_USER_TOKEN_EXPIRED"
    const val AUTH_ERROR_USER_NOT_FOUND = "ERROR_USER_NOT_FOUND"
    const val AUTH_ERROR_WEAK_PASSWORD = "ERROR_WEAK_PASSWORD"

    const val AUTH_MESSAGE_INVALID_EMAIL = "Formato de correo incorrecto"
    const val AUTH_MESSAGE_WRONG_PASSWORD = "Contraseña inválida"
    const val AUTH_MESSAGE_ACCOUNT_EXISTS_WITH_DIFFERENT_PROVIDER = "La cuenta de correo ya ha sido registrada"
    const val AUTH_MESSAGE_EMAIL_IN_USE = "El correo ingresado se encuentra registrado"
    const val AUTH_MESSAGE_TOKEN_EXPIRED = "La sesión ha expirado, intenta ingresar nuevamente"
    const val AUTH_MESSAGE_USER_NOT_FOUND = "Usuario no encontrado"
    const val AUTH_MESSAGE_WEAK_PASSWORD = "La contraseña debe contener al menos 6 caracteres"
    const val AUTH_MESSAGE_NO_NETWORK = "Problema de conexión a Internet"

    const val AUTH_MESSAGE_SUCCESFUL_LOGIN = "Autenticación exitosa"
    const val AUTH_MESSAGE_REGISTER_MAIL_SENT = "Se ha enviado un correo de confirmación"
    const val AUTH_MESSAGE_REGISTER_MAIL_NOT_SENT = "No se logró enviar el correo de confirmación"

    const val AUTH_RESET_PASS_ALERT_DIALOG_TITLE = "Restablecer contraseña"
    const val AUTH_RESET_PASS_ALERT_DIALOG_MESSAGE = "Ingrese su correo para recibir el enlace para restablecer contraseña"
    const val AUTH_RESET_PASS_ALERT_DIALOG_SEND_BUTTON_CAPTION = "Enviar"
    const val AUTH_RESET_PASS_ALERT_DIALOG_CANCEL_BUTTON_CAPTION = "Cancelar"
    const val AUTH_RESET_PASS_ALERT_EMAIL_SENT_MESSAGE = "Se ha enviado un enlace al correo ingresado para restablecer la contraseña"

    // Splash
    const val TIMER_MILLISECONDS: Long = 3000
    const val TIMER_COUNTDOWN_INTERVAL: Long = 1000

    // Login
    const val ON_EMPTY_FIELD_TOAST_MESSAGE = "Para iniciar sesión debes ingresar ambos campos, correo electrónico y contraseña."
    const val INTENT_USER_ID = "user"

    // Catalog
    const val ON_FAIL_LOADING_CATALOG_TOAST_MESSAGE = "IMPOSIBLE CARGAR CATÁLOGO"
    const val INTENT_SONG_ID = "Song"
    const val USER_TEXT_VIEW_BASE_CAPTION = "Usuario:"
    const val ANIMATION_SPEED = 2.0F

    // Details
    const val ON_FAIL_LOADING_LYRICS_TOAST_MESSAGE = "IMPOSIBLE CARGAR LETRA"

    // Map
    const val INTENT_ARTIST_ID = "artist"
    const val INTENT_ARTIST_ORIGIN_LATITUDE = "origin_latitude"
    const val INTENT_ARTIST_ORIGIN_LONGITUDE = "origin_longitude"
    const val LOCATION_SNIPPET = "Here is where this legend began..."
    const val DEFAULT_DOUBLE_VALUE = 0.0
    const val MAP_STARTING_ANIMATION_ZOOM = 10f
    const val MAP_STARTING_ANIMATION_MILLISECONDS = 4000
    const val RESIZED_ICON_HEIGHT = 150
    const val RESIZED_ICON_WIDTH = 150

    // Entities serializable ID's
    const val TITLE_SERIALIZED_NAME = "song"
    const val RELEASE_DATE_SERIALIZED_NAME = "release_date"
    const val SONG_ID_SERIALIZED_NAME = "song_id"
    const val ID_PARAM_SERIALIZED_NAME = "id"
    const val ARTIST_ORIGIN_LATITUDE_SERIALIZED_NAME = "artist_origin_latitude"
    const val ARTIST_ORIGIN_LONGITUDE_SERIALIZED_NAME = "artist_origin_longitude"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}