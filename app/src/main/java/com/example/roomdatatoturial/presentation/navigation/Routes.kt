package com.example.roomdatatoturial.presentation.navigation

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

sealed class Routes {

    @Serializable
    object  HomePage

    @Serializable
    object AddContact
}